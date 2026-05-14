package fiap.com.br.gamefinder.controller;

import fiap.com.br.gamefinder.dto.GameRequest;
import fiap.com.br.gamefinder.model.Game;
import fiap.com.br.gamefinder.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public List<EntityModel<Game>> findAll() {
        return gameService.findAll()
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }

    @GetMapping("genre/{genreId}")
    public List<EntityModel<Game>> findAllByGenreId(@PathVariable Long id) {
        return gameService.findAllByGenreId(id)
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }

    @GetMapping("platforms/{platformId}")
    public List<EntityModel<Game>> findAllByPlatformId(@PathVariable Long id) {
        return gameService.findAllByPlatformId(id)
                .stream()
                .map(Game::toEntityModel)
                .toList();
    }

    @GetMapping("{id}")
    public EntityModel<Game> findById(@PathVariable Long id) {
        return gameService.findById(id).toEntityModel();
    }

    @PostMapping
    public EntityModel<Game> addGame(@RequestBody GameRequest gameRequest) {
        return gameService.save(gameRequest).toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Game> update(@PathVariable Long id, @RequestBody GameRequest gameRequest) {
        return gameService.update(id, gameRequest).toEntityModel();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        gameService.delete(id);
    }
}
