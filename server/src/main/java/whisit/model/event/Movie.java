package whisit.model.event;


import whisit.model.AbstractNamedIdElement;

import java.util.List;

/**
 * Created by dineshgurumurthy on 12/2/15.
 */

public class Movie extends AbstractNamedIdElement {

    private long movieDbId;

    private String originalTitle;

    private float popularity;
    private String backdropPath;
    private String posterPath;

    private String releaseDate;
    private boolean adult;
    private long budget;
    private List<Genre> genres;
    private String homepage;
    private String overview;
    private String imdbID;
    private long revenue;
    private int runtime;

    private List<Language> spokenLanguages;

    private String tagline;
    private float userRating;
    private float voteAverage;

    private int voteCount;


    private String status;

    // Appendable responses

    private List<Artwork> images;


    private List<String> keywords;


    private List<ReleaseInfo> releases;

    private List<Video> videos;
    private List<Review> reviews;

    public long getMovieDbId() {
        return movieDbId;
    }

    public Movie setMovieDbId(long movieDbId) {
        this.movieDbId = movieDbId;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public Movie setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public float getPopularity() {
        return popularity;
    }

    public Movie setPopularity(float popularity) {
        this.popularity = popularity;
        return this;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Movie setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public Movie setPosterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Movie setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public boolean isAdult() {
        return adult;
    }

    public Movie setAdult(boolean adult) {
        this.adult = adult;
        return this;
    }

    public long getBudget() {
        return budget;
    }

    public Movie setBudget(long budget) {
        this.budget = budget;
        return this;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Movie setGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public String getHomepage() {
        return homepage;
    }

    public Movie setHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public Movie setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public String getImdbID() {
        return imdbID;
    }

    public Movie setImdbID(String imdbID) {
        this.imdbID = imdbID;
        return this;
    }

    public long getRevenue() {
        return revenue;
    }

    public Movie setRevenue(long revenue) {
        this.revenue = revenue;
        return this;
    }

    public int getRuntime() {
        return runtime;
    }

    public Movie setRuntime(int runtime) {
        this.runtime = runtime;
        return this;
    }

    public List<Language> getSpokenLanguages() {
        return spokenLanguages;
    }

    public Movie setSpokenLanguages(List<Language> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
        return this;
    }

    public String getTagline() {
        return tagline;
    }

    public Movie setTagline(String tagline) {
        this.tagline = tagline;
        return this;
    }

    public float getUserRating() {
        return userRating;
    }

    public Movie setUserRating(float userRating) {
        this.userRating = userRating;
        return this;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public Movie setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public Movie setVoteCount(int voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Movie setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<Artwork> getImages() {
        return images;
    }

    public Movie setImages(List<Artwork> images) {
        this.images = images;
        return this;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public Movie setKeywords(List<String> keywords) {
        this.keywords = keywords;
        return this;
    }

    public List<ReleaseInfo> getReleases() {
        return releases;
    }

    public Movie setReleases(List<ReleaseInfo> releases) {
        this.releases = releases;
        return this;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public Movie setVideos(List<Video> videos) {
        this.videos = videos;
        return this;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Movie setReviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }


    public String debugString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("Movie{");
        sb.append(", movieDbId='").append(movieDbId).append('\'');
        sb.append(", imdbID='").append(imdbID).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString()).append("\t").append("Movie{");
        sb.append(", movieDbId='").append(movieDbId).append('\'');
        sb.append(", originalTitle='").append(originalTitle).append('\'');
        sb.append(", popularity=").append(popularity);
        sb.append(", backdropPath='").append(backdropPath).append('\'');
        sb.append(", posterPath='").append(posterPath).append('\'');
        sb.append(", releaseDate='").append(releaseDate).append('\'');
        sb.append(", adult=").append(adult);
        sb.append(", budget=").append(budget);
        sb.append(", genres=").append(genres);
        sb.append(", homepage='").append(homepage).append('\'');
        sb.append(", overview='").append(overview).append('\'');
        sb.append(", imdbID='").append(imdbID).append('\'');
        sb.append(", revenue=").append(revenue);
        sb.append(", runtime=").append(runtime);
        sb.append(", spokenLanguages=").append(spokenLanguages);
        sb.append(", tagline='").append(tagline).append('\'');
        sb.append(", userRating=").append(userRating);
        sb.append(", voteAverage=").append(voteAverage);
        sb.append(", voteCount=").append(voteCount);
        sb.append(", status='").append(status).append('\'');
        sb.append(", images=").append(images);
        sb.append(", keywords=").append(keywords);
        sb.append(", releases=").append(releases);
        sb.append(", videos=").append(videos);
        sb.append(", reviews=").append(reviews);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (getMovieDbId() != movie.getMovieDbId()) return false;
        if (getOriginalTitle() != null ? !getOriginalTitle().equals(movie.getOriginalTitle()) : movie.getOriginalTitle() != null)
            return false;
        return !(getImdbID() != null ? !getImdbID().equals(movie.getImdbID()) : movie.getImdbID() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getMovieDbId() ^ (getMovieDbId() >>> 32));
        result = 31 * result + (getOriginalTitle() != null ? getOriginalTitle().hashCode() : 0);
        result = 31 * result + (getImdbID() != null ? getImdbID().hashCode() : 0);
        return result;
    }
}
