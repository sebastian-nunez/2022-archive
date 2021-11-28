import java.util.ArrayList;

/**
 * The {@code PlatformUtilities} interface imposes some basic 'utility' methods for any streaming platform.
 */
public interface PlatformUtilities {

    public String TopStreamer();

    public String TopStreamerInCategory(String category);

    public Integer ViewsInCategory(String category);

    public ArrayList<String> StreamersInCategory(String category);

}
