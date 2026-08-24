package com.softserve.academy.module7.playlist;

class PlayHistory {
    private final String[] entries = new String[100];
    private int size = 0;

    public void record(String trackTitle) {
        entries[size] = trackTitle;
        size++;
    }

    public int size() {
        return size;
    }
}
