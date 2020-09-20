package co.maordonez.filter.dao;

import co.maordonez.filter.dto.PageDto;
import co.maordonez.filter.dto.TerminalCustomDto;
import co.maordonez.filter.dto.TerminalFilterDto;

public interface TerminalCustomDao {
	
	public PageDto<TerminalCustomDto> queryFindByFilter(TerminalFilterDto filter);
}
