package py.edu.facitec.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.dao.GerenteDAO;
import py.edu.facitec.model.Gerente;


//Indicamos que trabajaremos con la arquitectura REST
@RestController
@Transactional


		//Escribir en minusculas siempre
		//la url a responder
@RequestMapping("/gerente")

public class GerenteController {
	
	@Autowired
	private GerenteDAO gerenteDAO;
	
					//el metodo					//Definimos el formato de retorno
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	
		//Definimos el tipo de retorno
	public ResponseEntity<List<Gerente>>  getListaGerentes(){
		
						//Spring gestiona el inicio y cierre de la transacción
  List<Gerente> listaRetorno= 	gerenteDAO.getLista();	
		
  				//Retornamos con los datos ya cargados y el estado de la respuesta
  		return new ResponseEntity<List<Gerente>>(listaRetorno, HttpStatus.OK);
	}
	

@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
	
					//para cargar los datos que vienen en formato json al objeto gerente
public ResponseEntity<Gerente> guardarGerente(@RequestBody Gerente gerente){
		
		
		gerenteDAO.guardar(gerente);
		
				//Vuelve a convertir en formato json la respuesta
		return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
	}
	
								// { variable Ej 3 o 4 o 5 => id
							//@PathVariable URL AL ID
@RequestMapping(method=RequestMethod.GET,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Gerente> buscarGerente(@PathVariable Integer id){
	
	Gerente gerente=gerenteDAO.buscar(id);
	
	
	return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
	
	
}
	

@RequestMapping(method=RequestMethod.DELETE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Gerente> eliminarGerente(@PathVariable Integer id){
	
	Gerente gerente=gerenteDAO.buscar(id);
	
	if(gerente==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	gerenteDAO.eliminar(gerente);
	
	return new ResponseEntity<>(HttpStatus.OK);
	
	
}
	
	
	

}
