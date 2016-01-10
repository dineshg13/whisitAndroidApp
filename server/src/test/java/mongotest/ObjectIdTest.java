package mongotest;

import whisit.core.AbstractTestClass;
import org.bson.types.ObjectId;
import org.junit.Test;

/**
 * Created by dinesh on 12/12/2015.
 */
public class ObjectIdTest extends AbstractTestClass {

    @Test
    public void testMethod() {

        ObjectId objectId = new ObjectId();
        LOGGER.info(objectId.toHexString());

    }
}
