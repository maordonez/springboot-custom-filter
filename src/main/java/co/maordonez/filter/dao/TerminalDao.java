package co.maordonez.filter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.maordonez.filter.domain.Terminal;

public interface TerminalDao  extends JpaRepository<Terminal, Long>, TerminalCustomDao {

}
