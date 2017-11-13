package commons;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbUtils {
	
	private static EntityManagerFactory emf;
	
	private DbUtils() {}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf == null)
		{
			emf =  Persistence.createEntityManagerFactory("persistenceUnit");
			return emf;
		} else {
			return emf;
		}
	
	}

}
