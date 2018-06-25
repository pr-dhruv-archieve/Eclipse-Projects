package mp.feereport.entity;

public class Accountant {
	
	private int id;
	String name, password, email, contact;
	
	public Accountant() {
		super();
	}
	
	public Accountant(int id, String name, String password, String email, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contact = contact;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getContact() {
		return this.contact;
	}
	
}
