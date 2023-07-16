import java.util.ArrayList;
import java.util.List;

class GameLogger {
    private List<String> log;

    public GameLogger() {
        log = new ArrayList<>();
    }

    public void logInputValue(String value) {
        log.add("Input value: " + value);
    }

    public void logGameFinished() {
        log.add("Game finished.");
    }

    public List<String> getLog() {
        return log;
    }
}