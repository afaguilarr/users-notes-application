package hello;

import org.springframework.data.annotation.Id;

public class Note {
	
    @Id
    public String id;

    public String text;
    public String date;
    public User user;

    public Note() {}

    public Note(String text, String date, User user) {
        this.text = text;
        this.date = date;
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format(
                "Note[id=%s, text=%s, date=%s, user=%s]",
                this.id, this.text, this.date, this.user);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}