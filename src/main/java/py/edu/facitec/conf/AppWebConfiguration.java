package py.edu.facitec.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import py.edu.facitec.controller.HomeController;
import py.edu.facitec.dao.ClienteDAO;

//Habilitar la arquitectura MVC de Spring
@EnableWebMvc

//Buscar los componentes de spring en estos paquetes

@ComponentScan(basePackageClasses={HomeController.class,ClienteDAO.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter{

	
//Para que Spring reconozca como configuración
	
	@Bean
	public InternalResourceViewResolver internal() {
	
InternalResourceViewResolver resolver=
new InternalResourceViewResolver();
//prefijo es la carpeta donde estara las paginas
resolver.setPrefix("/static/");

//sufijo es la terminación del tipo de página
resolver.setSuffix(".html");

	return resolver;	
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean  	
	public FormattingConversionService mvcConversionService() 
	{ 
	 	DefaultFormattingConversionService conversionService =  	new DefaultFormattingConversionService(true);
	 	DateFormatterRegistrar registrar = new DateFormatterRegistrar(); 
	 	registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));  
	 	registrar.registerFormatters(conversionService); 
	 	return conversionService; 
	 	} 
	
}
