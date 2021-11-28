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
        System.out.println(platform.TopStreamer());
    }

    private static void handleInvalidCommand(Platform platform) {
        System.out.println("INVALID command!\n");
    }
}
