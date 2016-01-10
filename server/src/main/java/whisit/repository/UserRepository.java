package whisit.repository;

import whisit.model.User;
import whisit.repo.IdRepository;

/**
 * Created by dinesh on 12/5/2015.
 */
public interface UserRepository extends IdRepository<User> {

    User findByEmail(String email);

}
