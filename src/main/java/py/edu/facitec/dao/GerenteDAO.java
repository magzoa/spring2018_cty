package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Gerente;
import py.edu.facitec.model.Producto;

@Repository
//pasamos el tipo de objeto
public class GerenteDAO extends DAOGenerico<Gerente>{

@PersistenceContext		
	private EntityManager em;
	
	public GerenteDAO() {
		//Pasamos el tipo de clase
		super(Gerente.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		
		return this.em;
	}

	
	
	
}
