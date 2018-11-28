package sql_hibernate.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sql_hibernate.model.Automovel;


public class SchemaGeneration implements Serializable {


	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		System.out.println("chega ate aqui a execução, sai na consola");
		//try {
			
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("javawebPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
		// Vou criar um automovel
		Automovel automovel = new Automovel();
		automovel.setNome("fiat");
		automovel.setMarca("punto");
		automovel.setModelo("sx");
		automovel.setAnoCarro(new Date());
		
		Automoveis automoveis = new Automoveis(em);
        // guardar/salvar o automovel inserido
		automoveis.guardar(automovel);

		// faço o commit das transaçoes
		em.getTransaction().commit();
		
		List<Automovel> lista = em.createQuery("from Automovel", Automovel.class).getResultList();

		System.out.println(lista);

		em.close();
		emf.close();
		
//		} catch (Exception e) {
//			System.out.println(e.toString());
//			e.printStackTrace();
//		}
	}

}
