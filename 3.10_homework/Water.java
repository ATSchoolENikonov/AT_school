public class Water extends NatureElement {
    @Override
    NatureElement connect(NatureElement element) {
        if (element instanceof Air) {
            return new Rain();
        } else if (element instanceof Water) {
            return new Sea();
        } else if (element instanceof Fire) {
            return new Steam();
        } else if (element instanceof Earth) {
            return new Mud();
        } else return element;
    }
}
