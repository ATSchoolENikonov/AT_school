public class Energy extends NatureElement {
    @Override
    NatureElement connect(NatureElement element) {
        if (element instanceof Water) {
            System.out.println(Steam.class.getName());
            return new Steam();
        }
        else {
            throw new UnsupportedOperationException();
        }
    }
}
