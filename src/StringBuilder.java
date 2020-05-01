import java.util.ArrayList;
import java.util.List;

public class StringBuilder {
    List<String> stringBuilder = new ArrayList<>();

    public String append(String s) {
        stringBuilder.add(s);
        return stringBuilder.toString();
    }
}
