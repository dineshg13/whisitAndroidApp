package whisit.core;

import whisit.builder.MovieBuilder;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import whisit.model.event.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;

/**
 * Created by dinesh on 12/6/2015.
 */
@Service
public class DownloadService {
    public Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${themoviedb.api.key}")
    private String API_KEY;

    @Async
    public ListenableFuture<Movie> getMovie(int movieId) throws ExecutionException {
        LOGGER.info("Started for Movie id: " + movieId);
        LOGGER.info("API_KEY=" + API_KEY);

        TmdbMovies movies = new TmdbApi(API_KEY).getMovies();

        MovieDb movieDb = movies.getMovie(movieId, null, null);
        Movie movie = MovieBuilder.build(movieDb);

        AsyncResult<Movie> asyncResult = new AsyncResult<>(movie);
        asyncResult.addCallback(new ListenableFutureCallback<Movie>() {
            @Override
            public void onFailure(Throwable ex) {
                LOGGER.info("Getting movie for id:" + movieId + ", failed");
            }

            @Override
            public void onSuccess(Movie result) {
                LOGGER.info("Movie retrieved for id:" + movieId);
                LOGGER.info(result.toString());

            }
        });

        return asyncResult;
    }
}
