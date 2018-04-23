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

import py.edu.facitec.dao.UsuarioDAO;
import py.edu.facitec.model.Usuario;

//Construcción de una aplicación con la arquitectura REST				
@RestController   //Administra las peticiones via AJAX 

@Transactional


@RequestMapping(value="/usuarios")
public class UsuarioController {
	
			@Autowired
			private	UsuarioDAO usuarioDAO;
			
	
			
												//Recibe el objeto Json y lo convierte a 
												//objeto java mediante la libreria Jackson
		
			@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
			
			usuarioDAO.guardar(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
			
		}	
													//usuarios/2 seria el id del usuario
			@RequestMapping(method=RequestMethod.GET,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
			
										//Pasar los datos del parametro de la url a la variable
	public ResponseEntity<Usuario> buscar(@PathVariable Integer id){
		
		Usuario usuario=usuarioDAO.buscar(id);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}		
			
		
			@RequestMapping(method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE,value="/{id}")
			public ResponseEntity<Usuario> eliminar(@PathVariable Integer id){
				
				
				Usuario usuario=usuarioDAO.buscar(id);
				
				if(usuario==null){
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				
				
				usuarioDAO.eliminar(usuario);
				
				
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
			
			
			
			
			
			
			
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Usuario>>  listaUsuarios(){
			
			List<Usuario> usuarios=usuarioDAO.getLista();
			
			
			return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
		}	
	
	
	
	
	
	
	
	
	
			
			
			
			
			
			

}
