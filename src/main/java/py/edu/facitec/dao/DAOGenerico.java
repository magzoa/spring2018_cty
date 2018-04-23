package py.edu.facitec.dao;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;

import py.edu.facitec.model.Cliente;

//Creando una clase generica
//que podra recibir cualquier
//tipo de objeto
public abstract class DAOGenerico<T> {

//Declaración del atributo
//que representara una clase	
private Class<T> entityClass;


public DAOGenerico(Class<T> entityClass) {

	this.entityClass=entityClass;
}
//Método abstracto a definir
//en cada clase hija que herede de
//DAOGenerico
protected abstract EntityManager getEntityManager();

				//recibe un objeto
				//cualquiera
public void insertar(T entity) {
	
getEntityManager().persist(entity);	
	
}
public void actualizar(T entity) {
		//metodo para actualizar	
getEntityManager().merge(entity);	
}


public void eliminar(T entity) {
//Pregunta si esta sincronizado con la bd
//si lo esta elimina directamente 
//si no actualiza la la referencia de la entidad
	
	
	
getEntityManager().remove(getEntityManager().contains(entity)?
	entity
	:getEntityManager().merge(entity));	

}

//metodo para buscar un objeto por el id
public T buscar(Object id) {
	
return getEntityManager().find(entityClass, id);	
}



//METODO PARA GUARDAR
	public void guardar(T entity) {
		
Object id = 
getEntityManager().getEntityManagerFactory()
.getPersistenceUnitUtil().getIdentifier(entity);    	
		    	
		    	System.out.println("El id en guardar es: "+id);
		    	if(id!=null){
		    	if(buscar(id)==null){   	   	
		        	getEntityManager().persist(entity);
		    	}else{  	   	
		        	getEntityManager().merge(entity);
		    	}
		    	}else{
		    		getEntityManager().persist(entity);
		    	}
	}

	// METODO QUE RETORNA UNA LISTA DE UNA ENTIDAD
	public List<T> getLista() {
return getEntityManager().createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();

	}




	public static void main(String[] args) {
		Cliente cli=new Cliente();
		System.out.println(cli.getClass().getSimpleName());
	}
	
	
}
