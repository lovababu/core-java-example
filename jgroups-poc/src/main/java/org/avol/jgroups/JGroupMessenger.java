package org.avol.jgroups;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ObjectMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class JGroupMessenger {

    private static final String user_name = "Avol";
    private final JChannel J_CHANNEL;
    private final List<String> CLUSTER_STATE = new LinkedList<>();

    public JGroupMessenger() throws Exception {
        J_CHANNEL = new JChannel("src/main/resources/udp.xml");
        J_CHANNEL.setReceiver(new JGroupReceiver());
        J_CHANNEL.getState(null, 100, true); //method to sync this channel with the cluster, if this is new node to cluster.
        J_CHANNEL.connect("ChatCluster");
        eventLoop();
        J_CHANNEL.close();
    }

    private void eventLoop() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("> ");
                System.out.flush();
                String line = in.readLine().toLowerCase();
                if (line.startsWith("quit") || line.startsWith("exit"))
                    break;
                line = "[" + user_name + "] " + line;
                Message msg = new ObjectMessage(null, line);
                J_CHANNEL.send(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new JGroupMessenger();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
