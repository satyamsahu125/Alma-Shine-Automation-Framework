package utilities;

import java.util.concurrent.TimeUnit;
/**
 * Custom Wait Utility for Api Rate Limit
 */
public class WaitUtility {

	public static void waitForSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status safely
        }
    }
}
