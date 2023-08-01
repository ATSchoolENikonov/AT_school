import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Launch {
    public static void main(String[] args) {
        //Task_1
        Director dir = new Director();
        dir.setId(15);
        dir.setCountry("sgsg");
        dir.setFirstName("wwwww");
        dir.setLastName("sdada");
        DirectorRepositoryImpl im = new DirectorRepositoryImpl();
        List<String> genraa=List.of("Ужасы","Драчка","Эротика");
//        for (int i = 0; i < im.get(genraa).size(); i++) {
//            System.out.println(im.get(genraa).get(i));
//        }
//        im.delete(dir);
//        im.save(dir);
//        System.out.println(im.get(15).getCountry());
//        System.out.println(im.get(15).getBirthdate());
//        System.out.println(im.get(15).getLastName());
//        System.out.println(im.get(15).getFirstName());
//        System.out.println(im.get(15).getId());
//        im.delete(dir);
//        im.get(88);
        //Task_2
//        Movie mov=new Movie();
//        mov.setTitle("Napoleon");
//        mov.setDirector(5);
//        mov.setRelease(Date.valueOf(LocalDate.parse("2023-07-25")));
//        mov.setGenre("История");
//        mov.setId(5);
//        MovieRepositoryImpl movieRepository=new MovieRepositoryImpl();
//        movieRepository.delete(mov);
//        movieRepository.save(mov);
//        System.out.println(movieRepository.get(5).getRelease());
//        System.out.println(movieRepository.get(5).getTitle());
//        System.out.println(movieRepository.get(5).getGenre());
//        System.out.println(movieRepository.get(5).getDirector());
//        System.out.println(movieRepository.get(5).getId());
//        for (int i = 0; i < movieRepository.get(im.get(3)).size(); i++) {
//            System.out.println(movieRepository.get(im.get(3)).get(i));
//        }
    }
}
