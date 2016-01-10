package whisit.model.event;

import whisit.model.AbstractIdElement;

import java.util.List;

/**
 * Created by dinesh on 12/11/2015.
 */
public class MovieScenesHolder extends AbstractIdElement {

    private Movie movie;
    private List<Scene> scenes;

    public MovieScenesHolder(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public MovieScenesHolder setMovie(Movie movie) {
        this.movie = movie;
        return this;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public MovieScenesHolder setScenes(List<Scene> scenes) {
        this.scenes = scenes;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("MovieScenesHolder{");
        sb.append("movie=").append(movie);
        sb.append(", scenes=").append(scenes);
        sb.append('}');
        return sb.toString();
    }
}
