package co.maordonez.filter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import co.maordonez.filter.dao.TerminalCustomDao;
import co.maordonez.filter.domain.EstadoActualizacion;
import co.maordonez.filter.domain.MarcaTerminal;
import co.maordonez.filter.domain.Terminal;
import co.maordonez.filter.dto.PageDto;
import co.maordonez.filter.dto.TerminalCustomDto;
import co.maordonez.filter.dto.TerminalFilterDto;

public class TerminalCustomDaoImpl implements TerminalCustomDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	@Override
	public PageDto<TerminalCustomDto> queryFindByFilter(TerminalFilterDto filter) {

		PageDto<TerminalCustomDto> page = new PageDto<>();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		Root<Terminal> countRoot = countQuery.from(Terminal.class);
		countQuery.where(applyWhere(criteriaBuilder, countRoot, filter).toArray(new Predicate[]{}));
		countQuery.select(criteriaBuilder.count(countRoot));	
		Long count = entityManager.createQuery(countQuery).getSingleResult();
		page.setTotalRows(count);


		CriteriaQuery<TerminalCustomDto> criteriaQuery = criteriaBuilder.createQuery(TerminalCustomDto.class);
		Root<Terminal> terminalRoot = criteriaQuery.from(Terminal.class);
		Join<Terminal, MarcaTerminal> marcaTerminal = terminalRoot.join(Terminal.Attributes.MARCA_TERMINAL);
		criteriaQuery.where(applyWhere(criteriaBuilder, terminalRoot, filter).toArray(new Predicate[]{}));
		
		criteriaQuery.select(
				criteriaBuilder.construct(TerminalCustomDto.class, 
						terminalRoot.get(Terminal.Attributes.ID),
						terminalRoot.get(Terminal.Attributes.SERIAL),
						terminalRoot.get(Terminal.Attributes.APLICACIONES_INSTALADAS),
						terminalRoot.get(Terminal.Attributes.BLOCKING_MODE),
						terminalRoot.get(Terminal.Attributes.FLAG_INICIALIZACION),
						terminalRoot.get(Terminal.Attributes.TLS),
						marcaTerminal.get(MarcaTerminal.Attributes.DESCRIPCION)
						));
		

		TypedQuery<TerminalCustomDto> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(0);
		typedQuery.setMaxResults(20);
		
		page.setRows(typedQuery.getResultList());
		page.setPageCurrent(0);
		page.setPageSize(page.getRows().size());
		page.setTotalPages( (int) (page.getTotalRows() > 20 ?(int) (page.getTotalRows() / 10): 1));

		return page;
	}

	private List<Predicate> applyWhere(CriteriaBuilder criteria, Root<Terminal> terminalRoot, TerminalFilterDto filter) {

		List<Predicate> predicates = new ArrayList<>();

		if (filter.getSerial() != null) {
			predicates.add(criteria.equal(terminalRoot.get(Terminal.Attributes.SERIAL), filter.getSerial()));
		}

		if (filter.getInicializacion() != null) {
			predicates.add(criteria.equal(terminalRoot.get(Terminal.Attributes.FLAG_INICIALIZACION),
					filter.getInicializacion()));
		}

		if (filter.getTls() != null) {
			predicates.add(criteria.equal(terminalRoot.get(Terminal.Attributes.TLS), filter.getTls()));
		}
		
		return predicates;
	}

}
