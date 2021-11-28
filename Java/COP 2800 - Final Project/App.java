import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] streamerData = {
                { "ninon", "Fortnite", "1208" },
                { "sodapoppin", "Just Chatting", "19203" },
                { "Clix", "Fortnite", "14002" },
                { "Swagg", "Warzone", "7520" },
                { "rineksa", "Just Chatting", "420" },
                { "Wallibear", "Minecraft", "922" },
                { "IceManIsaac", "Warzone", "332" },
                { "Aydan", "Warzone", "11230" },
                { "DanriqueTW", "Minecraft", "448" },
                { "DisguisedToast", "Fortnite", "4450" },
                { "nickmira_", "Just Chatting", "5661" },
                { "Skloppa", "FIFA 2022", "332" },
        };

        Platform twitch = new Platform("Twitch", streamerData);

        int input;
        while (true) {
            InputParser.promptUser();

            try {
                input = scanner.nextInt();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Quitting the program...");
                break;
            }

            InputParser.parseCommand(input, twitch);

            System.out.print("Press ENTER to continue...");
            try {
                System.in.read();
            } catch (Exception e) {
            }
        }

        scanner.close();
    }
}
