/**
 * The {@code PlatformStreamerUtilities} serves basic methods to manipulate individual streamer data.
 */
public interface PlatformStreamerUtilities {
    /**
     * Creates a new {@code Streamer} and adds it to the streaming platform.
     * @param name
     * @param category
     * @param views
     */
    public void StreamerOnline(String name, String category, Integer views);

    /**
     * Removes a specific {@code Streamer} from the streaming platform.
     * @param name
     */
    public void StreamerOffline(String name);

    /**
     * Updates the number of active viewers of a particular {@code Streamer} within the streaming platform.
     * @param name
     * @param views
     */
    public void UpdateViews(String name, String views);

    /**
     * Updates the streaming category of a particular {@code Streamer} within the streaming platform.
     * @param name
     * @param category
     */
    public void UpdateCategory(String name, String category);
}
