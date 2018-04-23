package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Producto;

@Repository
//pasamos el tipo de objeto
public class ProductoDAO extends DAOGenerico<Producto>{

@PersistenceContext		
	private EntityManager em;
	
	public ProductoDAO() {
		//Pasamos el tipo de clase
		super(Producto.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		
		return this.em;
	}

	
	
	
}
