package mongotest;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import whisit.core.AbstractTestClass;
import whisit.model.GeoName;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by dinesh on 12/8/2015.
 */
public class MongoQuery extends AbstractTestClass {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Environment env;


    @Test
    public void testMethod() {
        Mongo mongo = null;
        try {
            Point point = new GeoJsonPoint(-74.00597, 40.7126);

            mongo = new MongoClient(new ServerAddress(env.getProperty("mongodb.host"), Integer.parseInt(env.getProperty("mongodb.port"))), MongoClientOptions.builder().connectTimeout(1500)
                    .connectionsPerHost(8)
                    .maxWaitTime(1500)
                    .socketKeepAlive(true)
                    .build());

            String database = "geodata";
            MongoTemplate mongoTemplate = new MongoTemplate(mongo, database);

            List<GeoName> geodataList = mongoTemplate.find(new Query(Criteria.where("geolocation").near(point).maxDistance(10000)), GeoName.class);
            LOGGER.info("geodataList size:" + geodataList.size());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
