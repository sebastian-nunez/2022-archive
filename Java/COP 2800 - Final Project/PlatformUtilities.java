import java.util.ArrayList;

/**
 * The {@code PlatformUtilities} interface imposes some basic 'utility' methods for any streaming platform.
 */
public interface PlatformUtilities {

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
