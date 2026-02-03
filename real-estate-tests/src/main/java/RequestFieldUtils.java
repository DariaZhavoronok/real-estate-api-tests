import java.util.List;

public class RequestFieldUtils {
    public static <T> List<T> nullableList(T value) {
        return value == null ? null : List.of(value);
    }
}
