public class Water extends NatureElement {
    @Override
    NatureElement connect(NatureElement element) {
        if (element instanceof Air) {
            System.out.println(Rain.class.getName());
            return new Rain();
        } else if (element instanceof Water) {
            System.out.println(Sea.class.getName());
            return new Sea();
        } else if (element instanceof Fire) {
            System.out.println(Steam.class.getName());
            return new Steam();
        } else if (element instanceof Earth) {
            System.out.println(Mud.class.getName());
            return new Mud();
        } else {
            return element;
        }
    }
}
