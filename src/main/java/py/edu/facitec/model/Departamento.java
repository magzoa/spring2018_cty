package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Departamento extends General {
private String descripcion;

//mappedBy para una relación bidireccional
//para que se conozcan ambas clases.
//En cualquiera de las relaciones se puede
//usar el mappedby en OneToOne
@OneToOne(mappedBy="departamento")
	private Gerente gerente;

@OneToMany(mappedBy="departamento")
private List<Usuario> usuarios;

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Gerente getGerente() {
	return gerente;
}

public void setGerente(Gerente gerente) {
	this.gerente = gerente;
}

public List<Usuario> getUsuarios() {
	return usuarios;
}

public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
}


	
}
