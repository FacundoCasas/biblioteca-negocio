package biblioteca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AutorDAO {
	private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ejsHibernate");
		
		public void agregarAutor(Autor autor) throws Exception{
		EntityManager em = managerFactory.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		em.persist(autor);
		tran.commit();
		em.close();
	}

}
