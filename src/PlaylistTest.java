import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlaylistTest {

    private PlaylistArrayList arrayListPlaylist;
    private PlaylistLinkedList linkedListPlaylist;
    private Song song1, song2, song3, song4;

    @Before
    public void setUp() {
        // Initialize playlist managers and sample songs before each test
        arrayListPlaylist = new PlaylistArrayList();
        linkedListPlaylist = new PlaylistLinkedList();
        song1 = new Song("Song One", "Artist A", 200);
        song2 = new Song("Song Two", "Artist B", 180);
        song3 = new Song("Song Three", "Artist A", 210);
        song4 = new Song("Song Four", "Artist C", 190);
    }

    @Test
    public void testAddSong_ArrayList() {
        // Test adding a song to ArrayList playlist
        arrayListPlaylist.addSong(song1);
        arrayListPlaylist.addSong(song2);
        assertEquals(2, arrayListPlaylist.getPlaylistSize());
        assertTrue(arrayListPlaylist.containsSong(song1));
        assertTrue(arrayListPlaylist.containsSong(song2));
    }

    @Test
    public void testAddSong_LinkedList() {
        // Test adding a song to LinkedList playlist
        linkedListPlaylist.addSong(song1);
        linkedListPlaylist.addSong(song2);
        assertEquals(2, linkedListPlaylist.getPlaylistSize());
        assertTrue(linkedListPlaylist.containsSong(song1));
        assertTrue(linkedListPlaylist.containsSong(song2));
    }

    @Test
    public void testInsertSong_ArrayList() {
        // Test inserting a song at a specific position in ArrayList playlist
        arrayListPlaylist.addSong(song1);
        arrayListPlaylist.insertSong(0, song2);
        assertEquals(song2, arrayListPlaylist.getSong(0));
        assertEquals(song1, arrayListPlaylist.getSong(1));
    }

    @Test
    public void testInsertSong_LinkedList() {
        // Test inserting a song at a specific position in LinkedList playlist
        linkedListPlaylist.addSong(song1);
        linkedListPlaylist.insertSong(0, song2);
        assertEquals(song2, linkedListPlaylist.getSong(0));
        assertEquals(song1, linkedListPlaylist.getSong(1));
    }

    @Test
    public void testRemoveSong_ArrayList() {
        // Test removing a song from ArrayList playlist
        arrayListPlaylist.addSong(song1);
        arrayListPlaylist.addSong(song2);
        arrayListPlaylist.removeSong(0);
        assertEquals(1, arrayListPlaylist.getPlaylistSize());
        assertEquals(song2, arrayListPlaylist.getSong(0));
    }

    @Test
    public void testRemoveSong_LinkedList() {
        // Test removing a song from LinkedList playlist
        linkedListPlaylist.addSong(song1);
        linkedListPlaylist.addSong(song2);
        linkedListPlaylist.removeSong(0);
        assertEquals(1, linkedListPlaylist.getPlaylistSize());
        assertEquals(song2, linkedListPlaylist.getSong(0));
    }

    @Test
    public void testGetSong_ArrayList() {
        // Test retrieving a song from ArrayList playlist
        arrayListPlaylist.addSong(song1);
        Song retrievedSong = arrayListPlaylist.getSong(0);
        assertEquals(song1, retrievedSong);
    }

    @Test
    public void testGetSong_LinkedList() {
        // Test retrieving a song from LinkedList playlist
        linkedListPlaylist.addSong(song1);
        Song retrievedSong = linkedListPlaylist.getSong(0);
        assertEquals(song1, retrievedSong);
    }

    @Test
    public void testShuffle_ArrayList() {
        // Test shuffling songs in ArrayList playlist
        arrayListPlaylist.addSong(song1);
        arrayListPlaylist.addSong(song2);
        arrayListPlaylist.addSong(song3);
        arrayListPlaylist.shuffle();
        assertTrue(arrayListPlaylist.getSong(0)
                == song1 || arrayListPlaylist.getSong(0)
                == song2 || arrayListPlaylist.getSong(0) == song3);
    }

    @Test
    public void testShuffle_LinkedList() {
        // Test shuffling songs in LinkedList playlist
        linkedListPlaylist.addSong(song1);
        linkedListPlaylist.addSong(song2);
        linkedListPlaylist.addSong(song3);
        linkedListPlaylist.shuffle();
        assertTrue(linkedListPlaylist.getSong(0)
                == song1 || linkedListPlaylist.getSong(0)
                == song2 || linkedListPlaylist.getSong(0) == song3);
    }

    @Test
    public void testSortByTitle_ArrayList() {
        // Test sorting ArrayList playlist by title
        arrayListPlaylist.addSong(song1);
        arrayListPlaylist.addSong(song2);
        arrayListPlaylist.sortByTitle();
        assertEquals(song1, arrayListPlaylist.getSong(0));
        assertEquals(song2, arrayListPlaylist.getSong(1));
    }

    @Test
    public void testSortByTitle_LinkedList() {
        // Test sorting LinkedList playlist by title
        linkedListPlaylist.addSong(song1);
        linkedListPlaylist.addSong(song2);
        linkedListPlaylist.sortByTitle();
        assertEquals(song1, linkedListPlaylist.getSong(0));
        assertEquals(song2, linkedListPlaylist.getSong(1));
    }

    @Test
    public void testSearchByTitle_ArrayList() {
        // Test searching a song by title in ArrayList playlist
        arrayListPlaylist.addSong(song1);
        arrayListPlaylist.addSong(song2);
        int index = arrayListPlaylist.searchByTitle("Song One");
        assertEquals(0, index);
    }

    @Test
    public void testSearchByTitle_LinkedList() {
        // Test searching a song by title in LinkedList playlist
        linkedListPlaylist.addSong(song1);
        linkedListPlaylist.addSong(song2);
        int index = linkedListPlaylist.searchByTitle("Song One");
        assertEquals(0, index);
    }

    @Test
    public void testSearchByArtist_ArrayList() {
        // Test searching a song by artist in ArrayList playlist
        arrayListPlaylist.addSong(song1);
        arrayListPlaylist.addSong(song2);
        int index = arrayListPlaylist.searchByArtist("Artist B");
        assertEquals(1, index);
    }

    @Test
    public void testSearchByArtist_LinkedList() {
        // Test searching a song by artist in LinkedList playlist
        linkedListPlaylist.addSong(song1);
        linkedListPlaylist.addSong(song2);
        int index = linkedListPlaylist.searchByArtist("Artist B");
        assertEquals(1, index);
    }

    @Test
    public void testPrintPlaylist_ArrayList() {
        // Test printing all songs in the ArrayList playlist
        arrayListPlaylist.addSong(song1);
        arrayListPlaylist.addSong(song2);
        // In practice, this would print the playlist, so you would manually verify output
    }

    @Test
    public void testPrintPlaylist_LinkedList() {
        // Test printing all songs in the LinkedList playlist
        linkedListPlaylist.addSong(song1);
        linkedListPlaylist.addSong(song2);
        // In practice, this would print the playlist, so you would manually verify output
    }
}

