package com.softserve.academy.module7.playlist;

public class PlayList {
    private final String name;

    private final Track[] tracks = new Track[100];
    private final PlayHistory playHistory = new PlayHistory();
    private int trackCount = 0;

    public PlayList(String name) {
        this.name = name;
        //this.playHistory = new PlayHistory();
    }

    public void addTrack(Track track) {
        if (trackCount < tracks.length) {
            tracks[trackCount] = track;
            trackCount++;
        } else {
            System.out.println("Playlist is full. Cannot add more tracks.");
        }
    }

    public void playTrack(int index) {
        if (index >= 0 && index < trackCount) {
            Track track = tracks[index];
            System.out.println("Now playing: " + track);
            playHistory.record(track.getTitle());
        } else {
            System.out.println("Invalid track index.");
        }
    }

    public int totalDuration() {
        int totalDuration = 0;
        for (int i = 0; i < trackCount; i++) {
            totalDuration += tracks[i].getDurationSeconds();
        }
        return totalDuration;
    }

    public int historySize() {
        return playHistory.size();
    }

    public int getTrackCount() {
        return trackCount;
    }

    public Track getTrack(int index) {
        return tracks[index];
    }

}
