package hello;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Users", path = "Users")
public interface UserRepository extends MongoRepository<User, String> {
	public User findByUsername(@Param("username") String username);
}
