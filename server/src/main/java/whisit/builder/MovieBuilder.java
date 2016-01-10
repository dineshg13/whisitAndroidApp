package whisit.builder;

import com.google.common.collect.Lists;
import info.movito.themoviedbapi.model.MovieDb;
import whisit.model.event.*;
import whisit.model.event.Review;
import whisit.model.event.Video;

/**
 * Created by dinesh on 12/5/2015.
 */
public class MovieBuilder {

    public static Movie build(MovieDb movieDb) {

        Movie movie = new Movie();

        movie.setName(movieDb.getTitle());
        movie.setOriginalTitle(movieDb.getOriginalTitle());

        movie.setAdult(movieDb.isAdult());
        movie.setGenres(movieDb.getGenres() != null ? Lists.transform(movieDb.getGenres(), input -> {
                    Genre genre = new Genre();
                    genre.setName(input.getName());
                    return genre;
                }
        ) : null);

        movie.setImages(movieDb.getImages() != null ? Lists.transform(movieDb.getImages(), input -> {
            Artwork artwork = new Artwork();
            artwork.setLanguage(input.getFlag());
            artwork.setAspectRatio(input.getAspectRatio());
            artwork.setFilePath(input.getFilePath());
            artwork.setFlag(input.getFlag());
            artwork.setHeight(input.getHeight());
            artwork.setWidth(input.getWidth());
            artwork.setVoteAverage(input.getVoteAverage());
            artwork.setVoteCount(input.getVoteCount());
            return artwork;
        }) : null);


        movie.setVoteAverage(movieDb.getVoteAverage());
        movie.setVoteCount(movieDb.getVoteCount());
        movie.setRuntime(movieDb.getRuntime());
        movie.setBudget(movieDb.getBudget());
        movie.setBackdropPath(movieDb.getBackdropPath());
        movie.setPosterPath(movieDb.getPosterPath());
        movie.setHomepage(movieDb.getHomepage());
        movie.setImdbID(movieDb.getImdbID());
        movie.setKeywords(movieDb.getKeywords() != null ? Lists.transform(movieDb.getKeywords(), input ->
                input.getName()) : null);

        movie.setOverview(movieDb.getOverview());
        movie.setPopularity(movieDb.getPopularity());
        movie.setRevenue(movieDb.getRevenue());

        movie.setSpokenLanguages(movieDb.getSpokenLanguages() != null ? Lists.transform(movieDb.getSpokenLanguages(), input -> {
                    Language language = new Language();
                    language.setIsoCode(input.getIsoCode());
                    language.setName(input.getName());
                    return language;
                }

        ) : null);
        movie.setReleases(movieDb.getReleases() != null ? Lists.transform(movieDb.getReleases(), input -> {
            ReleaseInfo info = new ReleaseInfo();
            info.setCountry(input.getCountry());
            info.setReleaseDate(input.getReleaseDate());
            info.setCertification(input.getCertification());
            return info;
        }) : null);

        movie.setStatus(movieDb.getStatus());
        movie.setReviews(movieDb.getReviews() != null ? Lists.transform(movieDb.getReviews(), input -> {
            Review review = new Review();
            review.setAuthor(input.getAuthor());
            review.setContent(input.getContent());
            review.setUrl(input.getUrl());

            return review;
        }) : null);

        movie.setVideos(movieDb.getVideos() != null ? Lists.transform(movieDb.getVideos(), input -> {
            Video video = new Video();
            video.setName(input.getName());
            video.setKey(input.getKey());
            video.setSite(input.getSite());
            video.setType(input.getType());
            video.setSize(input.getSize());


            return video;

        }) : null);
        movie.setMovieDbId(movieDb.getId());
        return movie;
    }

}
