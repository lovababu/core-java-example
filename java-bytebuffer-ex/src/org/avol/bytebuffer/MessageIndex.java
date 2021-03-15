package org.avol.bytebuffer;

public class MessageIndex {

    private String id;
    private int startPosition;
    private int endPosition;

    public MessageIndex(String id, int startPosition, int endPosition) {
        this.id = id;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public String getId() {
        return id;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }
}
