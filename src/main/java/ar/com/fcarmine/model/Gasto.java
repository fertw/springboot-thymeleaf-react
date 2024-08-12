package ar.com.fcarmine.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Gasto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String concepto;
	private double monto;
	private LocalDate fecha;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "metodo_pago_id")
	private MetodoPago metodoPago;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MetodoPago getMetodo() {
		return metodoPago;
	}

	public void setMetodo(MetodoPago metodo) {
		this.metodoPago = metodo;
	}
	
	@Override
	public String toString() {
		return "Gasto [id=" + id + ", concepto=" + concepto + ", monto=" + monto + ", fecha=" + fecha
				+ ", usuario=" + usuario + ", metodoPago=" + metodoPago + ", categoria=" + categoria + "]";
	}
	
	

}
