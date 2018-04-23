package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Cliente;
import py.edu.facitec.model.Producto;

@Repository
//pasamos el tipo de objeto
public class ClienteDAO extends DAOGenerico<Cliente>{

@PersistenceContext		
	private EntityManager em;
	
	public ClienteDAO() {
		//Pasamos el tipo de clase
		super(Cliente.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		
		return this.em;
	}

	
	
	
}
