package whisit.model;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by dineshgurumurthy on 12/2/15.
 */
public abstract class AbstractNamedIdElement extends AbstractIdElement {

    @Indexed
    private String name;

    public String getName() {
        return name;
    }


    public AbstractNamedIdElement setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append(this.getClass().getSimpleName() + "{");

        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
