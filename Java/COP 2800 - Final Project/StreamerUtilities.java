/**
 * The {@code StreamerUtilities} serves basic methods to manipulate individual streamer data.
 */
public interface StreamerUtilities {
    public void StreamerOnline(String name, String category, Integer views);

    public void StreamerOffline(String name);

    public void UpdateViews(String name, String views);

    public void UpdateCategory(String name, String category);
}
