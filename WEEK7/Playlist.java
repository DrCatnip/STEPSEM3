import java.util.Arrays;

public class Playlist {

    private String[] songs;
    private int songCount;

    // Constructor
    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    // Add a song
    public void addSong(String song) {

        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    // Return a copy of the songs
    public String[] getSongs() {

        return Arrays.copyOf(songs, songCount);
    }

    // Read-only count
    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs before modifying copy:");
        System.out.println(Arrays.toString(p.getSongs()));

        // Modify the returned copy
        copy[0] = "Hacked";

        System.out.println("Modified copy:");
        System.out.println(Arrays.toString(copy));

        System.out.println("Actual playlist:");
        System.out.println(Arrays.toString(p.getSongs()));

        System.out.println("Song count: " + p.getSongCount());
    }
}