package br.com.caelum.aeris.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;

/**
 * Entidade que representa os trechos dos
 * voos.
 * 
 * @author Gilson Filho
 */
@Name("trecho")
@AutoCreate
@Entity
public class Trecho {
	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Localidade origem;
	
	@Enumerated(EnumType.STRING)
	private Localidade destino;
	
	@OneToMany(mappedBy="trecho", cascade=CascadeType.ALL)
	private List<Voo> voos = new ArrayList<Voo>();

	public void addVoo(Voo voo) {
		voo.setTrecho(this);
		this.voos.add(voo);
	}

	public Localidade getOrigem() {
		return origem;
	}

	public void setOrigem(Localidade origem) {
		this.origem = origem;
	}

	public Localidade getDestino() {
		return destino;
	}

	public void setDestino(Localidade destino) {
		this.destino = destino;
	}

	public List<Voo> getVoos() {
		return voos;
	}

	public void setVoos(List<Voo> voos) {
		this.voos = voos;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public String toString() {
		return String.format("{Trecho id:%d, origem:%s, destino:%s}", id, origem, destino);
	}
}
