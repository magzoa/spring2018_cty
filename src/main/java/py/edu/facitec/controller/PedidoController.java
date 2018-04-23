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

import py.edu.facitec.dao.PedidoDAO;
import py.edu.facitec.model.Pedido;

//Construcción de una aplicación con la arquitectura REST				
@RestController   //Administra las peticiones via AJAX 

@Transactional


@RequestMapping(value="/pedidos")
public class PedidoController {
	
			@Autowired
			private	PedidoDAO pedidoDAO;
			
	
			
												//Recibe el objeto Json y lo convierte a 
												//objeto java mediante la libreria Jackson
		
			@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido){
			
			pedidoDAO.guardar(pedido);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
			
		}	
													//pedidos/2 seria el id del pedido
			@RequestMapping(method=RequestMethod.GET,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
			
										//Pasar los datos del parametro de la url a la variable
	public ResponseEntity<Pedido> buscar(@PathVariable Integer id){
		
		Pedido pedido=pedidoDAO.buscar(id);
		
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}		
			
		
			@RequestMapping(method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE,value="/{id}")
			public ResponseEntity<Pedido> eliminar(@PathVariable Integer id){
				
				
				Pedido pedido=pedidoDAO.buscar(id);
				
				if(pedido==null){
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				
				
				pedidoDAO.eliminar(pedido);
				
				
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
			
			
			
			
			
			
			
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Pedido>>  listaPedidos(){
			
			List<Pedido> pedidos=pedidoDAO.getLista();
			
			
			return new ResponseEntity<List<Pedido>>(pedidos,HttpStatus.OK);
		}	
	
	
	
	
	
	
	
	
	
			
			
			
			
			
			

}
