package ModelClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
@Id
@Column(name="callno",unique=true)
private String callno;
@Column(name="name")
private String name;
@Column(name="author")
private String author;
@Column(name="publisher")
private String publisher;
@Column(name="quantity")
private int quantity;
@Column(name="issued")
private int issued;
public Book() {
}
public Book(String callno, String name, String author, String publisher, int quantity) {
	super();
	this.callno = callno;
	this.name = name;
	this.author = author;
	this.publisher = publisher;
	this.quantity = quantity;
}
public String getCallno() {
	return callno;
}
public void setCallno(String callno) {
	this.callno = callno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getIssued() {
	return issued;
}
public void setIssued(int issued) {
	this.issued = issued;
}

}
