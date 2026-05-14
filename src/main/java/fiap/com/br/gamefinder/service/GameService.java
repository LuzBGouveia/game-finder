package fiap.com.br.gamefinder.service;

import fiap.com.br.gamefinder.dto.GameRequest;
import fiap.com.br.gamefinder.model.Game;
import fiap.com.br.gamefinder.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findById(Long id) {
        return gameRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professional not found")
        );
    }

    public List<Game> findAllByGenreId(Long id) {
        return gameRepository.findAllByGenreId(id);
    }

    public List<Game> findAllByPlatformId(Long id) {
        return gameRepository.findAllByPlatformId(id);
    }

    public Game save(GameRequest gameRequest) {
        return gameRepository.save(gameRequest.toEntity());
    }

    public Game update(Long id, GameRequest gameRequest) {
        findById(id);
        Game game = gameRequest.toEntity();
        game.setId(id);
        return gameRepository.save(game);
    }

    public void delete(Long id) {
        findById(id);
        gameRepository.deleteById(id);
    }
}
