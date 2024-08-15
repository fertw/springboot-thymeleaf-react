package ar.com.fcarmine.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class MetodoPago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany(mappedBy = "metodoPago", cascade = CascadeType.ALL)
	private Set<Gasto> gastos;

	public MetodoPago(String nombre) {
		super();
		this.nombre = nombre;
	}

	public MetodoPago() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(Set<Gasto> gastos) {
		this.gastos = gastos;
	}

	@Override
	public String toString() {
		return "MetodoPago [nombre=" + nombre + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    MetodoPago metodoPago = (MetodoPago) o;
	    return Objects.equals(id, metodoPago.id);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}

	
	

}
