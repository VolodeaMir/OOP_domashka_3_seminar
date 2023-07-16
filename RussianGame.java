import java.util.ArrayList;
import java.util.List;

public class RussianGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (char c = 'А'; c <= 'Я'; c++) {
            result.add(String.valueOf(c));
        }
        return result;
    }
}
