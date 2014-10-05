package org.domain.aeris.session;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.log.Log;

import br.com.caelum.aeris.entity.Trecho;

@Name("trechoHandler")
@Scope(ScopeType.EVENT)
public class TrechoHandler {
	@Logger
	private Log log;
	
	@In
	private Trecho trecho;
	
	@In
	private EntityManager entityManager;
	
	@DataModel
	private List<Trecho> trechos;
	
	@DataModelSelection
	private Trecho trechoSelecionado;
	
	public void salvar() {
		// Salvando o trecho
		log.info("Salvando #0: ", trecho);
		entityManager.merge(this.trecho);
		this.trecho = new Trecho();
	}
	
	public void editar() {
		this.trecho = trechoSelecionado;
	}
	
	public String remover() {
		this.entityManager.remove(trechoSelecionado);
		return "/paginas/trechos.xhtml";
	}

	@SuppressWarnings("unchecked")
	@Factory
	public void getTrechos() {
		log.info("Buscando trechos do banco de dados");
		this.trechos = this.entityManager.createQuery("from Trecho").getResultList();
	}
	
	public Trecho getTrecho() {
		return trecho;
	}

	public void setTrecho(Trecho trecho) {
		this.trecho = trecho;
	}
}
