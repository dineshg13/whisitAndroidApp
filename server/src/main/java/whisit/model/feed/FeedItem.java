package whisit.model.feed;

import whisit.model.AbstractIdElement;
import whisit.model.User;
import whisit.model.event.Scene;
import whisit.model.place.Place;

/**
 * Created by dinesh on 1/1/2016.
 */
public class FeedItem extends AbstractIdElement {

    private User user;
    private Scene scene;
    private Place place;
    private String imageUrl;

    public User getUser() {
        return user;
    }

    public FeedItem setUser(User user) {
        this.user = user;
        return this;
    }

    public Scene getScene() {
        return scene;
    }

    public FeedItem setScene(Scene scene) {
        this.scene = scene;
        return this;
    }

    public Place getPlace() {
        return place;
    }

    public FeedItem setPlace(Place place) {
        this.place = place;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public FeedItem setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FeedItem{");
        sb.append("user=").append(user);
        sb.append(", scene=").append(scene);
        sb.append(", place=").append(place);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
