package movieDb;

import whisit.builder.MovieBuilder;
import com.google.gson.Gson;
import whisit.core.AbstractTestClass;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import whisit.model.event.Movie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import whisit.repository.MovieRepository;

/**
 * Created by dinesh on 11/29/2015.
 */
public class MovieDbTest extends AbstractTestClass {


    @Value("${themoviedb.api.key}")
    private String API_KEY;

    @Autowired
    private MovieRepository movieRepository;


    @Test
    public void testMethod() {
        System.out.println("API_KEY=" + API_KEY);
        TmdbMovies movies = new TmdbApi(API_KEY).getMovies();
        TmdbSearch search = new TmdbApi(API_KEY).getSearch();
//
        MovieDb movieDb = movies.getMovie(550, null, null);
        LOGGER.info(" Movie: " + movieDb.getId() + ", Details:" + movieDb);


//        MovieResultsPage movieResultsPage = search.searchMovie("Home Alone", null, null, false, null);
        Gson gson = new Gson();
        String json = gson.toJson(movieDb);
        LOGGER.info(json);

        Movie movie = MovieBuilder.build(movieDb);
        LOGGER.info(movie.toString());


        Movie savedMovie = movieRepository.save(movie);

        json = gson.toJson(savedMovie);
        LOGGER.info(json);
//        String str = RandomStringUtils.randomAscii(3000);
//        LOGGER.info(str);
////
//        for (MovieDb movieDb : movieResultsPage.getResults()) {
//
//            String json = gson.toJson(movieDb);
//
//            LOGGER.info(json);
//        }


    }

}
