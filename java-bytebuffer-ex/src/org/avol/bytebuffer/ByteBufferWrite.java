package org.avol.bytebuffer;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ByteBufferWrite {


    private static String bigTextFile = "test.txt";

    public static void main(String[] args) throws Exception {
        // Create file object
        File file = new File(bigTextFile);

        //Delete the file; we will create a new file
        boolean isDeleted = file.delete();
        System.out.println("isDeleted -> " + isDeleted);
        boolean isContinue = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Body >");
            String input = scanner.nextLine();
            Message message = new Message();
            message.setBody(input);
            System.out.println("Enter Node Id >");
            String nodeId = scanner.nextLine();
            Message.Node node = new Message.Node();
            node.setId(nodeId);
            node.setName("Node-" + nodeId);
            Message.Header header = new Message.Header();
            header.getNodeList().add(node);
            message.setHeader(header);

            try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
                // Get file channel in read-write mode
                FileChannel fileChannel = randomAccessFile.getChannel();

                //Write the content using put methods
                // Get direct byte buffer access using channel.map() operation //TODO: what could be the position and size.
                MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, (file.length()) + 1024 * 8);
                //write to file.
                buffer.put(message.getHeader().getId().getBytes(StandardCharsets.UTF_8));
                buffer.put("|".getBytes(StandardCharsets.UTF_8));
                buffer.put(message.getBody().getBytes(StandardCharsets.UTF_8));
                buffer.put("|".getBytes(StandardCharsets.UTF_8));
                message.getHeader().getNodeList().forEach(node1 -> {
                    buffer.put(node1.getId().getBytes(StandardCharsets.UTF_8));
                    buffer.put("|".getBytes(StandardCharsets.UTF_8));
                    buffer.put(node1.getName().getBytes(StandardCharsets.UTF_8));
                });
                buffer.put("\n".getBytes(StandardCharsets.UTF_8)); //next line char
                buffer.clear();
                fileChannel.close();
            }
            System.out.println("Would like to enter one more message ? (Y-Yes, N-No)");
            String ans = scanner.nextLine();
            if (ans.equalsIgnoreCase("No") || ans.equalsIgnoreCase("N")) {
                isContinue = false;
            }
        } while (isContinue);
    }
}
