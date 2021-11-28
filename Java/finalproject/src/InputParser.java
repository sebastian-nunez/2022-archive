import java.util.Scanner;

public class InputParser {
    public static void handleUserInput(int input, Platform platform) {
        Scanner scanner = new Scanner(System.in);

        String name = "";
        String category = "";
        String views = "";

        boolean success = false;
        switch (input) {
            case 0:
                // VIEW ONLINE STREAMERS
                break;
            case 1:
                System.out.print("Enter the name of the streamer :: ");
                name = scanner.nextLine();

                System.out.print("Enter the category of the streamer :: ");
                category = scanner.nextLine();

                System.out.print("Enter the viewer count the streamer :: ");
                views = scanner.nextLine();

                success = platform.StreamerOnline(name, category, Integer.parseInt(views));
                if (success) {
                    System.out.println(
                            "\n'" + name + "' is now online!\n");
                } else {
                    System.out.println(
                            "\n'" + name
                                    + "' was already online! His views and category were updated accordingly instead!\n");
                }
                break;
            case 2:
                System.out.print("Enter the name of the streamer :: ");
                name = scanner.nextLine();

                success = platform.StreamerOffline(name);
                if (success) {
                    System.out.println(
                            "\n'" + name + "' is now offline!\n");
                } else {
                    System.out.println("\n'" + name + "' is already offline!\n");
                }
                break;
            case 3:
                System.out.print("Enter the name of the streamer :: ");
                name = scanner.nextLine();

                System.out.print("Enter the viewer count the streamer :: ");
                views = scanner.nextLine();

                success = platform.UpdateViews(name, views);
                if (success) {
                    System.out.println(
                            "\n'" + name + "' now has " + views + " viewers!\n");
                } else {
                    System.out.println("\n'" + name + "' is offline!\n");
                }
                break;
            case 4:
                System.out.print("Enter the name of the streamer :: ");
                name = scanner.nextLine();

                System.out.print("Enter the category of the streamer :: ");
                category = scanner.nextLine();

                success = platform.UpdateCategory(name, category);
                if (success) {
                    System.out.println(
                            "\n'" + name + "' is now streaming in the '" + category + "' category!\n");
                } else {
                    System.out.println("\n'" + name + "' is offline!\n");
                }
                break;
            default:
                System.out.println("INVALID command!\n");
        }

        System.out.println(platform);
    }
}
