package resourcemodule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import resourcemodule.model.GameResource;

public interface GameRepository extends MongoRepository<GameResource, String> {
}
