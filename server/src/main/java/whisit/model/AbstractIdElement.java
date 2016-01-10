package whisit.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by dineshgurumurthy on 7/22/15.
 */
@Document
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")

public abstract class AbstractIdElement {

    @Id
    private String id;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    @Indexed
    private Date updated;

    public String getId() {
        return id;
    }

    public AbstractIdElement() {
        ObjectId objectId = new ObjectId();
        this.id = objectId.toHexString();
    }

    public AbstractIdElement setId(String id) {
        this.id = id;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public AbstractIdElement setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getUpdated() {
        return updated;
    }

    public AbstractIdElement setUpdated(Date updated) {
        this.updated = updated;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "{");
        sb.append("id=").append(id);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append('}');
        return sb.toString();
    }
}
