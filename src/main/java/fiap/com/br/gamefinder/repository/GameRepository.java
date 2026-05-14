package fiap.com.br.gamefinder.repository;

import fiap.com.br.gamefinder.model.Game;
import fiap.com.br.gamefinder.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    public List<Game> findAllByGenreId(Long id);

    public List<Game> findAllByPlatformId(Long id);
}
