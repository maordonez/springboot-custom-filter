package co.maordonez.filter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.maordonez.filter.dao.TerminalDao;
import co.maordonez.filter.domain.Terminal;
import co.maordonez.filter.dto.PageDto;
import co.maordonez.filter.dto.TerminalCustomDto;
import co.maordonez.filter.dto.TerminalFilterDto;
import co.maordonez.filter.service.TerminalService;

@Service
public class TerminalServiceImpl implements TerminalService {
	
	@Autowired
	private TerminalDao terminalDao;

	@Override
	public PageDto<TerminalCustomDto> getTerminales(TerminalFilterDto filter) {
		return terminalDao.queryFindByFilter(filter);
	}

}
