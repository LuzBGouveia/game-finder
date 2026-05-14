package fiap.com.br.gamefinder.dto;


import fiap.com.br.gamefinder.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record GameRequest(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @PastOrPresent
        @NotNull
        LocalDate releaseDate,

        @NotNull
        Double rating,

        @NotNull
        Genre genre,

        @NotNull
        Platform platform,

        @NotBlank
        String coverUrl,

        @NotBlank
        String backdropUrl

) {
    public Game toEntity() {
        return Game.builder()
                .title(title)
                .description(description)
                .releaseDate(releaseDate)
                .rating(rating)
                .genre(genre)
                .platform(platform)
                .coverUrl(coverUrl)
                .backdropUrl(backdropUrl)
                .build();
    }
}
