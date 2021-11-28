import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        String[][] streamerData = {
                { "ninon", "Fortnite", "1208" },
                { "sodapoppin", "Just Chatting", "19203" },
                { "Clix", "Fortnite", "14002" },
                { "Swagg", "Warzone", "7520" },
                { "rineksa", "Just Chatting", "420" },
                { "Wallibear", "Minecraft", "960" },
                { "IceManIsaac", "Warzone", "530" },
                { "Aydan", "Warzone", "11230" },
                { "DanriqueTW", "Minecraft", "440" },
                { "DisguisedToast", "Fortnite", "4450" },
                { "nickmira_", "Just Chatting", "5661" },
                { "Skloppa", "FIFA 2022", "330" },

        };

        Platform twitch = new Platform("Twitch", streamerData);
        System.out.println("Twitch platform initiated!\n");

        Scanner scanner = new Scanner(System.in);

        int input = -1;
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

            System.out.println("Press 'Q' to terminate the program... :(\n");
            System.out.print("$ ");

            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Quitting the program...");
                break;
            }

            InputParser.handleUserInput(input, twitch);

            System.out.print("Press ENTER to continue...");
            try {
                System.in.read();
            } catch (Exception e) {
            }
        }

        scanner.close();
    }
}