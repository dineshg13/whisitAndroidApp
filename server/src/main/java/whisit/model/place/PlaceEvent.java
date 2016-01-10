package whisit.model.place;

import com.google.common.collect.Lists;
import whisit.model.AbstractIdElement;
import whisit.model.event.Scene;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import java.util.List;

/**
 * Created by dinesh on 12/5/2015.
 */
public class PlaceEvent extends AbstractIdElement {

    private Place place;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    private List<Scene> scenes;

    public PlaceEvent(Place place, GeoJsonPoint location) {
        this.place = place;
        this.location = location;
        this.scenes = Lists.newArrayList();
    }


    public Place getPlace() {
        return place;
    }

    public PlaceEvent setPlace(Place place) {
        this.place = place;
        return this;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public PlaceEvent setLocation(GeoJsonPoint location) {
        this.location = location;
        return this;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public PlaceEvent setScenes(List<Scene> scenes) {
        this.scenes = scenes;
        return this;
    }

    public PlaceEvent addScence(Scene scene) {
        if (this.scenes != null) {
            this.scenes.add(scene);
        }
        return this;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("PlaceEvent{");
        sb.append("scenes=").append(scenes);
        sb.append(", place=").append(place);
        sb.append('}');
        return sb.toString();
    }
}
