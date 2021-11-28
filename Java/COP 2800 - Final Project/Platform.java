import java.util.ArrayList;

public class Platform implements PlatformUtilities {
    private String platformName;
    private static ArrayList<Streamer> streamers = new ArrayList<Streamer>();

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

    private static boolean isStreamerOffline(String name) {
        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                return false;
            }
        }

        return true;
    }

    public void StreamerOnline(String name, String category, Integer views) {
        if (!isStreamerOffline(name)) {
            UpdateCategory(name, category);
            UpdateViews(name, "" + views);

            System.out.println(
                    "\n'" + name
                            + "' was already online! His views and category were updated accordingly instead!\n");
            return;
        }

        streamers.add(new Streamer(name, category, views));
        System.out.println(
                "\n'" + name + "' is now online!\n");
    }

    public void StreamerOffline(String name) {
        if (isStreamerOffline(name) || streamers.size() == 0) {
            System.out.println("\n'" + name + "' is already offline!\n");
            return;
        }

        for (int i = 0; i < streamers.size(); i++) {
            if (streamers.get(i).getName().equals(name)) {
                streamers.remove(i);
                break;
            }
        }

        System.out.println(
                "\n'" + name + "' is now offline!\n");
    }

    public void UpdateViews(String name, String views) {
        if (isStreamerOffline(name)) {
            System.out.println("\n'" + name + "' is offline!\n");
            return;
        }

        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                streamer.setViews(Integer.parseInt(views));
                break;
            }
        }

        System.out.println(
                "\n'" + name + "' now has " + views + " viewers!\n");
    }

    public void UpdateCategory(String name, String category) {
        if (isStreamerOffline(name)) {
            System.out.println("\n'" + name + "' is offline!\n");
            return;
        }

        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                streamer.setCategory(category);
                break;
            }
        }

        System.out.println(
                "\n'" + name + "' is now streaming in the '" + category + "' category!\n");
    }

    public String TopStreamer() {
        if (streamers.size() == 0) {
            return "\nAll streamers are offline!";
        }

        if (streamers.size() == 1) {
            return streamers.get(0).getName();
        }

        int maxIndex = 0;
        int maxViews = streamers.get(0).getViews();
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

        if (currentStreamers.size() == 0) {
            return "\nAll streamers are offline!";
        }

        if (currentStreamers.size() == 1) {
            return currentStreamers.get(0).getName();
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

        if (isStreamerOffline(streamer1.getName()) && isStreamerOffline(streamer2.getName())) {
            return "Unable to compare '" + streamer1.getName() + "' and '" + streamer2.getName() + "'";
        }

        if (isStreamerOffline(streamer1.getName())) {
            return "Unable to compare to '" + streamer2.getName() + "'";
        }

        if (isStreamerOffline(streamer2.getName())) {
            return "Unable to compare to '" + streamer1.getName() + "'";
        }

        switch (streamer1.compareTo(streamer2)) {
            case 0:
                return "'" + streamer1.getName() + "' has the same amount of viewers as '" + streamer2.getName()
                        + "'";
            case 1:
                return "'" + streamer1.getName() + "' has '" + differenceInViews + "' more viewers than '"
                        + streamer2.getName()
                        + "'";
            case -1:
                return "'" + streamer1.getName() + "' has '" + differenceInViews + "' less viewers than '"
                        + streamer2.getName()
                        + "'";
            default:
                return "Invalid comparison between '" + streamer1.getName() + "' and '" + streamer2.getName()
                        + "'!";

        }
    }

    public Streamer getStreamer(String name) {
        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                return streamer;
            }
        }

        System.out.println("\n'" + name + "' is offline!");
        return new Streamer(name);
    }

    public String getPlatformName() {
        return platformName;
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
