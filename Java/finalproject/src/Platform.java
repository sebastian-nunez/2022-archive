import java.util.ArrayList;
import java.lang.Math;

public class Platform implements PlatformUtilities {
    private String platformName;
    private ArrayList<Streamer> streamers = new ArrayList<Streamer>();

    public Platform(String platformName) {
        this.platformName = platformName;
        System.out.println(platformName + " platform initiated!");
    }

    public Platform(String platformName, String[][] streamerData) {
        this.platformName = platformName;

        for (String[] data : streamerData) {
            String name = data[0];
            String category = data[1];
            Integer views = Integer.parseInt(data[2]);

            streamers.add(new Streamer(name, category, views));
        }

        System.out.println(platformName + " platform initiated!\n");
    }

    private boolean isStreamerOffline(String name) {
        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                return false;
            }
        }

        return true;
    }

    public boolean StreamerOnline(String name, String category, Integer views) {
        if (!isStreamerOffline(name)) {
            UpdateCategory(name, category);
            UpdateViews(name, "" + views);
            return false;
        }

        streamers.add(new Streamer(name, category, views));
        return true;
    }

    public boolean StreamerOffline(String name) {
        if (isStreamerOffline(name) || streamers.size() == 0) {
            return false;
        }

        for (int i = 0; i < streamers.size(); i++) {
            if (streamers.get(i).getName().equals(name)) {
                streamers.remove(i);
                break;
            }
        }

        return true;
    }

    public boolean UpdateViews(String name, String views) {
        if (isStreamerOffline(name)) {
            return false;
        }

        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                streamer.setViews(Integer.parseInt(views));
                break;
            }
        }

        return true;
    }

    public boolean UpdateCategory(String name, String category) {
        if (isStreamerOffline(name)) {
            return false;
        }

        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                streamer.setCategory(category);
                break;
            }
        }

        return true;
    }

    public String TopStreamer() {
        int maxIndex = 0;
        int maxViews = streamers.get(0).getViews();

        if (streamers.size() == 0) {
            return "All streamers are offline!\n";
        }

        for (int i = 1; i < streamers.size(); i++) {
            if (streamers.get(i).getViews() >= maxViews) {
                maxViews = streamers.get(i).getViews();
                maxIndex = i;
            }
        }

        return streamers.get(maxIndex).getName();
    }

    public String TopStreamerInCategory(String category) {
        ArrayList<Streamer> currentStreamers = new ArrayList<Streamer>();

        for (Streamer streamer : streamers) {
            if (streamer.getCategory().equals(category)) {
                currentStreamers.add(streamer);
            }
        }

        int maxIndex = 0;
        int maxViews = currentStreamers.get(0).getViews();
        for (int i = 0; i < currentStreamers.size(); i++) {
            if (currentStreamers.get(i).getViews() >= maxViews) {
                maxIndex = i;
            }
        }

        return currentStreamers.get(maxIndex).getName();
    }

    public Integer ViewsInCategory(String category) {
        int count = 0;

        for (Streamer streamer : streamers) {
            if (streamer.getCategory().equals(category)) {
                count += streamer.getViews();
            }
        }

        return count;
    }

    public ArrayList<String> StreamersInCategory(String category) {
        ArrayList<String> streamerNames = new ArrayList<String>();

        for (Streamer streamer : streamers) {
            if (streamer.getCategory().equals(category)) {
                streamerNames.add(streamer.getName());
            }
        }

        return streamerNames;
    }

    public static String compareStreamers(Streamer streamer1, Streamer streamer2) {
        Integer differenceInViews = Math.abs(streamer2.getViews() - streamer1.getViews());

        switch (streamer1.compareTo(streamer2)) {
            case 0:
                return "'" + streamer1.getName() + " has the same amount of viewers as " + streamer2.getName()
                        + "'\n";
            case 1:
                return "'" + streamer1.getName() + " has " + differenceInViews + " more viewers than "
                        + streamer2.getName()
                        + "'\n";
            case -1:
                return "'" + streamer1.getName() + " has " + differenceInViews + " less viewers than "
                        + streamer2.getName()
                        + "'\n";
            default:
                return "Invalid comparison between '" + streamer1.getName() + "' and '" + streamer2.getName()
                        + "'!\n";

        }
    }

    public Streamer getStreamer(String name) {
        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                return streamer;
            }
        }

        System.out.println("'" + name + "' is offline!\n");
        return new Streamer(name);
    }

    public String toString() {
        String output = "";

        if (streamers.size() == 0) {
            return "All streamers are offline!\n";
        }

        for (Streamer streamer : streamers) {
            output += streamer + "\n";
        }

        return output;
    }
}
