import java.util.ArrayList;
import java.util.List;

public class EnglishGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            result.add(String.valueOf(c));
        }
        return result;
    }
}