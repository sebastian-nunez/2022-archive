import java.util.ArrayList;

/**
 * The {@code Streamable} interface defines certain methods which any streaming platform must have.
 */
public interface Streamable {
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

    /**
     * Returns the name of the streamer with the most views within the streaming platform.
     * @return String name
     */
    public String TopStreamer();

    /**
     * Returns the name of the top streamer within a specific category.
     * @param category
     * @return String name
     */
    public String TopStreamerInCategory(String category);

    /**
     * Returns the total number of views within a category.
     * @param category
     * @return Integer views
     */
    public Integer ViewsInCategory(String category);

    /**
     * Returns the names of all the streamers within a specific category.
     * @param category
     * @return ArrayList<String> names
     */
    public ArrayList<String> StreamersInCategory(String category);
}
