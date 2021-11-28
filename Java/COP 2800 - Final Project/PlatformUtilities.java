import java.util.ArrayList;

public interface PlatformUtilities {

    public void StreamerOnline(String name, String category, Integer views);

    public void StreamerOffline(String name);

    public void UpdateViews(String name, String views);

    public void UpdateCategory(String name, String category);

    public String TopStreamer();

    public String TopStreamerInCategory(String category);

    public Integer ViewsInCategory(String category);

    public ArrayList<String> StreamersInCategory(String category);

}
