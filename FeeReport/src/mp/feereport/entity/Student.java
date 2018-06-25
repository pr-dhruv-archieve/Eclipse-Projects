package mp.feereport.entity;

public class Student {
	
	private int rollNo;
	private String name, email, course;
	
	private double fee, paid, due;
	private String address, city, state, country, contact;
	
	public Student() {
		
	}
	
	public Student(String name, String email, String course, double fee, double paid, double due, String addess, String city, String state, String country, String contact) {
		super();
		this.name = name;
		this.email = email;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = addess;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contact = contact;
	}
	
	public Student(int rollNo, String name, String email, String course, double fee, double paid, double due, String addess, String city, String state, String country, String contact) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.email = email;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = addess;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contact = contact;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public int getRollNo() {
		return this.rollNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getname() {
		return this.name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getCourse() {
		return this.course;
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public double getFee(){
		return this.fee;
	}
	
	public void setPaid(double paid) {
		this.paid = paid;
	}
	
	public double getPaid(){
		return this.paid;
	}
	
	public void setDue(double due) {
		this.due = due;
	}
	
	public double getDue(){
		return this.due;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return this.city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return this.state;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry() {
		return this.country;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContact() {
		return this.contact;
	}
	
}
