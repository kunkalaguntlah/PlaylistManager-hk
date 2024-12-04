import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Manages a playlist using a LinkedList.
 */
public class PlaylistLinkedList {
	private LinkedList<Song> playlist; // List of songs

	// Constructor to initialize the playlist
	public PlaylistLinkedList() {
		playlist = new LinkedList<>();
	}

	/**
	 * Adds a song to the end of the playlist.
	 * @param song The song to add.
	 */
	public void addSong(Song song) {
		playlist.add(song);
	}

	/**
	 * Inserts a song at a specific position in the playlist.
	 * @param index The position to insert the song.
	 * @param song  The song to insert.
	 */
	public void insertSong(int index, Song song) {
		if (index >= 0 && index <= playlist.size()) { // Validates index
			playlist.add(index, song);
		}
	}

	/**
	 * Removes a song at a specific position in the playlist.
	 * @param index The position of the song to remove.
	 */
	public void removeSong(int index) {
		if (index >= 0 && index < playlist.size()) { // Ensures index is valid
			playlist.remove(index);
		}
	}

	/**
	 * Retrieves a song at a specific index.
	 * @param index The position of the song.
	 * @return The song if the index is valid, otherwise null.
	 */
	public Song getSong(int index) {
		return (index >= 0 && index < playlist.size()) ? playlist.get(index) : null;
	}

	/**
	 * Randomly shuffles the order of songs in the playlist.
	 */
	public void shuffle() {
		Collections.shuffle(playlist);
	}

	/**
	 * Sorts the playlist by song title in ascending order.
	 */
	public void sortByTitle() {
		playlist.sort(Comparator.comparing(Song::getTitle));
	}

	/**
	 * Sorts the playlist by artist name in ascending order.
	 */
	public void sortByArtist() {
		playlist.sort(Comparator.comparing(Song::getArtist));
	}

	/**
	 * Sorts the playlist by duration in ascending order.
	 */
	public void sortByDuration() {
		playlist.sort(Comparator.comparingInt(Song::getDuration));
	}

	/**
	 * Searches for a song by title.
	 * @param title The title to search for.
	 * @return The index of the song, or -1 if not found.
	 */
	public int searchByTitle(String title) {
		for (int i = 0; i < playlist.size(); i++) {
			if (playlist.get(i).getTitle().equalsIgnoreCase(title)) {
				return i;
			}
		}
		return -1; // Not found
	}

	/**
	 * Searches for a song by artist.
	 * @param artist The artist to search for.
	 * @return The index of the song, or -1 if not found.
	 */
	public int searchByArtist(String artist) {
		for (int i = 0; i < playlist.size(); i++) {
			if (playlist.get(i).getArtist().equalsIgnoreCase(artist)) {
				return i;
			}
		}
		return -1; // Not found
	}

	/**
	 * Prints all songs in the playlist.
	 */
	public void printPlaylist() {
		for (Song song : playlist) {
			System.out.println(song); // Outputs each song
		}
	}
	// Getter method for testing
	public int getPlaylistSize() {
		return playlist.size();
	}

	// Method to check if song is in the playlist
	public boolean containsSong(Song song) {
		return playlist.contains(song);
	}
}

