package event;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import whisit.builder.MovieBuilder;
import whisit.core.AbstractTestClass;
import whisit.model.GeoName;
import whisit.model.event.Movie;
import whisit.model.event.MovieScenesHolder;
import whisit.model.event.Scene;
import whisit.model.event.people.CastPerson;
import whisit.model.place.Place;
import whisit.model.place.PlaceEvent;
import whisit.repository.*;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by dinesh on 12/6/2015.
 */
public class PlaceEventTest extends AbstractTestClass {

    public static final int STREAM_SIZE = 500;
    public static final int MAX_PLACES = 10;
    public static final int MAX_SCENES = 10;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PlaceEventRepository placeEventRepository;

    @Autowired
    private SceneRepository sceneRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Environment env;

    @Autowired
    private MovieSceneHolderRepository movieSceneHolderRepository;


//    private static

    @Value("${themoviedb.api.key}")
    private String API_KEY;

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void testMethod() {
        LOGGER.info("Test started");

        //Now get 500 Movies;

        Random r = new Random();

        List<Future<Movie>> futures = Lists.newArrayList();

        r.ints(STREAM_SIZE, 0, 300000).forEach(value -> {
                    Future<Movie> future = executorService.submit(new GetMovieFromMovieDB(value));
                    futures.add(future);

                }
        );
        //Loop all futures

        List<Movie> movies = Lists.newArrayList();
        for (Future<Movie> future : futures) {

            try {
                Movie movie = future.get();
                movies.add(movie);
            } catch (Exception e) {
//              Eat the exception
            }

        }

        LOGGER.info("Movie Retrieval done, number of movies:" + movies.size());


        int totalNumberOfScenes = 0;
        //Create 2000 Scenes
        Map<Movie, MovieScenesHolder> holderMap = Maps.newHashMap();
        for (Movie movie : movies) {

            int rs = RandomUtils.nextInt(1, MAX_SCENES);
            MovieScenesHolder holder = new MovieScenesHolder(movie);

            List<Scene> scenes = Lists.newArrayList();
            for (int i = 0; i < rs; i++) {

                Scene scene = new Scene(movie);
                scene.setSite(RandomStringUtils.randomAscii(100));
                scene.setName(RandomStringUtils.randomAlphabetic(33));
                CastPerson p = new CastPerson();
                p.setName(RandomStringUtils.randomAlphanumeric(222));
                p.setProfilePath(RandomStringUtils.randomAlphabetic(33));

                scene.setCast(Lists.newArrayList(p));
                scene.setDescription(RandomStringUtils.randomAscii(3000));
                scene.setDuration(RandomUtils.nextLong(0, 10000));
                scenes.add(scene);
            }
            holder.setScenes(scenes);
            holderMap.put(movie, holder);
            LOGGER.info("Movie:" + movie + " , Number of Scences:" + scenes.size() + ", Holder Size:" + holderMap.size());
            totalNumberOfScenes += scenes.size();

        }
        List<GeoName> geoNames = somePlacesInNyc();
        for (Movie movie : movies) {

            LOGGER.info("processing movie:" + movie);

            for (Scene scene : holderMap.get(movie).getScenes()) {

                int numOfPlaces = RandomUtils.nextInt(1, MAX_PLACES);
                List<Place> places = Lists.newArrayList();
                for (int i = 0; i < numOfPlaces; i++) {
                    int id = RandomUtils.nextInt(0, geoNames.size());
                    GeoName placeInfo = geoNames.get(id);
                    Place place = new Place();
                    place.setName(placeInfo.getName());
                    place.setAddress(StringUtils.join(placeInfo.getAdmin1(), placeInfo.getAdmin2(), placeInfo.getAdmin3(), placeInfo.getAdmin4()));
                    place.setCountry(placeInfo.getCountry());
                    place.setPoint(placeInfo.getGeolocation());
                    places.add(place);
                }
                scene.setPlaces(places);

            }


        }

        Map<Place, PlaceEvent> placePlaceEventMap = Maps.newHashMap();
        List<Scene> allScenes = Lists.newArrayList();
        List<CastPerson> allCastPersons = Lists.newArrayList();
        for (Movie movie : movies) {
            allScenes.addAll(holderMap.get(movie).getScenes());
            for (Scene scene : holderMap.get(movie).getScenes()) {
                for (Place place : scene.getPlaces()) {

                    if (!placePlaceEventMap.containsKey(place)) {
                        placePlaceEventMap.put(place, new PlaceEvent(place, place.getPoint()));
                    }
                    placePlaceEventMap.get(place).addScence(scene);

                }
                allCastPersons.addAll(scene.getCast());

            }
        }

        //Log the size


        LOGGER.info("Movies:" + movies.size());
        LOGGER.info("Number of scenes:" + totalNumberOfScenes);
        LOGGER.info("Number of Places:" + placePlaceEventMap.size());
        LOGGER.info("PlaceEvent:" + placePlaceEventMap.values().size());


        movieRepository.save(movies);
        LOGGER.info("movies saved");


        placeRepository.save(placePlaceEventMap.keySet());
        LOGGER.info("places saved");

        personRepository.save(allCastPersons);
        LOGGER.info("persons saved");

        sceneRepository.save(allScenes);
        LOGGER.info("allScenes saved ");

        placeEventRepository.save(placePlaceEventMap.values());
        LOGGER.info("placeEvents saved");

        movieSceneHolderRepository.save(holderMap.values());
        LOGGER.info("holderMap saved");

    }

    class GetMovieFromMovieDB implements Callable<Movie> {


        private int movieId;

        public GetMovieFromMovieDB(int movieId) {
            this.movieId = movieId;
        }

        @Override
        public Movie call() {
            try {
                LOGGER.info("Requesting for movie id:" + movieId);
                TmdbMovies movies = new TmdbApi(API_KEY).getMovies();


                MovieDb movieDb = movies.getMovie(movieId, null, null);
                Movie movie = MovieBuilder.build(movieDb);
                LOGGER.info("returning:" + movie);

                Thread.sleep(5000);
                return movie;

            } catch (InterruptedException e) {
                //ignore do nothing
            } catch (Exception e) {
                LOGGER.error("Exception Occurred:" + e.getMessage(), e);
                throw new RuntimeException(e);
            }
            return null;
        }
    }

    private List<GeoName> somePlacesInNyc() {
        //Get Random 5000 places
        Mongo mongo = null;
        Point point = new GeoJsonPoint(-74.00597, 40.7126);

        try {
            mongo = new MongoClient(new ServerAddress(env.getProperty("mongodb.host"), Integer.parseInt(env.getProperty("mongodb.port"))), MongoClientOptions.builder().connectTimeout(1500)
                    .connectionsPerHost(8)
                    .maxWaitTime(1500)
                    .socketKeepAlive(true)
                    .build());

            String database = "geodata";
            MongoTemplate mongoTemplate = new MongoTemplate(mongo, database);

            List<GeoName> geodataList = mongoTemplate.find(new Query(Criteria.where("geolocation").near(point).maxDistance(10000)), GeoName.class);
            LOGGER.info("Returning :" + geodataList.size() + " , number of places");
            return geodataList;
            //Associate all of them
        } catch (UnknownHostException e) {

            LOGGER.error("Error occured:" + e.getMessage(), e);
        }
        return null;
    }


}
