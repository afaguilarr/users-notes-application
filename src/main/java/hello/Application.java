package hello;

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}*/

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		noteRepository.deleteAll();
		userRepository.deleteAll();

		// save a couple of Users
		userRepository.save(new User("XxPepexX"));
		userRepository.save(new User("ElBuenon"));
		
		// save a couple of Notes
		noteRepository.save(new Note("Hola me llamo andrés", (new LocalDate()).toString(), userRepository.findByUsername("XxPepexX")));
		noteRepository.save(new Note("Volver a llevar a Andres", (new LocalDate()).toString(), userRepository.findByUsername("ElBuenon")));

		// fetch all Notes
		System.out.println("Notes found with findAll():");
		System.out.println("-------------------------------");
		for (Note Note : noteRepository.findAll()) {
			System.out.println(Note);
		}
		System.out.println();
		
		// fetch all Users
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User User : userRepository.findAll()) {
				System.out.println(User);
		}
		System.out.println();

		// fetch an individual Note
		System.out.println("Note found with findByText(\"Hola me llamo andrés\"):");
		System.out.println("--------------------------------");
		System.out.println(noteRepository.findByText("Hola me llamo andrés"));

		System.out.println("Notes found with findByDate(Today):");
		System.out.println("--------------------------------");
		for (Note Note : noteRepository.findByDate((new LocalDate()).toString())) {
			System.out.println(Note);
		}
		System.out.println();
		
		// fetch an individual User
		System.out.println("User found with findByUsername(\"XxPepexX\"):");
		System.out.println("--------------------------------");
		System.out.println(userRepository.findByUsername("XxPepexX"));
		System.out.println();
		
		//This will Update a Note in the DB
		for (Note Note : noteRepository.findByText("Volver a llevar a Andres")) {
			noteRepository.delete(Note);
			Note.setText("Ya no quiero");
			noteRepository.save(Note);
		}
		
		//This will Update an User in the DB
		User U = userRepository.findByUsername("XxPepexX");
		userRepository.delete(U);
		U.setUsername("Pepe");
		userRepository.save(U);
		
		System.out.println("Notes found with findAll() after Updating:");
		System.out.println("-------------------------------");
		for (Note Note : noteRepository.findAll()) {
			System.out.println(Note);
		}
		System.out.println();
		
		//This will delete some Notes
		noteRepository.delete(noteRepository.findByDate((new LocalDate()).toString()));
		System.out.println("Notes found with findAll() after Deleting:");
		System.out.println("-------------------------------");
		for (Note Note : noteRepository.findAll()) {
			System.out.println(Note);
		}
		System.out.println();
	
		
		// save a couple of Notes
		System.out.println("LLEGA HASTA AQUI???");
		noteRepository.save(new Note("Hola me llamo andrés", (new LocalDate()).toString(), userRepository.findByUsername("ElBuenon")));
		System.out.println("LLEGA HASTA AQUI???");
		
		noteRepository.save(new Note("Volver a llevar a Andres", (new LocalDate()).toString(), userRepository.findByUsername("ElBuenon")));
		System.out.println("LLEGA HASTA AQUI?????????");
		
		System.out.println("Notes found with findAll() before Deleting an user:");
		System.out.println("-------------------------------");
		for (Note Note : noteRepository.findAll()) {
			System.out.println(Note);
		}
		
		//This will delete a User and its notes
		U = userRepository.findByUsername("ElBuenon");
		noteRepository.delete(noteRepository.findByUserUsername(U.getUsername()));
		userRepository.delete(U);
		
		
		System.out.println("Notes found with findAll() after Deleting an user:");
		System.out.println("-------------------------------");
		for (Note Note : noteRepository.findAll()) {
			System.out.println(Note);
		}
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User User : userRepository.findAll()) {
				System.out.println(User);
		}
		System.out.println();	
	}
}