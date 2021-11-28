import java.util.ArrayList;

public interface PlatformUtilities {

    public boolean StreamerOnline(String name, String category, Integer views);

    public boolean StreamerOffline(String name);

    public boolean UpdateViews(String name, String views);

    public boolean UpdateCategory(String name, String category);

    public String TopStreamer();

    public String TopStreamerInCategory(String category);

    public Integer ViewsInCategory(String category);

    public ArrayList<String> StreamersInCategory(String category);

}
