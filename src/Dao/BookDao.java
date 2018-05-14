package Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import HibernateUtil.HibernateUtil;
import ModelClasses.Book;
import ModelClasses.IssueBook;

public class BookDao {
	public static int addBook(Book b) {
		int status=0;
		Session session=HibernateUtil.getSession();
		Transaction tr=session.getTransaction();
		try {
			tr=session.beginTransaction();
			session.save(b);
			tr.commit();
			status=1;
		}
		catch(Exception e) {
			tr.rollback();
			System.out.println("Object not saved");
		}
		return status;
	}
	public static List viewBooks() {
		Session session=null;
		Transaction tr=null;
		session=HibernateUtil.getSession();
		List lib=null;
		try {
			tr=session.beginTransaction();
			lib=session.createQuery("from Book").list();
			tr.commit();
		}
		catch(Exception e) {
			tr.rollback();
		}
		return lib;
	}
	public static int getIssued(String callno) {
		int issued=0;
		Session session=null;
		Transaction tr=null;
		session=HibernateUtil.getSession();
		String query="from Book where callno=:c";
		Query q=session.createQuery(query);
		q.setParameter("c", callno);
		try {
			tr=session.beginTransaction();
			List result=q.list();
			System.out.println("After list:"+result.size());
			if(result.isEmpty())return 0;
			Iterator itr=result.iterator();
			Book b=(Book)itr.next();
			issued=b.getIssued();
		}
		catch(Exception e) {
			tr.rollback();
			System.out.println("Error in this function...");
		}
		System.out.println("issued="+issued);
		return issued;
		
	}
	
	public static boolean checkIssue(String callno) {
		Session session=null;
		Transaction tr=null;
		session=HibernateUtil.getSession();
		String query="from Book where callno=:c and quantity > issued";
		Query q=session.createQuery(query);
		q.setParameter("c",callno);
		try {
			tr=session.beginTransaction();
			List result=q.list();
			if(result.isEmpty())return false;
		}
		catch(Exception e) {
			tr.rollback();
		}
		return true;
	}
	public static int issueBook(IssueBook ib) {
		String callno=ib.getCallno();
		boolean checkstatus=checkIssue(callno);
		if(checkstatus) {
			Session session=null;
			Transaction tr=null;
			session=HibernateUtil.getSession();
			try {
				tr=session.beginTransaction();
				session.save(ib);
				tr.commit();
				try {
					tr=session.beginTransaction();
					Book book=(Book)session.get(Book.class, callno);
					book.setIssued(getIssued(callno)+1);
					session.save(book);
					tr.commit();
				}
				catch(Exception e) {
					tr.rollback();
					System.out.println("Book updating error");
				}
			}
			catch(Exception e) {
				tr.rollback();
				System.out.println("issue book error");
			}
			return 1;
		}
		return 0;
	}
	
	public static List viewIssuedBook() {
		List list=null;
		Session session=null;
		Transaction tr=null;
		
		try {
			session=HibernateUtil.getSession();
			tr=session.beginTransaction();
			list=session.createQuery("from IssueBook order by issueddate").list();
			tr.commit();
		}
		catch(Exception e) {
			tr.rollback();
		}
		return list;
	}
	public static int returnBook(String callno,String studentid){
		int flag=1;
		Session session=null;
		Transaction tr=null;
		List list=null;
		session=HibernateUtil.getSession();
		try {
			tr=session.beginTransaction();
		//	System.out.println("Pahuncha");

			Query query=session.createQuery("from IssueBook where callno=:c and studentid=:s");
		//	System.out.println("Pahuncha");
			query.setParameter("c",callno);
			query.setParameter("s", studentid);
		//	System.out.println("Pahuncha");
			list=query.list();
		//	System.out.println("Pahuncha");
			Iterator itr=list.iterator();
			IssueBook b=(IssueBook)itr.next();
		//	System.out.println("Pahuncha");
			b.setReturnstatus("yes");
		//	System.out.println("Pahuncha");
			session.save(b);
		//	System.out.println("Pahuncha");
			tr.commit();
			try {
				tr=session.beginTransaction();
				System.out.println("Pahuncha");
				String q="from Book where callno=:c";
				System.out.println("Pahuncha");
				Query q1=session.createQuery(q);
				System.out.println("Pahuncha");
				q1.setParameter("c",callno);
				System.out.println("Pahuncha");
				List l=q1.list();
				System.out.println("Pahuncha");
				Iterator it=l.iterator();
				Book book=(Book)it.next();
				book.setIssued(getIssued(callno)-1);
				System.out.println("Hey:"+book.getIssued());
				session.save(book);
				tr.commit();
				flag=0;
			}
			catch(Exception e) {
				tr.rollback();
				System.out.println("Error in bookReturn");
			}
		}
		catch(Exception e) {
			tr.rollback();
			System.out.println("Error in isssue return ");
		}
		return flag;	
	}
}
