package fiap.com.br.gamefinder.controller;

import fiap.com.br.gamefinder.dto.PlatformRequest;
import fiap.com.br.gamefinder.model.Platform;
import fiap.com.br.gamefinder.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platforms")
@RequiredArgsConstructor
public class PlatformController {

    private final PlatformService platformService;

    @GetMapping
    public List<EntityModel<Platform>> findAll() {
        return platformService.findAll().stream().map(Platform::toEntityModel).toList();
    }

    @GetMapping("{id}")
    public EntityModel<Platform> findById(@PathVariable Long id) {
        return platformService.findById(id).toEntityModel();
    }

    @PostMapping
    public EntityModel<Platform> addPlatform(@RequestBody PlatformRequest platformRequest) {
        return platformService.save(platformRequest).toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Platform> update(@PathVariable Long id, @RequestBody PlatformRequest platformRequest) {
        return platformService.update(id, platformRequest).toEntityModel();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        platformService.delete(id);
    }
}
