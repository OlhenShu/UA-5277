package com.softserve.academy.module7.playlist;

public class PlayListDemo {

    private static Track[] buildLibrary() {
        return new Track[]{
                new Track("Song 1", "Artist A", 210),
                new Track("Song 2", "Artist B", 180),
                new Track("Song 3", "Artist C", 240),
                new Track("Song 4", "Artist D", 200),
                new Track("Song 5", "Artist E", 150)
        };
    }

    private static PlayList buildMorningPlaylist(Track[] library) {
        PlayList morningPlaylist = new PlayList("Morning Playlist");
        morningPlaylist.addTrack(library[0]);
        morningPlaylist.addTrack(library[1]);
        morningPlaylist.addTrack(library[2]);
        return morningPlaylist;
    }

    private static PlayList buildEveningPlaylist(Track[] library) {
        PlayList eveningPlaylist = new PlayList("Evening Playlist");
        eveningPlaylist.addTrack(library[3]);
        eveningPlaylist.addTrack(library[4]);
        eveningPlaylist.addTrack(library[0]);
        return eveningPlaylist;
    }

    private static boolean isTrackShared(PlayList p1, PlayList p2, Track track) {
        return contains(p1, track) && contains(p2, track);
    }

    private static boolean contains(PlayList playlist, Track track) {
        for (int i = 0; i < playlist.getTrackCount(); i++) {
            if (playlist.getTrack(i).equals(track)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Track[] library = buildLibrary();
        PlayList morningPlaylist = buildMorningPlaylist(library);
        PlayList eveningPlaylist = buildEveningPlaylist(library);

        System.out.println("Morning Playlist total duration: " + morningPlaylist.totalDuration() + " seconds");
        System.out.println("Evening Playlist total duration: " + eveningPlaylist.totalDuration() + " seconds");

        // Play some tracks
        morningPlaylist.playTrack(0);
        morningPlaylist.playTrack(1);
        eveningPlaylist.playTrack(0);
        eveningPlaylist.playTrack(2);

        System.out.println("Morning Playlist play history size: " + morningPlaylist.historySize());
        System.out.println("Evening Playlist play history size: " + eveningPlaylist.historySize());

        // Check if a track is shared between playlists
        Track trackToCheck = library[0]; // Song 1
        boolean isShared = isTrackShared(morningPlaylist, eveningPlaylist, trackToCheck);
        System.out.println("Is '" + trackToCheck.getTitle() + "' shared between playlists? " + isShared);

        //eveningPlaylist = null;

    }
}
