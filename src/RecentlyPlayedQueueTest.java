import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecentlyPlayedQueueTest {

    private RecentlyPlayedQueue recentlyPlayedQueue;
    private Song song1, song2, song3, song4, song5, song6;

    @Before
    public void setUp() {
        recentlyPlayedQueue = new RecentlyPlayedQueue(5); // Queue size of 5
        song1 = new Song("Song One", "Artist A", 200);
        song2 = new Song("Song Two", "Artist B", 180);
        song3 = new Song("Song Three", "Artist A", 210);
        song4 = new Song("Song Four", "Artist C", 190);
        song5 = new Song("Song Five", "Artist D", 220);
        song6 = new Song("Song Six", "Artist E", 250);
    }

    @Test
    public void testAddRecentlyPlayed() {
        // Test adding songs to the Recently Played Queue
        recentlyPlayedQueue.addRecentlyPlayed(song1);
        recentlyPlayedQueue.addRecentlyPlayed(song2);
        recentlyPlayedQueue.addRecentlyPlayed(song3);
        recentlyPlayedQueue.addRecentlyPlayed(song4);
        recentlyPlayedQueue.addRecentlyPlayed(song5);
        recentlyPlayedQueue.addRecentlyPlayed(song6);

        assertEquals(5, recentlyPlayedQueue.getQueueSize());
        assertFalse(recentlyPlayedQueue.containsSong(song1)); // Song1 should be removed
        assertTrue(recentlyPlayedQueue.containsSong(song6)); // Song6 should be in the queue
    }

    @Test
    public void testPrintRecentlyPlayed() {
        // Test printing the recently played songs
        recentlyPlayedQueue.addRecentlyPlayed(song1);
        recentlyPlayedQueue.addRecentlyPlayed(song2);
        recentlyPlayedQueue.addRecentlyPlayed(song3);
        recentlyPlayedQueue.addRecentlyPlayed(song4);
        recentlyPlayedQueue.addRecentlyPlayed(song5);
        recentlyPlayedQueue.printRecentlyPlayed();
        // Output is printed, so manually verify the correct order (song1 to song5)
    }
}

