package whisit.model;

import com.google.common.collect.Lists;
import com.google.gson.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RestTemplate;
import whisit.core.AbstractTestClass;
import whisit.model.event.Artwork;
import whisit.repository.UserRepository;

import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by dinesh on 1/2/2016.
 */
public class UserCreateTest extends AbstractTestClass {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserCreateTest.class);


    @Autowired
    private UserRepository userRepository;

    private static final Integer NUM_OF_USERS = 100;
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void testMethod() {


        createUsers();

    }

    private void createUsers() {

        LOGGER.info("Creating users");
        List<Future<User>> futures = Lists.newArrayList();

        for (int i = 0; i < NUM_OF_USERS; i++) {
            futures.add(executorService.submit(new GetUser()));
        }
        List<User> users = Lists.newArrayList();

        for (Future<User> future : futures) {

            try {
                users.add(future.get());
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        LOGGER.info("Number of Users:" + users.size());

        userRepository.save(users);
    }

    static Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new JsonDeserializer<User>() {
        @Override
        public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            User user = new User();

            user.setFirstName(jsonObject.get("name").getAsJsonObject().get("first").getAsString());
            user.setLastName(jsonObject.get("name").getAsJsonObject().get("last").getAsString());
            User.Address address = new User.Address();
            address.setCity(jsonObject.get("location").getAsJsonObject().get("city").getAsString());
            address.setStreet(jsonObject.get("location").getAsJsonObject().get("street").getAsString());
            address.setZip(jsonObject.get("location").getAsJsonObject().get("zip").getAsString());
            address.setState(jsonObject.get("location").getAsJsonObject().get("state").getAsString());

            user.setAddress(address);
            Picture picture = new Picture();
            picture.setLarge(new Artwork().setFilePath(jsonObject.get("picture").getAsJsonObject().get("large").getAsString()));
            picture.setMedium(new Artwork().setFilePath(jsonObject.get("picture").getAsJsonObject().get("medium").getAsString()));
            picture.setThumbnail(new Artwork().setFilePath(jsonObject.get("picture").getAsJsonObject().get("thumbnail").getAsString()));


            user.setPicture(picture);
            user.setEmail(jsonObject.get("email").getAsString());
            user.setUserName(jsonObject.get("username").getAsString());
            user.setPassword(jsonObject.get("password").getAsString());
            user.setPhone(jsonObject.get("phone").getAsString());
            user.setDob(Date.from(Instant.ofEpochSecond(Long.parseLong(jsonObject.get("dob").getAsString()))));
            user.setDateRegistered(Date.from(Instant.ofEpochSecond(Long.parseLong(jsonObject.get("registered").getAsString()))));
            return user;
        }
    }).create();

    static class GetUser implements Callable<User> {

        @Override
        public User call() throws Exception {
            String url = "http://api.randomuser.me/";
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);
            JsonParser parser = new JsonParser();

            JsonObject object = parser.parse(response).getAsJsonObject();
            LOGGER.info("jsonObject=" + object);
            JsonArray resultsArray = object.get("results").getAsJsonArray();
            LOGGER.info("resultsArray=" + resultsArray);
            JsonObject userObject = resultsArray.get(0).getAsJsonObject();
            User user = gson.fromJson(userObject.get("user"), User.class);

            ClientHttpRequest clientHttpRequest = null;

            getImageFile("images/userprofile/large", user.getPicture().getLarge().getFilePath());
            getImageFile("images/userprofile/medium", user.getPicture().getMedium().getFilePath());
            getImageFile("images/userprofile/thumbnail", user.getPicture().getThumbnail().getFilePath());


            LOGGER.info("Returning user:" + user);


            return user;
        }


    }

}
