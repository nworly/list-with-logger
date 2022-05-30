import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private final int f;

    public Filter(int f) {
        this.f = f;
    }

    public List<Integer> filterOut(List<Integer> list) {
        return list.stream()
                .filter(x -> x < f)
                .collect(Collectors.toList());
    }
}
