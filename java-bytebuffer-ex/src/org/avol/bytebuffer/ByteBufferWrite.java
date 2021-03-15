package org.avol.bytebuffer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ByteBufferWrite {


    private final Map<String, MessageIndex> INDEX = new HashMap<>();

    private static String BIG_FILE_PATH = "test.txt";

    private final File file;

    private volatile int CURRENT_BUFFER_POSITION = 0;

    public ByteBufferWrite() {
        // Create file object
        file = new File(BIG_FILE_PATH);
        //Delete the file; we will create a new file
        boolean isDeleted = file.delete();
        System.out.println("isDeleted -> " + isDeleted);
    }


    public int getCURRENT_BUFFER_POSITION() {
        return CURRENT_BUFFER_POSITION;
    }

    public void setCURRENT_BUFFER_POSITION(int newPosition) {
        this.CURRENT_BUFFER_POSITION = newPosition;
    }

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    public static Object deserialize(byte[] data)
            throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

    public synchronized void writeObject() throws IOException {
        boolean isContinue = true;
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            // Get file channel in read-write mode
            FileChannel fileChannel = randomAccessFile.getChannel();

            //Write the content using put methods
            // Get direct byte buffer access using channel.map() operation //TODO: what could be the position and size.
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, (file.length()) + 1024 * 8);
            do {
                int writeIndex = this.getCURRENT_BUFFER_POSITION();
                //reading user input.
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
                System.out.println("Byte Stream Write Index is:" + writeIndex);
                //writing message to file.
                buffer.position(writeIndex);
                buffer.put(message.getHeader().getId().getBytes(StandardCharsets.UTF_8));
                buffer.put("|".getBytes(StandardCharsets.UTF_8));
                buffer.put(message.getBody().getBytes(StandardCharsets.UTF_8));
                buffer.put("\n".getBytes(StandardCharsets.UTF_8)); //next line char
                //keep track of current buffer position.
                this.setCURRENT_BUFFER_POSITION(buffer.position());
                fileChannel.close();
                //record message index to in-memory.
                INDEX.put(message.getHeader().getId(),
                        new MessageIndex(message.getHeader().getId(), writeIndex, buffer.position()));
                System.out.println("Would like to enter one more message ? (Y-Yes, N-No)");
                String ans = scanner.nextLine();
                if (ans.equalsIgnoreCase("No") || ans.equalsIgnoreCase("N")) {
                    isContinue = false;
                }
            } while (isContinue);
            buffer.clear();
            fileChannel.close();
        }
    }

    public void searchMessage() throws IOException {
        boolean isContinue = true;
        Scanner scanner = new Scanner(System.in);
        do {
            if (this.INDEX.size() > 0) {
                this.INDEX.forEach((s, messageIndex) -> {
                    System.out.println(s + ", position: " + messageIndex.getStartPosition() + " - Size: "
                            + (messageIndex.getEndPosition() - messageIndex.getStartPosition()));
                });
            }
            System.out.println("Choose message from the above list to search > ");
            String id = scanner.nextLine();
            if (Objects.nonNull(id)) {
                MessageIndex msgIndex = INDEX.get(id);
                try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
                    //Get file channel in read-only mode
                    FileChannel fileChannel = randomAccessFile.getChannel();
                    MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0,
                            file.length());
                    byte[] streamOfBytes = new byte[msgIndex.getEndPosition() - msgIndex.getStartPosition()];
                    mappedByteBuffer.position(msgIndex.getStartPosition());
                    mappedByteBuffer.get(streamOfBytes);
                    System.out.println("*********** Search Result **************");
                    System.out.println(new String(streamOfBytes));
                    /*ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(streamOfBytes);
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    Message message = (Message) objectInputStream.readObject();
                    if (Objects.nonNull(message)) {
                        System.out.println("********** Search Result ****************");
                        System.out.println("Message Id: " + message.getHeader().getId());
                        System.out.println("Body: " + message.getBody());
                        System.out.print("Nodes List -> ");
                        message.getHeader().getNodeList().forEach(node -> {
                            System.out.print("[" + node.getName() + "]");
                        });
                    }*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Would you like to search more messages (Y/N)?");
            String ans = scanner.nextLine();
            if (!ans.equalsIgnoreCase("Y")) {
                isContinue = false;
            }
        } while (isContinue);
    }

    public static void main(String[] args) throws Exception {
        ByteBufferWrite byteBufferWrite = new ByteBufferWrite();
        boolean isContinue = true;
        do {
            System.out.println("Choose the Operation  (1 - Write, 2 - Search, 3 - Delete, 4 - Exit):");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    byteBufferWrite.writeObject();
                    break;
                case 2:
                    byteBufferWrite.searchMessage();
                    break;
                case 3:
                    break;
                default:
                    isContinue = false;
            }
        } while (isContinue);
    }
}
