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

import py.edu.facitec.dao.ItemPedidoDAO;
import py.edu.facitec.model.ItemPedido;

//Construcción de una aplicación con la arquitectura REST				
@RestController   //Administra las peticiones via AJAX 

@Transactional


@RequestMapping(value="/itemPedidos")
public class ItemPedidoController {
	
			@Autowired
			private	ItemPedidoDAO itemPedidoDAO;
			
	
			
												//Recibe el objeto Json y lo convierte a 
												//objeto java mediante la libreria Jackson
		
			@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<ItemPedido> registrar(@RequestBody ItemPedido itemPedido){
			
			itemPedidoDAO.guardar(itemPedido);
		return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
			
		}	
													//itemPedidos/2 seria el id del itemPedido
			@RequestMapping(method=RequestMethod.GET,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
			
										//Pasar los datos del parametro de la url a la variable
	public ResponseEntity<ItemPedido> buscar(@PathVariable Integer id){
		
		ItemPedido itemPedido=itemPedidoDAO.buscar(id);
		
		return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
	}		
			
		
			@RequestMapping(method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE,value="/{id}")
			public ResponseEntity<ItemPedido> eliminar(@PathVariable Integer id){
				
				
				ItemPedido itemPedido=itemPedidoDAO.buscar(id);
				
				if(itemPedido==null){
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				
				
				itemPedidoDAO.eliminar(itemPedido);
				
				
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			
			
			
			
			
			
			
			
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ItemPedido>>  listaItemPedidos(){
			
			List<ItemPedido> itemPedidos=itemPedidoDAO.getLista();
			
			
			return new ResponseEntity<List<ItemPedido>>(itemPedidos,HttpStatus.OK);
		}	
	
	
	
	
	
	
	
	
	
			
			
			
			
			
			

}
