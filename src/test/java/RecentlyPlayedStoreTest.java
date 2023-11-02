import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.*;

public class RecentlyPlayedStoreTest {
	private RecentlyPlayedStore store;

	@BeforeTest
	public void setUp() {
		store = new RecentlyPlayedStore(3);
	}

	@Test
	public void testRecentlyPlayedSongs() {
		store.playSong("S1", "User1");
		store.playSong("S2", "User1");
		store.playSong("S3", "User1");

		store.playSong("S4", "User1");
		store.playSong("S2", "User1");
		store.playSong("S1", "User1");

		store.printRecentlyPlayedSongs();
	}
}
