package whisit.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by dinesh on 12/5/2015.
 */
public interface IdRepository<T> extends MongoRepository<T, String> {

}
