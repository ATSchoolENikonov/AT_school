public abstract class NatureElement {
    abstract void connect(NatureElement element);
    static  void create(String elementName){
        if(elementName.equals(Fire.class.getName())){
            Fire fire=new Fire();
        }
    }
}
