package whisit.model.event;

import whisit.model.AbstractNamedIdElement;

/**
 * Created by dineshgurumurthy on 12/2/15.
 */

public class Video extends AbstractNamedIdElement {

    private String site;

    private String key;

    private Integer size;

    private String type;

    public String getSite() {
        return site;
    }

    public Video setSite(String site) {
        this.site = site;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Video setKey(String key) {
        this.key = key;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public Video setSize(Integer size) {
        this.size = size;
        return this;
    }

    public String getType() {
        return type;
    }

    public Video setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("Video{");
        sb.append("site='").append(site).append('\'');
        sb.append(", key='").append(key).append('\'');
        sb.append(", size=").append(size);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
