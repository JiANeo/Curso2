package sql_hibernate.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sql_hibernate.model.Automovel;


public class SchemaGeneration implements Serializable {

	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javawebPU");
        EntityManager em = emf.createEntityManager();

		List<Automovel> lista = em.createQuery("from Automovel", Automovel.class).getResultList();

		System.out.println(lista);

		em.close();
		emf.close();
	}

}
