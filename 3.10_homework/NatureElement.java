public abstract class NatureElement {
    NatureElement connect(NatureElement element){
        return null;
    }

    static NatureElement create(String elementName) {
        if (elementName.equals(Fire.class.getName())) {
            return new Fire();
        } else if (elementName.equals(Water.class.getName())) {
            return new Water();
        } else if (elementName.equals(Air.class.getName())) {
            return new Air();
        } else if (elementName.equals(Earth.class.getName())) {
            return new Earth();
        } else {
            System.out.println("Неизвестный элемент");
            return null;
        }
    }
}
