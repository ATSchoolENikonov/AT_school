
public class Launch {
    public static void main(String[] args) {
        Director dir = new Director();
        dir.setId(15);
        dir.setCountry("sgsg");
        dir.setFirstName("wwwww");
        dir.setLastName("sdada");
        DirectorRepositoryImpl im = new DirectorRepositoryImpl();
        im.delete(dir);
        im.save(dir);
        System.out.println(im.get(15).getCountry());
        System.out.println(im.get(15).getBirthdate());
        System.out.println(im.get(15).getLastName());
        System.out.println(im.get(15).getFirstName());
        System.out.println(im.get(15).getId());
        im.delete(dir);
        im.get(88);
    }
}
