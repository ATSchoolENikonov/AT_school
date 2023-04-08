public class Fire extends NatureElement {
    @Override
    NatureElement connect(NatureElement element) {
        if (element instanceof Air) {
            return new Energy();
        } else if (element instanceof Water) {
            return new Steam();
        } else if (element instanceof Fire) {
            System.out.println("Нет нового элемента");
            return null;
        } else if (element instanceof Earth) {
            return new Lava();
        } else return element;
    }


}
