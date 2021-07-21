package servicemodule.service;


import org.springframework.boot.autoconfigure.webservices.WebServicesProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import resourcemodule.model.GameResource;
import resourcemodule.repository.GameRepository;
import servicemodule.format.GameFormat;
import servicemodule.mapper.GameMapper;

import java.util.List;

@Service
@EnableConfigurationProperties(WebServicesProperties.class)

public class GameService {
    GameRepository gameRepository;
    GameMapper gameMapper = new GameMapper();

    public GameFormat creategame(GameFormat gameFormat){
        GameResource gameResource = gameMapper.fromDTO(gameFormat);
        return gameMapper.fromModel(gameRepository.save(gameResource));
    }
    public List<GameFormat> getAll(){
        List<GameResource> gameResources = (List<GameResource>) gameRepository.findAll();
        return gameMapper.fromCollectionList(gameResources);
    }
}
