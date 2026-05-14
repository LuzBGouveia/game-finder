package fiap.com.br.gamefinder.controller;

import fiap.com.br.gamefinder.dto.GenreRequest;
import fiap.com.br.gamefinder.model.Genre;
import fiap.com.br.gamefinder.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public List<EntityModel<Genre>> findAll() {
        return genreService.findAll().stream().map(Genre::toEntityModel).toList();
    }

    @GetMapping("{id}")
    public EntityModel<Genre> findById(@PathVariable Long id) {
        return genreService.findById(id).toEntityModel();
    }

    @PostMapping
    public EntityModel<Genre> addGenre(@RequestBody GenreRequest genreRequest) {
        return genreService.save(genreRequest).toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Genre> update(@PathVariable Long id, @RequestBody GenreRequest genreRequest) {
        return genreService.update(id, genreRequest).toEntityModel();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        genreService.delete(id);
    }
}
