package sql_hibernate.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sql_hibernate.model.Automovel;

public class CamadaPersistencia implements Serializable {

	public static void main(String[] args) {
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

		// verificar se a inserção funcionou
		List<Automovel> lista = automoveis.pesquisar("");
		System.out.println(lista);

		em.close();
		emf.close();

	}

}
