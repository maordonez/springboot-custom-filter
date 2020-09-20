package co.maordonez.filter.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.maordonez.filter.domain.Terminal;
import co.maordonez.filter.dto.PageDto;
import co.maordonez.filter.dto.TerminalCustomDto;
import co.maordonez.filter.dto.TerminalFilterDto;
import co.maordonez.filter.service.TerminalService;

@RestController
@RequestMapping("/terminales")
public class TerminalResource {

	@Autowired
	private TerminalService terminalService;
	
	@Autowired
	private ObjectMapper mapper;
	
	@GetMapping
	public PageDto<TerminalCustomDto> getTerminal(@RequestParam(name = "filter", required = false) String filter) {
		TerminalFilterDto dto = null;
		try {
			dto =  mapper.readValue(filter, TerminalFilterDto.class);
		} catch (Exception e) {
			dto = new TerminalFilterDto();
		}
		return terminalService.getTerminales(dto);
	}

}
