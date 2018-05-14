package ModelClasses;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="IssueBook")
public class IssueBook {
	@Id
	@GeneratedValue
	@Column(name="id",unique=true)
	int id;
	@Column(name="callno")
	private String callno;
	@Column(name="studentid")
	private String studentid;
	@Column(name="studentname")
	private String studentname;
	@Column(name="studentmobile")
	private long studentmobile;
	@Column(name="issueddate")
	private Date issueddate;
	@Column(name="returnstatus")
	private String returnstatus;

	public IssueBook() {}
	public IssueBook(String callno, String studentid, String studentname, long studentmobile) {
		super();
		this.callno = callno;
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentmobile = studentmobile;
	}
	public IssueBook( String callno, String studentid, String studentname, long studentmobile, Date issueddate,
			String returnstatus) {
		super();
		this.id = id;
		this.callno = callno;
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentmobile = studentmobile;
		this.issueddate = issueddate;
		this.returnstatus = returnstatus;
	}
	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	public Date getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}
	public String getCallno() {
		return callno;
	}
	public void setCallno(String callno) {
		this.callno = callno;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public long getStudentmobile() {
		return studentmobile;
	}
	public void setStudentmobile(long studentmobile) {
		this.studentmobile = studentmobile;
	}
}
