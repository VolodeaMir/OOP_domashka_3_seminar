import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EnglishGame game = new EnglishGame();
        Scanner scanner = new Scanner(System.in);
        game.start(scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
        while (!game.getGameStatus().equals(GameStatus.FINISH)) {
            String value = scanner.nextLine();
            game.inputValue(value);
            Answer answer = game.inputValue(value);
            if (answer != null) {
                System.out.println("answer = " + answer);
            }
        }
        List<String> gameHistory = game.getGameHistory();
        System.out.println("Game history:");
        for (String logEntry : gameHistory) {
            System.out.println(logEntry);
        }
    }
}
