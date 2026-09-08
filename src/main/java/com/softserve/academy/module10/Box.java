package com.softserve.academy.module10;

public class Box implements Cloneable {
    private int width;
    private int height;
    private int depth;

    private Payload payload;

    public Box(int width, int height, int depth, Payload payload) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.payload = payload;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Payload getPayload() {
        return payload;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public Box clone() {
        try {
            Box cloned = (Box) super.clone();
            cloned.payload = this.payload.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should never happen
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                ", payload=" + payload +
                '}';
    }

    static class Payload implements Cloneable {
        private String content;

        public Payload(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Payload{" +
                    "content='" + content + '\'' +
                    '}';
        }

        @Override
        public Payload clone() {
            try {
                return (Payload) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(); // Should never happen
            }
        }
    }
}