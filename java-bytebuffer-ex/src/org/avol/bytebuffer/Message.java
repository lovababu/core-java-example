package org.avol.bytebuffer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Message {

    private String body;

    private Header header;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public static class Header {
        private final String id = UUID.randomUUID().toString();
        private List<Node> nodeList = new ArrayList<>();

        public String getId() {
            return id;
        }

        public List<Node> getNodeList() {
            return nodeList;
        }

        public void setNodeList(List<Node> nodeList) {
            this.nodeList = nodeList;
        }
    }

    public static class Node {
        private String id;
        private String name;
        private boolean persisted;
        private boolean published;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isPersisted() {
            return persisted;
        }

        public void setPersisted(boolean persisted) {
            this.persisted = persisted;
        }

        public boolean isPublished() {
            return published;
        }

        public void setPublished(boolean published) {
            this.published = published;
        }
    }
}
