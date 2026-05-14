package fiap.com.br.gamefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class GameFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameFinderApplication.class, args);
    }

}
