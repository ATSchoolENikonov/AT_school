public class Earth extends NatureElement {
    @Override
    NatureElement connect(NatureElement element) {
        if (element instanceof Air) {
            return new Dust();
        } else if (element instanceof Water) {
            return new Mud();
        } else if (element instanceof Fire) {
            return new Lava();
        } else if (element instanceof Earth) {
            return new Pressure();
        } else return element;
    }
}
