package whisit.model;

import whisit.model.event.Artwork;

/**
 * Created by dinesh on 1/3/2016.
 */
public class Picture extends AbstractIdElement {

    private Artwork large;
    private Artwork medium;
    private Artwork thumbnail;

    public Artwork getLarge() {
        return large;
    }

    public Picture setLarge(Artwork large) {
        this.large = large;
        return this;
    }

    public Artwork getMedium() {
        return medium;
    }

    public Picture setMedium(Artwork medium) {
        this.medium = medium;
        return this;
    }

    public Artwork getThumbnail() {
        return thumbnail;
    }

    public Picture setThumbnail(Artwork thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("Picture{");
        sb.append("large=").append(large);
        sb.append(", medium=").append(medium);
        sb.append(", thumbnail=").append(thumbnail);
        sb.append('}');
        return sb.toString();
    }
}
