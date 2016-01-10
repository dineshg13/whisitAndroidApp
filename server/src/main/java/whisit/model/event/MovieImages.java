package whisit.model.event;

import whisit.model.AbstractIdElement;

import java.util.List;

/**
 * Created by dinesh on 12/5/2015.
 */
public class MovieImages extends AbstractIdElement {

    private List<Artwork> backdrops;
    private List<Artwork> posters;
    private List<Artwork> profiles;

    // needed for episode backdrops
    private List<Artwork> stills;

    public List<Artwork> getBackdrops() {
        return backdrops;
    }

    public MovieImages setBackdrops(List<Artwork> backdrops) {
        this.backdrops = backdrops;
        return this;
    }

    public List<Artwork> getPosters() {
        return posters;
    }

    public MovieImages setPosters(List<Artwork> posters) {
        this.posters = posters;
        return this;
    }

    public List<Artwork> getProfiles() {
        return profiles;
    }

    public MovieImages setProfiles(List<Artwork> profiles) {
        this.profiles = profiles;
        return this;
    }

    public List<Artwork> getStills() {
        return stills;
    }

    public MovieImages setStills(List<Artwork> stills) {
        this.stills = stills;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("MovieImages{");
        sb.append("backdrops=").append(backdrops);
        sb.append(", posters=").append(posters);
        sb.append(", profiles=").append(profiles);
        sb.append(", stills=").append(stills);
        sb.append('}');
        return sb.toString();
    }
}
