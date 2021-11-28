import java.util.ArrayList;

/**
 * The {@code Platform} class represents an individual service platform.
 * <pre>
 *     Platform(String platformName, String[][] streamerData)
 * </pre>
 */
public class Platform implements Streamable {
    private String platformName;
    private ArrayList<Streamer> streamers = new ArrayList<Streamer>();

    public Platform(String platformName) {
        this.platformName = platformName;
        System.out.println(platformName + " platform initiated!\n");
    }

    public Platform(String platformName, String[][] streamerData) {
        this.platformName = platformName;

        for (String[] data : streamerData) {
            String name = data[0];
            String category = data[1];
            Integer viewers = Integer.parseInt(data[2]);

            streamers.add(new Streamer(name, category, viewers));
        }

        System.out.println(platformName + " platform initiated!\n");
    }

    /**
     * Checks if a streamer is currently offline within the streaming platform.
     * @param name
     * @return
     */
    public boolean isStreamerOffline(String name) {
        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                return false;
            }
        }

        return true;
    }

    public void StreamerOnline(String name, String category, Integer viewers) {
        if (!isStreamerOffline(name)) {
            UpdateCategory(name, category);
            UpdateViewers(name, "" + viewers);

            System.out.println(
                    "\n'" + name
                            + "' was already online! His viewers and category were updated accordingly instead!\n");
            return;
        }

        streamers.add(new Streamer(name, category, viewers));
        System.out.println(
                "\n'" + name + "' is now online!\n");
    }

    public void StreamerOffline(String name) {
        if (isStreamerOffline(name) || streamers.size() == 0) {
            System.out.println("\n'" + name + "' was already offline!\n");
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

    public void UpdateViewers(String name, String viewers) {
        if (isStreamerOffline(name)) {
            System.out.println("\n'" + name + "' is currently offline!");
            return;
        }

        for (Streamer streamer : streamers) {
            if (streamer.getName().equals(name)) {
                streamer.setViewers(Integer.parseInt(viewers));
                break;
            }
        }

        System.out.println(
                "\n'" + name + "' now has '" + viewers + "' viewers!\n");
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
            return "";
        }

        if (streamers.size() == 1) {
            return streamers.get(0).getName();
        }

        int maxIndex = 0;
        int maxViewers = streamers.get(0).getViewers();
        for (int i = 1; i < streamers.size(); i++) {
            if (streamers.get(i).getViewers() >= maxViewers) {
                maxViewers = streamers.get(i).getViewers();
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
            return "";
        }

        if (currentStreamers.size() == 1) {
            return currentStreamers.get(0).getName();
        }

        int maxIndex = 0;
        int maxViewers = currentStreamers.get(0).getViewers();
        for (int i = 0; i < currentStreamers.size(); i++) {
            if (currentStreamers.get(i).getViewers() >= maxViewers) {
                maxIndex = i;
            }
        }

        return currentStreamers.get(maxIndex).getName();
    }

    public Integer ViewersInCategory(String category) {
        int count = 0;

        for (Streamer streamer : streamers) {
            if (streamer.getCategory().equals(category)) {
                count += streamer.getViewers();
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

    /**
     * Compares a pair of streamers using {@code Streamer.compareTo()}.
     * @return String output
     */
    public String compareStreamers(Streamer streamer1, Streamer streamer2) {
        Integer differenceInViewers = Math.abs(streamer2.getViewers() - streamer1.getViewers());

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
                return "'" + streamer1.getName() + "' has '" + differenceInViewers + "' more viewers than '"
                        + streamer2.getName()
                        + "'";
            case -1:
                return "'" + streamer1.getName() + "' has '" + differenceInViewers + "' less viewers than '"
                        + streamer2.getName()
                        + "'";
            default:
                return "Invalid comparison between '" + streamer1.getName() + "' and '" + streamer2.getName()
                        + "'!";

        }
    }

    /**
     * Access an individual streamer from the platform by name.
     * @return Streamer streamer
     */
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

    public ArrayList<Streamer> getStreamers() {
        return streamers;
    }

    /**
     * Resets the platform. All streamers will be set offline.
     */
    public void resetPlatform() {
        streamers.clear();
        System.out.println("The '" + platformName + "' platform has been reset!\n");
    }

    public String toString() {
        String output = "";

        if (streamers.size() == 0) {
            return "All streamers are currently offline!\n";
        }

        for (Streamer streamer : streamers) {
            output += streamer + "\n";
        }

        return output;
    }
}
