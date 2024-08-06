package ar.com.fcarmine.dto;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoDTO {

    private Long id;
    private BigDecimal monto;
    private LocalDate fecha;
    private Long usuarioId;
    private Long categoriaId;
    private Long metodoPagoId;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public Long getMetodoPagoId() {
		return metodoPagoId;
	}
	public void setMetodoPagoId(Long metodoPagoId) {
		this.metodoPagoId = metodoPagoId;
	}
    
   

    // Getters y setters
    
}
