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

import py.edu.facitec.dao.DepartamentoDAO;
import py.edu.facitec.model.Departamento;

//Construcción de una aplicación con la arquitectura REST				
@RestController   //Administra las peticiones via AJAX 

@Transactional


@RequestMapping(value="/departamentos")
public class DepartamentoController {
	
			@Autowired
			private	DepartamentoDAO departamentoDAO;
			
	
			
												//Recibe el objeto Json y lo convierte a 
												//objeto java mediante la libreria Jackson
		
			@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Departamento> registrar(@RequestBody Departamento departamento){
			
			departamentoDAO.guardar(departamento);
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
			
		}	
													//departamentos/2 seria el id del departamento
			@RequestMapping(method=RequestMethod.GET,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
			
										//Pasar los datos del parametro de la url a la variable
	public ResponseEntity<Departamento> buscar(@PathVariable Integer id){
		
		Departamento departamento=departamentoDAO.buscar(id);
		
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}		
			
		
			@RequestMapping(method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE,value="/{id}")
			public ResponseEntity<Departamento> eliminar(@PathVariable Integer id){
				
				
				Departamento departamento=departamentoDAO.buscar(id);
				
				if(departamento==null){
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				
				
				departamentoDAO.eliminar(departamento);
				
				
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
			
			
			
			
			
			
			
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Departamento>>  listaDepartamentos(){
			
			List<Departamento> departamentos=departamentoDAO.getLista();
			
			
			return new ResponseEntity<List<Departamento>>(departamentos,HttpStatus.OK);
		}	
	
	
	
	
	
	
	
	
	
			
			
			
			
			
			

}
