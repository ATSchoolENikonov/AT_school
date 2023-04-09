import java.util.ArrayList;
import java.util.List;

public class Alchemy {
    public static void main(String[] args) {
        List<NatureElement> elems = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            elems.add(NatureElement.create(args[i]));
            if(elems.get(i)== null){
                System.out.println("Не удалось создать элемент");
                System.exit(23);
            }
        }
        for (int i = 0; i < elems.size(); i += 2) {
            if(elems.get(i)==elems.get(elems.size()-1)){
                System.out.println("Для последнего элемента нет пары");
            }else {
                elems.get(i).connect(elems.get(i + 1));
            }
        }
    }
}
