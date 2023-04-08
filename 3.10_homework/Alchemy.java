import java.util.ArrayList;
import java.util.List;

public class Alchemy {
    public static void main(String[] args) {
        List<NatureElement> elems = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            elems.add(NatureElement.create(args[i]));
        }
        if (elems.size() % 2 != 0) {
            elems.remove(elems.size() - 1);
        }
        for (int i = 0; i < elems.size(); i += 2) {
            if (elems.get(i) instanceof Fire) {
                Fire fire = new Fire();
                if (elems.get(i + 1) instanceof Fire) {
                    fire.connect(elems.get(i + 1));
                } else {
                    System.out.println(fire.connect(elems.get(i + 1)).getClass().getName());
                }
            } else if (elems.get(i) instanceof Water) {
                Water water = new Water();
                System.out.println(water.connect(elems.get(i + 1)).getClass().getName());
            } else if (elems.get(i) instanceof Earth) {
                Earth earth = new Earth();
                System.out.println(earth.connect(elems.get(i + 1)).getClass().getName());
            } else if (elems.get(i) instanceof Air) {
                Air air = new Air();
                System.out.println(air.connect(elems.get(i + 1)).getClass().getName());
            }
        }
    }
}
