package whisit.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * Created by dinesh on 11/28/2015.
 */
@Configuration
@EnableMongoAuditing
public class SpringConfig extends AbstractMongoConfiguration {

    private Logger LOGGER = LoggerFactory.getLogger(SpringConfig.class);

    @Autowired
    private Environment env;

    @Value("${mongodb.host}")
    private String mongoDbHost;

    @Value("${mongodb.port}")
    private int mongoDbPort;

    @Value("${mongodb.db}")
    private String defaultDb;

    @Override
    public String getMappingBasePackage() {
        return "core";
    }

    @Override
    protected String getDatabaseName() {
        return defaultDb;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new ServerAddress(mongoDbHost, mongoDbPort), mongoClientOptions());
    }

    @Bean
    public MongoClientOptions mongoClientOptions() {
        // override to more reasonable connection timeout (default is 10 seconds)
        return MongoClientOptions.builder().connectTimeout(1500)
                .connectionsPerHost(30)
                .maxWaitTime(1500)
                .socketKeepAlive(true)
                .build();
    }
}
