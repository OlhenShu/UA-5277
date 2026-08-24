package com.softserve.academy.module7.playlist;

import java.util.Objects;

public class Track {
    private final String title;
    private final String artist;
    private final int durationSeconds;

    public Track(String title, String artist, int durationSeconds) {
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return durationSeconds == track.durationSeconds && Objects.equals(title, track.title) && Objects.equals(artist, track.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, durationSeconds);
    }

    @Override
    public String toString() {
        return "Track{" +
                "title - '" + title + '\'' +
                ", artist - '" + artist + '\'' +
                ", " + durationSeconds + " s" +
                '}';
    }

}
