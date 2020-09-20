package co.maordonez.filter.dto;

import lombok.Data;

@Data
public class TerminalFilterDto {
	
	private String serial;
	private Boolean inicializacion;
	private Boolean tls;

}
