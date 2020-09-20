package co.maordonez.filter.service;

import co.maordonez.filter.domain.Terminal;
import co.maordonez.filter.dto.PageDto;
import co.maordonez.filter.dto.TerminalCustomDto;
import co.maordonez.filter.dto.TerminalFilterDto;

public interface TerminalService {

	public PageDto<TerminalCustomDto> getTerminales(TerminalFilterDto filter);
}
