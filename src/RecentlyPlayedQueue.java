import java.util.LinkedList;
import java.util.Queue;

/**
 * Tracks the last few songs played using a queue.
 */
public class RecentlyPlayedQueue {
	private Queue<Song> recentlyPlayed; // Queue to store recently played songs
	private int maxSize; // Maximum size of the queue

	/**
	 * Constructs a RecentlyPlayedQueue with a specified size limit.
	 * @param maxSize The maximum number of songs to store.
	 */
	public RecentlyPlayedQueue(int maxSize) {
		this.maxSize = maxSize;
		recentlyPlayed = new LinkedList<>();
	}

	/**
	 * Adds a song to the queue. Removes the oldest song if the queue exceeds its size limit.
	 * @param song The song to add.
	 */
	public void addRecentlyPlayed(Song song) {
		if (recentlyPlayed.size() == maxSize) { // Ensures size limit is maintained
			recentlyPlayed.poll(); // Removes the oldest song
		}
		recentlyPlayed.add(song);
	}

	/**
	 * Prints all the songs in the recently played queue in order.
	 */
	public void printRecentlyPlayed() {
		if (recentlyPlayed.isEmpty()) {
			System.out.println("No recently played songs.");
			return;
		}
		for (Song song : recentlyPlayed) {
			System.out.println(song); // Outputs each song
		}
	}
	// Getter method for testing
	public int getQueueSize() {
		return recentlyPlayed.size();
	}

	// Method to check if song is in the recently played queue
	public boolean containsSong(Song song) {
		return recentlyPlayed.contains(song);
	}
}

