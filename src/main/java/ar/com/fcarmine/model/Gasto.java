package ar.com.fcarmine.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private String descripcion;
	private double monto;
	private LocalDate fecha;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonManagedReference
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "metodo_pago_id")
	private MetodoPago metodoPago;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonBackReference // Esta anotación evita la referencia cíclica
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// Getter y Setter para 'descripcion'
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	@Override
	public String toString() {
		return "Gasto [id=" + id + ", descripcion=" + descripcion + ", monto=" + monto + ", fecha=" + fecha
				+ ", usuario=" + usuario + ", metodoPago=" + metodoPago + ", categoria=" + categoria + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Gasto gasto = (Gasto) o;
		return Objects.equals(id, gasto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
