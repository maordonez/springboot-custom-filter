package co.maordonez.filter.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MarcaTerminal")
public class MarcaTerminal implements Serializable {

	public interface Attributes {

		String ID = "id";
		String DESCRIPCION = "descripcion";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descripcion;

	/**
	 * 
	 */
	private static final long serialVersionUID = -5300890569669590438L;

}