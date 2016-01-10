package event;

import whisit.core.AbstractTestClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import whisit.repository.PlaceEventRepository;

/**
 * Created by dinesh on 12/12/2015.
 */
public class PlaceRetrivalTest extends AbstractTestClass {

    @Autowired
    private PlaceEventRepository placeEventRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testMethod() {

        LOGGER.info("Testing started");
        Point point = new Point(-73.99528, 40.71306);

        Distance max = new Distance(1, Metrics.MILES);

//        Page<PlaceEvent> placeEventGeoResults = placeEventRepository.findByLocationNear(point, max,
//                new PageRequest(0, 200, new Sort(new Sort.Order("distance"))));
//
//        LOGGER.info("PlaceEvents:" + placeEventGeoResults.getTotalElements());
//
//        List<PlaceEvent> geodataList = mongoTemplate.find(new Query(Criteria.where("location").nearSphere(point).maxDistance(2.52321929475516E-4)), PlaceEvent.class);
//        LOGGER.info("geodataList size:" + geodataList.size());


//        placeEventGeoResults.forEach(storeGeoResult -> {
//                    LOGGER.info("distance:" + storeGeoResult.getDistance() + " , Place:" + storeGeoResult.getContent().getPlace());
//
//                }
//        );

    }
}
