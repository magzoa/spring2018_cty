package py.edu.facitec.conf;

import javax.servlet.Filter;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//Servlet principal de SpringMVC
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	//Clases a cargar en el inicio de la aplicación
	@Override
	protected Class<?>[] getRootConfigClasses() {
					//Vector de clases
		return new Class[] {AppWebConfiguration.class,JPAConfiguration.class};
	}
//Clases a cargar luego del inicio
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
	// inicio del Servlet con la raiz del proyecto
		return new String[] {"/"};
	}

	// Tener habilitado en el EntityManager durante las requisiciones.
	//paquete javax.servlet.Filter 
	 	 	@Override 
	 	 	protected Filter[] getServletFilters() {  	
	 	 		return new Filter[]{ 
	 	 	new OpenEntityManagerInViewFilter()}; 
	 	 	} 

	
	
}
