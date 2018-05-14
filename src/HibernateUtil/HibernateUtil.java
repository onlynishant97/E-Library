package HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	static {
		sessionFactory=new Configuration().configure("/configurations/hibernate.cfg.xml").buildSessionFactory();
	}
	public static Session getSession(){
		session=sessionFactory.openSession();
		return session;
	}
	public static void closeSession() {
		session.close();
	}
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
	
}
