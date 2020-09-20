package co.maordonez.filter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TerminalCustomDto {
	
	private Long id;
	private String serial;
	private String aplicacionesInstaladas;
	private Integer blockingMode;
	private Boolean flagInicializacion;
	private Boolean tls;
	private String descripcion;
	
	public TerminalCustomDto(Long id, String serial, String aplicacionesInstaladas, 
			Integer blockingMode, Boolean flagInicializacion, Boolean tls, String descripcion) {
		
		this.id = id;
		this.serial = serial;
		this.aplicacionesInstaladas = aplicacionesInstaladas;
		this.blockingMode = blockingMode;
		this.flagInicializacion = flagInicializacion;
		this.tls = tls;
		this.descripcion = descripcion;
		
	}
	
	public TerminalCustomDto() {}
	
}
