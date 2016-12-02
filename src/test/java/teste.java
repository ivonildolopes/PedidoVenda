import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.pedidovenda.model.Categoria;


public class teste {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager em = emf.createEntityManager();
		
	
		Categoria c = em.find(Categoria.class, 1L);
		System.out.println("AQUIIIIIIIIIIIIIIIIIIIIII");
		System.out.println(c.getDescricao());
		
		
	}

}
