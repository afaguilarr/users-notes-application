package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.mongodb.repository.Query;

@RepositoryRestResource(collectionResourceRel = "notes", path = "notes")
public interface NoteRepository extends MongoRepository<Note, String> {
	public List<Note> findByText(@Param("text") String text);
    public List<Note> findByDate(@Param("date") String date);
    @Query("{ 'user.username' : ?0}")
    public List<Note> findByUserUsername(@Param("username") String username);
}
