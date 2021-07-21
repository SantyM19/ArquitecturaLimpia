package servicemodule.mapper;

import resourcemodule.model.GameResource;
import servicemodule.format.GameFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameMapper {

    public GameResource fromDTO(GameFormat gameFormat){
        GameResource gameResource = new GameResource();
        gameResource.setId(gameFormat.getId());
        gameResource.setNombre(gameFormat.getNombre());
        gameResource.setCategoria(gameFormat.getCategoria());
        return gameResource;
    }

    public GameFormat fromModel(GameResource gameResource){
        GameFormat gameFormatDTO = new GameFormat();
        gameFormatDTO.setId(gameResource.getId());
        gameFormatDTO.setNombre(gameResource.getNombre());
        gameFormatDTO.setCategoria(gameResource.getCategoria());
        return gameFormatDTO;
    }
    public List<GameFormat> fromCollectionList(List<GameResource> collection){
       if (collection == null){
           return null;
       }

       List<GameFormat> list = new ArrayList<>(collection.size());
       Iterator listTracks = collection.iterator();

       while(listTracks.hasNext()){
           GameResource gameResource = (GameResource)listTracks.next();
           list.add(fromModel(gameResource));
       }
       return list;
    }
}
