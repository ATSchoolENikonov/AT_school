public class Fire extends NatureElement {
    @Override
    NatureElement connect(NatureElement element) {
        if (element instanceof Air) {
            System.out.println(Energy.class.getName());
            return new Energy();
        } else if (element instanceof Water) {
            System.out.println(Steam.class.getName());
            return new Steam();
        } else if (element instanceof Fire) {
            System.out.println("Нет нового элемента");
            return null;
        } else if (element instanceof Earth) {
            System.out.println(Lava.class.getName());
            return new Lava();
        } else {
            return element;
        }
    }


}
