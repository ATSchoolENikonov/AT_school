import java.sql.Date;
import java.time.LocalDate;

public class SetUp {
    private DirectorRepositoryImpl impl = new DirectorRepositoryImpl();
    private MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();

    public DirectorRepositoryImpl getImpl() {
        return impl;
    }

    public MovieRepositoryImpl getMovieRepository() {
        return movieRepository;
    }

    /**
     * Переменные для теста
     */
    private Director dir = getExpected(4, "Lilya", "Pupkina", "2022-07-28", "USA");
    private Movie movie = getExpected(2, "Grande", "Thriller", "2022-05-12", 4);

    public Director getDir() {
        return dir;
    }

    public Movie getMovie() {
        return movie;
    }

    public Director getExpected(int id, String first, String last, String date, String country) {
        Director director = new Director();
        director.setId(id);
        director.setFirstName(first);
        director.setLastName(last);
        director.setBirthdate(Date.valueOf(LocalDate.parse(date)));
        director.setCountry(country);
        return director;
    }
    public Movie getExpected(int id, String title, String genre, String release, int director) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setRelease(Date.valueOf(LocalDate.parse(release)));
        movie.setDirector(director);
        return movie;
    }

    void deleteDataDirector() {
        impl.delete(dir);
    }

    void safeDataDirector() {
        impl.save(dir);
    }

    void deleteDataMovie() {
        movieRepository.delete(movie);
    }

    void safeDataMovie() {
        movieRepository.save(movie);
    }

}
