import java.util.NoSuchElementException;

public abstract class NatureElement {
    NatureElement connect(NatureElement element) {
        throw new UnsupportedOperationException();
    }

    public static NatureElement create(String elementName) {
        if (elementName.equals(Fire.class.getName())) {
            return new Fire();
        } else if (elementName.equals(Water.class.getName())) {
            return new Water();
        } else if (elementName.equals(Air.class.getName())) {
            return new Air();
        } else if (elementName.equals(Earth.class.getName())) {
            return new Earth();
        } else if (elementName.equals(Energy.class.getName())) {
            return new Energy();
        } else {
            System.out.println("Неизвестный элемент");
            throw new NoSuchElementException();
        }
    }
}
