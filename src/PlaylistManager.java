import java.util.Scanner;

/**
 * Manages playlists and provides a user interface for interaction.
 */
public class PlaylistManager {
	private PlaylistArrayList arrayListPlaylist = new PlaylistArrayList();
	private PlaylistLinkedList linkedListPlaylist = new PlaylistLinkedList();
	private RecentlyPlayedQueue recentlyPlayedQueue = new RecentlyPlayedQueue(5);
	private boolean useArrayList = true; // Toggles between ArrayList and LinkedList

	/**
	 * Starts the Playlist Manager's user interface.
	 */
	public void start() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\nPlaylist Manager Menu:");
			System.out.println("1. Add Song");
			System.out.println("2. Insert Song at Position");
			System.out.println("3. Remove Song");
			System.out.println("4. View Song");
			System.out.println("5. Shuffle Playlist");
			System.out.println("6. Print Playlist");
			System.out.println("7. Sort Playlist");
			System.out.println("8. Search for Song");
			System.out.println("9. View Recently Played Songs");
			System.out.println("10. Switch Playlist Type");
			System.out.println("11. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					addSong(scanner);
					break;
				case 2:
					insertSong(scanner);
					break;
				case 3:
					removeSong(scanner);
					break;
				case 4:
					viewSong(scanner);
					break;
				case 5:
					shufflePlaylist();
					break;
				case 6:
					printPlaylist();
					break;
				case 7:
					sortPlaylist(scanner);
					break;
				case 8:
					searchSong(scanner);
					break;
				case 9:
					recentlyPlayedQueue.printRecentlyPlayed();
					break;
				case 10:
					switchPlaylistType();
					break;
				case 11:
					scanner.close();
					return; // Exit the program
				default:
					System.out.println("Invalid choice.");
			}
		}
	}

	private void addSong(Scanner scanner) {
		Song song = createSong(scanner);
		if (useArrayList) {
			arrayListPlaylist.addSong(song);
		} else {
			linkedListPlaylist.addSong(song);
		}
	}

	private void insertSong(Scanner scanner) {
		Song song = createSong(scanner);
		System.out.print("Enter position: ");
		int index = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		if (useArrayList) {
			arrayListPlaylist.insertSong(index, song);
		} else {
			linkedListPlaylist.insertSong(index, song);
		}
	}

	private void removeSong(Scanner scanner) {
		System.out.print("Enter position to remove: ");
		int index = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		if (useArrayList) {
			arrayListPlaylist.removeSong(index);
		} else {
			linkedListPlaylist.removeSong(index);
		}
	}

	private void viewSong(Scanner scanner) {
		System.out.print("Enter position to view: ");
		int index = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		Song song = useArrayList ? arrayListPlaylist.getSong(index) : linkedListPlaylist.getSong(index);
		if (song != null) {
			System.out.println(song);
			recentlyPlayedQueue.addRecentlyPlayed(song);
		} else {
			System.out.println("Invalid position.");
		}
	}

	private void shufflePlaylist() {
		if (useArrayList) {
			arrayListPlaylist.shuffle();
		} else {
			linkedListPlaylist.shuffle();
		}
	}

	private void printPlaylist() {
		if (useArrayList) {
			arrayListPlaylist.printPlaylist();
		} else {
			linkedListPlaylist.printPlaylist();
		}
	}

	private void sortPlaylist(Scanner scanner) {
		System.out.println("Choose sort type: 1. Title 2. Artist 3. Duration");
		int sortChoice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (sortChoice) {
			case 1:
				if (useArrayList) {
					arrayListPlaylist.sortByTitle();
				} else {
					linkedListPlaylist.sortByTitle();
				}
				break;
			case 2:
				if (useArrayList) {
					arrayListPlaylist.sortByArtist();
				} else {
					linkedListPlaylist.sortByArtist();
				}
				break;
			case 3:
				if (useArrayList) {
					arrayListPlaylist.sortByDuration();
				} else {
					linkedListPlaylist.sortByDuration();
				}
				break;
			default:
				System.out.println("Invalid choice.");
		}
	}

	private void searchSong(Scanner scanner) {
		System.out.println("Search by: 1. Title 2. Artist");
		int searchChoice = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter search term: ");
		String term = scanner.nextLine();

		int index = -1;
		if (searchChoice == 1) {
			index = useArrayList ? arrayListPlaylist.searchByTitle(term) : linkedListPlaylist.searchByTitle(term);
		} else if (searchChoice == 2) {
			index = useArrayList ? arrayListPlaylist.searchByArtist(term) : linkedListPlaylist.searchByArtist(term);
		}

		if (index != -1) {
			System.out.println("Song found at position: " + index);
		} else {
			System.out.println("Song not found.");
		}
	}

	private void switchPlaylistType() {
		useArrayList = !useArrayList;
		System.out.println("Switched to " + (useArrayList ? "ArrayList" : "LinkedList") + " playlist.");
	}

	private Song createSong(Scanner scanner) {
		System.out.print("Enter song title: ");
		String title = scanner.nextLine();
		System.out.print("Enter artist name: ");
		String artist = scanner.nextLine();
		System.out.print("Enter duration in seconds: ");
		int duration = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		return new Song(title, artist, duration);
	}
}

