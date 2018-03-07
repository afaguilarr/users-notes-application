package hello;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;

    public String username;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username=%s]",
                id, username);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}