package py.edu.facitec.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.edu.facitec.dao.ClienteDAO;
import py.edu.facitec.model.Cliente;
@Transactional 
@Controller 	
public class ClienteController { 
 //Injección de depencias.
//Crea un unico objeto accesible para 
//toda la aplicación	
@Autowired 
 	private ClienteDAO clienteDAO; 
 	 
 	@RequestMapping("/clientes")  
 	public String save(Cliente cliente){ 
 	 
 	System.out.println("Registrando el cliente: "+cliente); 
 	 	clienteDAO.guardar(cliente);
 	 	 
 	 	return "/clientes/ok"; 
 	} 	 
 
} 
