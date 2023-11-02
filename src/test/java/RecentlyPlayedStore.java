import java.util.Map;
import java.util.LinkedHashMap;

public class RecentlyPlayedStore {

	private int capacity;
	private Map<String, String> songUserMap;

	public RecentlyPlayedStore(int capacity) {
		this.capacity = capacity;
		songUserMap = new LinkedHashMap<>(capacity, 0.75f, true);
	}

	public void playSong(String song, String user) {
		songUserMap.put(song, user);
		if (songUserMap.size() > capacity) {
			// Remove the least recently played song
			String leastRecentlyPlayed = songUserMap.entrySet().iterator().next().getKey();
			songUserMap.remove(leastRecentlyPlayed);
		}
	}

	public void printRecentlyPlayedSongs() {
		System.out.println("Recently Played Songs:");
		for (Map.Entry<String, String> entry : songUserMap.entrySet()) {
			System.out.println("Song: " + entry.getKey() + ", User: " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		RecentlyPlayedStore store = new RecentlyPlayedStore(3);

		store.playSong("S1", "User1");
		store.playSong("S2", "User1");
		store.playSong("S3", "User1");
		store.printRecentlyPlayedSongs();

		store.playSong("S4", "User1");
		store.printRecentlyPlayedSongs();

		store.playSong("S2", "User1");
		store.printRecentlyPlayedSongs();

		store.playSong("S1", "User1");
		store.printRecentlyPlayedSongs();
	}

}
