package ar.com.fcarmine.model;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@OneToMany(mappedBy = "categoria")
    @JsonManagedReference // Esta anotación gestiona la serialización hacia adelante
    private Set<Gasto> gastos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(Set<Gasto> gastos) {
		this.gastos = gastos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Categoria categoria = (Categoria) o;
	    return Objects.equals(id, categoria.id);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}


}
