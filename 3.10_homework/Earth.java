public class Earth extends NatureElement {
    @Override
    NatureElement connect(NatureElement element) {
        if (element instanceof Air) {
            System.out.println(Dust.class.getName());
            return new Dust();
        } else if (element instanceof Water) {
            System.out.println(Mud.class.getName());
            return new Mud();
        } else if (element instanceof Fire) {
            System.out.println(Lava.class.getName());
            return new Lava();
        } else if (element instanceof Earth) {
            System.out.println(Pressure.class.getName());
            return new Pressure();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
