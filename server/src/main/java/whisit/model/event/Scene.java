package whisit.model.event;

import org.springframework.data.mongodb.core.mapping.DBRef;
import whisit.model.AbstractNamedIdElement;
import whisit.model.event.people.CastPerson;
import whisit.model.place.Place;

import java.util.List;


/**
 * Created by dinesh on 12/6/2015.
 */
public class Scene extends AbstractNamedIdElement {

    private String site;
    private String key;
    private String description;
    private Long duration;
    private Long intialOffset;


    @DBRef
    private List<CastPerson> cast;

    @DBRef
    private Movie movie;

    @DBRef
    private List<Place> places;

    public Scene(Movie movie) {
        this.movie = movie;
    }

    public String getSite() {
        return site;
    }

    public Scene setSite(String site) {
        this.site = site;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Scene setKey(String key) {
        this.key = key;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Scene setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getDuration() {
        return duration;
    }

    public Scene setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    public Long getIntialOffset() {
        return intialOffset;
    }

    public Scene setIntialOffset(Long intialOffset) {
        this.intialOffset = intialOffset;
        return this;
    }

    public List<CastPerson> getCast() {
        return cast;
    }

    public Scene setCast(List<CastPerson> cast) {
        this.cast = cast;
        return this;
    }

    public Movie getMovie() {
        return movie;
    }

    public Scene setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public Scene setPlaces(List<Place> places) {
        this.places = places;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("Scene{");
        sb.append("movie=").append(movie.debugString());
        sb.append(", cast=").append(cast);
        sb.append(", intialOffset=").append(intialOffset);
        sb.append(", duration=").append(duration);
        sb.append(", description='").append(description).append('\'');
        sb.append(", places='").append(places).append('\'');
        sb.append(", key='").append(key).append('\'');
        sb.append(", site='").append(site).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
