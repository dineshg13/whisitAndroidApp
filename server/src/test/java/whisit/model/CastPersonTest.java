package whisit.model;

import whisit.core.AbstractTestClass;
import whisit.model.event.people.CastPerson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import whisit.repository.PersonRepository;

import java.util.Date;

/**
 * Created by dineshgurumurthy on 12/3/15.
 */
public class CastPersonTest extends AbstractTestClass {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testMethod() {
        CastPerson p = new CastPerson();
        p.setName("Dinesh");
        p.setCreated(new Date());
        p.setProfilePath("dd39392umk");
        p.setCastId(222);
        LOGGER.info("saving person:" + p);
        p = personRepository.save(p);
        LOGGER.info("Saved person:" + p);
    }
}
