package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import HibernateUtil.HibernateUtil;
import ModelClasses.Librarian;

public class AdminDao {
	public static int addLibrarian(Librarian lib) {
		Session session=HibernateUtil.getSession();
		Transaction tr=session.getTransaction();
		int flag=1;
		try {
			tr=session.beginTransaction();
			session.save(lib);
			tr.commit();
		}
		catch(Exception e) {
			tr.rollback();
			flag=0;
			System.out.println("Object not saved");
		}
		if(flag==1)return 1;
		else return 0;
	}
	public static List viewLibrarian() {
		Session session=null;
		Transaction tr=null;
		session=HibernateUtil.getSession();
		List lib=null;
		try {
			tr=session.beginTransaction();
			lib=session.createQuery("from Librarian").list();
			tr.commit();
		}
		catch(Exception e) {
			tr.rollback();
		}
		return lib;
	}
}
