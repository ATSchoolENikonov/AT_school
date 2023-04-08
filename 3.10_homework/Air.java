public class Air extends NatureElement {
    @Override
    NatureElement connect(NatureElement element) {
        if (element instanceof Air) {
            return new Pressure();
        } else if (element instanceof Water) {
            return new Rain();
        } else if (element instanceof Fire) {
            return new Energy();
        } else if (element instanceof Earth) {
            return new Dust();
        } else return element;

    }
}
