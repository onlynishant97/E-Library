package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import HibernateUtil.HibernateUtil;

public class LibrarianDao {
	public static int checkUser(String username,String password) {
		Session session=HibernateUtil.getSession();
		Transaction tr=session.getTransaction();
		String query="from Librarian where email=:e and password=:p";
		Query q=session.createQuery(query);
		q.setParameter("e",username);
		q.setParameter("p", password);
		try {
			tr=session.beginTransaction();
			List result=q.list();
			if(result.isEmpty())return 0;
			else return 1;
		}
		catch(Exception e) {
			tr.rollback();
		}
		return 0;
	}
}
