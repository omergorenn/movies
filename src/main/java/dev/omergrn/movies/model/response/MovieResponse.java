package dev.omergrn.movies.model.response;

import dev.omergrn.movies.model.Review;
import org.bson.types.ObjectId;

import java.util.List;

public record MovieResponse(ObjectId id, String imdbId, String trailerLink, String poster, List<String> backdrops,
                            List<Review> reviews ) {

}
