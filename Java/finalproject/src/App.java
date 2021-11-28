import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void handleUserInput(int input, Platform platform) {
        Scanner scanner = new Scanner(System.in);

        String name = "";
        String category = "";
        String views = "";
        boolean success = false;

        switch (input) {
            case 0:
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
        }

        System.out.println(platform);
    }

    public static void main(String[] args) {
        String[][] streamerData = {
                { "ninon", "Fortnite", "1208" },
                // { "sodapoppin", "Just Chatting", "19203" },
                // { "Clix", "Fortnite", "14002" },
                // { "Swagg", "Warzone", "7520" },
                // { "rineksa", "Just Chatting", "420" },
                // { "Wallibear", "Minecraft", "960" },
                // { "IceManIsaac", "Warzone", "530" },
                // { "Aydan", "Warzone", "11230" },
                // { "DanriqueTW", "Minecraft", "440" },
                // { "DisguisedToast", "Fortnite", "4450" },
                // { "nickmira_", "Just Chatting", "5661" },
                // { "Skloppa", "FIFA 2022", "330" },

        };

        Platform twitch = new Platform("Twitch", streamerData);
        System.out.println("Twitch platform initiated!\n");

        Scanner scanner = new Scanner(System.in);

        int input = -1;
        String enterPressed = "";
        while (true) {
            System.out.println("[0] - View online streamers\n");
            System.out.println("Streamer commands: ");
            System.out.println("[1] - Add a streamer");
            System.out.println("[2] - Remove a streamer");
            System.out.println("[3] - Update viewer count");
            System.out.println("[4] - Update category");
            System.out.println();

            System.out.println("Platform utilities: ");
            System.out.println("[5] - Request top streamer in the platform");
            System.out.println("[6] - Request the top streamer in a particular category");
            System.out.println("[7] - Request viewer count for a particular category");
            System.out.println("[8] - Request all streamers in a particular category");
            System.out.println("[9] - Compare a pair of streamers");
            System.out.println();

            System.out.println("Enter any LETTER to terminate the program... :(\n");
            System.out.print("$ ");

            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Quitting the program...");
                break;
            }

            handleUserInput(input, twitch);
        }

        scanner.close();
    }
}
