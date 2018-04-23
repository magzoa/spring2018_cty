package py.edu.facitec.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

	//Al extender de General
//Ya tenemos la clave primaria dentro de ItemPedido

@Entity
public class ItemPedido extends General {

	private int cantidadProducto;
	private BigDecimal subTotal;
	
	//Relación de Muchos para uno
	@ManyToOne
	private Producto producto;
	
	@ManyToOne
	private Pedido pedido;

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
