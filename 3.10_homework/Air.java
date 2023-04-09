public class Air extends NatureElement {
    @Override
    NatureElement connect(NatureElement element) {
        if (element instanceof Air) {
            System.out.println(Pressure.class.getName());
            return new Pressure();
        } else if (element instanceof Water) {
            System.out.println(Rain.class.getName());
            return new Rain();
        } else if (element instanceof Fire) {
            System.out.println(Energy.class.getName());
            return new Energy();
        } else if (element instanceof Earth) {
            System.out.println(Dust.class.getName());
            return new Dust();
        } else {
            return element;
        }

    }
}
