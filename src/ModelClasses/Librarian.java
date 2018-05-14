package ModelClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Librarian")
public class Librarian {
	@Id
	@GeneratedValue
	@Column(name="id",unique=true)
	private int id;
	@Column(name="name",unique=false)
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="mobile")
	private long mobile;

	public Librarian() {}

	public Librarian(int id, String name, String email, String password, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	public Librarian(String name, String email, String password, long mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}
