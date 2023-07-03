import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Alchemy {
    public static void main(String[] args) {
        List<NatureElement> elems = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            try {
                elems.add(NatureElement.create(args[i]));
            } catch (NoSuchElementException e) {
                System.exit(22);
            }
            if (elems.get(i) == null) {
                System.out.println("Не удалось создать элемент");
                System.exit(23);
            }
        }
        for (int i = 0; i < elems.size(); i += 2) {
            if (i == elems.size() - 1) {
                System.out.println("Для последнего элемента нет пары");
            } else {
                try {
                    elems.get(i).connect(elems.get(i + 1));
                } catch (UnsupportedOperationException e) {
                    System.out.println("Операция создания элемента из текущей пары невозможна");
                }
            }
        }
    }
}
