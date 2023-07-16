
import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    protected Integer sizeWord;
    protected Integer maxTry;
    protected int currentTry;
    protected String computerWord;
    protected GameStatus gameStatus;
    protected GameLogger logger;

    public AbstractGame() {
        gameStatus = GameStatus.INIT;
    }

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        computerWord = generateWord();
        System.out.println("comp:  " + computerWord);
        this.gameStatus = GameStatus.START;
        this.currentTry = 0;
        this.logger = new GameLogger();
    }

    @Override
    public Answer inputValue(String value) {
        if (currentTry >= maxTry) {
            gameStatus = GameStatus.FINISH;
            System.out.println("You have lost the game due to the maximum number of tries.");
            logger.logGameFinished();
            return null;
        }
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == computerWord.charAt(i)) {
                bull++;
                cow++;
            } else if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                cow++;
            }
        }
        currentTry++;
        if (sizeWord.equals(bull)) {
            gameStatus = GameStatus.FINISH;
            System.out.println("You won the game!!");
            logger.logGameFinished();
            return null;
        }
        Answer answer = new Answer(bull, cow, currentTry);
        logger.logInputValue(value + " - " + answer.toString());
        return answer;
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    @Override
    public List<String> getGameHistory() {
        return logger.getLog();
    }

    @Override
    public void restart() {
        gameStatus = GameStatus.INIT;
        currentTry = 0;
        computerWord = generateWord();
        logger = new GameLogger();
        System.out.println("Game restarted.");
    }

    abstract List<String> generateCharList();

    private String generateWord() {
        List<String> charList = generateCharList();
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(charList.size());
            result.append(charList.get(randomIndex));
            charList.remove(randomIndex);
        }
        return result.toString();
    }
}