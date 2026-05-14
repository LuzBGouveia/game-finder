package fiap.com.br.gamefinder.model;

import fiap.com.br.gamefinder.controller.GameController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "games")
@Relation(collectionRelation = "gameList")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate releaseDate;

    private Double rating;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Platform platform;

    private String coverUrl;

    private String backdropUrl;

    @Column(name = "in_wishlist")
    private Boolean inWishList;

    public EntityModel<Game> toEntityModel() {
        var linkAllGame = linkTo(methodOn(GameController.class).findAll()).withRel("all-games").withTitle("All games");
        var linkSelf = linkTo(methodOn(GameController.class).findById(id)).withSelfRel().withTitle("Games details");

        return EntityModel.of(this, linkSelf, linkAllGame);
    }
}
