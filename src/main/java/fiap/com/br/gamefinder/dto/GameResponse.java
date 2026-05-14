package fiap.com.br.gamefinder.dto;

import fiap.com.br.gamefinder.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public record GameResponse(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        Double rating,
        Genre genre,
        Platform platform,
        String coverUrl,
        String backdropUrl,
        Boolean inWishlist
) {
    public static GameResponse fromEntity(Game game) {
        return new GameResponse(
                game.getId(),
                game.getTitle(),
                game.getDescription(),
                game.getReleaseDate(),
                game.getRating(),
                game.getGenre(),
                game.getPlatform(),
                game.getCoverUrl(),
                game.getBackdropUrl(),
                game.getInWishList()
        );
    }
}
