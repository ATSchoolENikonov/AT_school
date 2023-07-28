

public class Launch {
    public static void main(String[] args) {
        Director dir=new Director();
        dir.setId(15);
        dir.setCountry("sgsg");
        dir.setFirstName("wwwww");
        dir.setLastName("sdada");
        DirectorRepositoryImpl im=new DirectorRepositoryImpl();
        im.save(dir);
        System.out.println(im.get(6).getCountry());
        System.out.println(im.get(7).getBirthdate());
        System.out.println(im.get(7).getLastName());
        System.out.println(im.get(7).getFirstName());
        System.out.println(im.get(7).getId());
        im.delete(dir);
    }
}
