package whisit.model;

import com.google.common.collect.Lists;
import com.google.gson.*;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.client.RestTemplate;
import whisit.core.AbstractTestClass;
import whisit.model.event.Artwork;
import whisit.model.place.Place;
import whisit.repository.PlaceRepository;
import whisit.types.PictureType;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dinesh on 1/3/2016.
 */
public class PlaceCreateTest extends AbstractTestClass {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private Environment env;


    @Test
    public void testMethod() {
        createPlaces();
    }


    private void createPlaces() {
        String url = "https://commons.wikimedia.org/w/api.php?action=query&";
        String queryString = "generator=geosearch&ggsprimary=all&ggsnamespace=6&ggsradius=100&ggslimit=10&prop=imageinfo&iilimit=1&iiprop=url&iiurlwidth=200&iiurlheight=200&format=json&ggscoord=";

        List<GeoName> geoNames = somePlacesInNyc();

        List<Place> places = Lists.newArrayList();
        for (int i = 0; i < geoNames.size(); i++) {
            GeoName geoName = geoNames.get(i);
            Place place = new Place();
            place.setName(geoName.getName());
            place.setAddress(StringUtils.join(geoName.getAdmin1(), geoName.getAdmin2(), geoName.getAdmin3(), geoName.getAdmin4()));
            place.setCountry(geoName.getCountry());
            place.setPoint(geoName.getGeolocation());
            String URL = url + queryString + place.getPoint().getY() + "|" + place.getPoint().getX();
            List<Picture> pictures = getWikiImages(URL);
            place.setPictures(pictures);
            LOGGER.info(place.toString());


            places.add(place);
        }
        placeRepository.save(places);
    }

    static final String THUMBNAIL_BASE_DIR = "images/places/thumbnail";
    static final String BASE_DIR = "images/places/large";

    private List<Picture> getWikiImages(String url) {
        RestTemplate template = new RestTemplate();
        LOGGER.info("url=" + url);
        String response = template.getForObject(url, String.class);
        LOGGER.info("response=" + response);

        JsonObject object = new JsonObject();
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(response).getAsJsonObject();

        List<Picture> pictures = new ArrayList<>();
        if (jsonObject.get("query") != null && jsonObject.get("query").getAsJsonObject().get("pages") != null) {
            JsonObject asJsonObject = jsonObject.get("query").getAsJsonObject().get("pages").getAsJsonObject();
            LOGGER.info("size of response processing:" + asJsonObject.entrySet().size());
            for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {


                JsonObject pageObject = entry.getValue().getAsJsonObject();
                if (pageObject.get("imageinfo") != null) {
                    JsonArray imageInfoArray = pageObject.get("imageinfo").getAsJsonArray();

                    for (int i = 0; i < imageInfoArray.size(); i++) {
                        JsonElement element = imageInfoArray.get(i);
                        String thumburl = getImageInfo(element.getAsJsonObject(), "thumburl");
                        String imageUrl = getImageInfo(element.getAsJsonObject(), "url");
                        String thumbHeight = getImageInfo(element.getAsJsonObject(), "thumbheight");
                        String thumbwidth = getImageInfo(element.getAsJsonObject(), "thumbwidth");

                        Artwork thumbart = new Artwork();
                        thumbart.setFilePath(thumburl);
                        thumbart.setHeight(Integer.valueOf(thumbHeight));
                        thumbart.setWidth(Integer.valueOf(thumbwidth));
                        thumbart.setType(PictureType.THUMBAIL);

                        Artwork artwork = new Artwork();
                        artwork.setFilePath(imageUrl);
                        artwork.setType(PictureType.LARGE);

                        Picture picture = new Picture();
                        picture.setThumbnail(thumbart);
                        picture.setLarge(artwork);
                        pictures.add(picture);

                        getImageFile(THUMBNAIL_BASE_DIR, thumburl);
                        getImageFile(BASE_DIR, imageUrl);
                    }
                }
            }

        }

        return pictures;
    }

    private String getImageInfo(JsonObject element, String key) {
        if (element.get(key) != null)
            return element.get(key).getAsString();
        return null;
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
