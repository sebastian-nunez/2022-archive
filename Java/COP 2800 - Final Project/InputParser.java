import java.util.ArrayList;
import java.util.Scanner;

public class InputParser {
    private static Scanner scanner = new Scanner(System.in);
    private static String name = "";
    private static String category = "";
    private static String views = "";

    public static void userInput(int input, Platform platform) {
        switch (input) {
            case 0:
                handleViewStreamers(platform);
                break;
            case 1:
                handleStreamerOnline(platform);
                break;
            case 2:
                handleStreamerOffline(platform);
                break;
            case 3:
                handleUpdateViews(platform);
                break;
            case 4:
                handleUpdateCategory(platform);
                break;
            case 5:
                handleTopStreamer(platform);
                break;
            case 6:
                handleTopStreamerInCategory(platform);
                break;
            case 7:
                handleViewsInCategory(platform);
                break;
            case 8:
                handleStreamersInCategory(platform);
                break;
            case 9:
                handleCompareStreamers(platform);
                break;
            default:
                handleInvalidCommand(platform);
        }

    }

    private static void handleViewStreamers(Platform platform) {
        System.out.println(platform);
    }

    private static void handleStreamerOnline(Platform platform) {
        System.out.print("Enter the name of the streamer :: ");
        name = scanner.nextLine();

        System.out.print("Enter the category of the streamer :: ");
        category = scanner.nextLine();

        System.out.print("Enter the viewer count the streamer :: ");
        views = scanner.nextLine();

        platform.StreamerOnline(name, category, Integer.parseInt(views));
    }

    private static void handleStreamerOffline(Platform platform) {
        System.out.print("Enter the name of the streamer :: ");
        name = scanner.nextLine();

        platform.StreamerOffline(name);
    }

    private static void handleUpdateViews(Platform platform) {
        System.out.print("Enter the name of the streamer :: ");
        name = scanner.nextLine();

        System.out.print("Enter the viewer count the streamer :: ");
        views = scanner.nextLine();

        platform.UpdateViews(name, views);
    }

    private static void handleUpdateCategory(Platform platform) {
        System.out.print("Enter the name of the streamer :: ");
        name = scanner.nextLine();

        System.out.print("Enter the category of the streamer :: ");
        category = scanner.nextLine();

        platform.UpdateCategory(name, category);
    }

    private static void handleTopStreamer(Platform platform) {
        System.out.println(
                "The top streamer on '" + platform.getPlatformName() + "' is '" + platform.TopStreamer() + "'\n");
    }

    private static void handleTopStreamerInCategory(Platform platform) {
        System.out.print("Enter the category :: ");
        category = scanner.nextLine();

        System.out.println(
                "\nThe top streamer on '" + category + "' is '" + platform.TopStreamerInCategory(category) + "\n");
    }

    private static void handleViewsInCategory(Platform platform) {
        System.out.print("Enter the category :: ");
        category = scanner.nextLine();

        System.out.println(
                "\nThere are '" + platform.ViewsInCategory(category) + "' viewers in the '" + category
                        + "' category\n");
    }

    private static void handleStreamersInCategory(Platform platform) {
        System.out.print("Enter the category :: ");
        category = scanner.nextLine();

        String output = "Currently, ";
        ArrayList<String> streamerNames = platform.StreamersInCategory(category);

        if (streamerNames.size() == 0) {
            output += "there are no streamers in the '" + category + "' category";
        } else if (streamerNames.size() == 1) {
            output += "only '" + streamerNames.get(0) + "' is streaming in the '" + category + "' category";
        } else {
            for (int i = 0; i < streamerNames.size(); i++) {
                if (i == streamerNames.size() - 1) {
                    output += "and '" + streamerNames.get(i) + "' are streaming in the '" + category + "' category";
                    break;
                }

                output += "'" + streamerNames.get(i) + "', ";
            }
        }

        System.out.println("\n" + output + "\n");
    }

    private static void handleCompareStreamers(Platform platform) {
        System.out.print("Enter the name of the 1st streamer :: ");
        String streamer1Name = scanner.nextLine();

        System.out.print("Enter the name of the 2nd streamer :: ");
        String streamer2Name = scanner.nextLine();

        Streamer streamer1 = platform.getStreamer(streamer1Name);
        Streamer streamer2 = platform.getStreamer(streamer2Name);

        System.out.println("\n" + platform.compareStreamers(streamer1, streamer2) + "\n");
    }

    private static void handleInvalidCommand(Platform platform) {
        System.out.println("INVALID command!\n");
    }
}
