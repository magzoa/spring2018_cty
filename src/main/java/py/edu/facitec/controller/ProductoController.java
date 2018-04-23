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

import py.edu.facitec.dao.ProductoDAO;
import py.edu.facitec.model.Producto;


//Indicamos que trabajaremos con la arquitectura REST
@RestController
@Transactional


		//Escribir en minusculas siempre
		//la url a responder
@RequestMapping("/producto")

public class ProductoController {
	
	@Autowired
	private ProductoDAO productoDAO;
	
					//el metodo					//Definimos el formato de retorno
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	
		//Definimos el tipo de retorno
	public ResponseEntity<List<Producto>>  getListaProductos(){
		
						//Spring gestiona el inicio y cierre de la transacción
  List<Producto> listaRetorno= 	productoDAO.getLista();	
		
  				//Retornamos con los datos ya cargados y el estado de la respuesta
  		return new ResponseEntity<List<Producto>>(listaRetorno, HttpStatus.OK);
	}
	

@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
	
					//para cargar los datos que vienen en formato json al objeto producto
public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
		
		
		productoDAO.guardar(producto);
		
				//Vuelve a convertir en formato json la respuesta
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
								// { variable Ej 3 o 4 o 5 => id
							//@PathVariable URL AL ID
@RequestMapping(method=RequestMethod.GET,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id){
	
	Producto producto=productoDAO.buscar(id);
	
	
	return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	
	
}
	

@RequestMapping(method=RequestMethod.DELETE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Producto> eliminarProducto(@PathVariable Integer id){
	
	Producto producto=productoDAO.buscar(id);
	
	if(producto==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	productoDAO.eliminar(producto);
	
	return new ResponseEntity<>(HttpStatus.OK);
	
	
}
	
	
	

}
