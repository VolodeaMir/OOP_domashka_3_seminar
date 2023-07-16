import java.util.List;

public interface Game {
    void start(Integer sizeWord,Integer maxTry);

    Answer inputValue(String value);

    GameStatus getGameStatus();

    List<String> getGameHistory();

    void restart();
}
