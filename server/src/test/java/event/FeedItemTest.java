package event;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import whisit.core.AbstractTestClass;
import whisit.repository.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dinesh on 12/6/2015.
 */
public class FeedItemTest extends AbstractTestClass {

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

    @Autowired
    private FeedItemRepository feedItemRepository;


//    private static

    @Value("${themoviedb.api.key}")
    private String API_KEY;

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void testMethod() {


    }


}
