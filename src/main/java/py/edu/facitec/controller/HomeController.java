package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
		//Url escrita en el navegador
	//que respondera este metodo
	@RequestMapping("/")
	public String index() {
		
	System.out.println("Cargando página de inicio");
				//carpeta y pagina a responder
		return "view/templates/index";
	}
	
	

}
