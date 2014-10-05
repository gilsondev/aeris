package org.domain.aeris.session;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.log.Log;

import br.com.caelum.aeris.entity.Trecho;
import br.com.caelum.aeris.entity.Voo;


/**
 * Session Bean gerenciado pelo Seam, responsável por
 * tratar os eventos da página de cadastro de voos, como também
 * de capturar os valores dos componentes.
 * 
 * @author Gilson Filho
 */
@Stateful
@Local(VooHandler.class)
@Name("vooHandler")
@Scope(ScopeType.CONVERSATION)
public class VooHandlerBean implements VooHandler {

	@Logger
	private Log log;
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	/*
	 * Usando required=False porque existem métodos que não vão
	 * trabalhar com ele, por exemplo, o método manipulaVoos. Se
	 * não colocar esse parâmetro como false, gera um IllegalArgumentException
	 */
	
	@In(required=false)
	@Out(required=false)
	private Voo voo;
	
	// Armazena o trecho selecionado no cadastro de trechos
	private Trecho trechoSelecionado;
	
	// Atributo que contem a lista de voos e que é
	// encapsulado pelo DataModel
	@DataModel
	private List<Voo> voos;
	
	// Método que retorna a lista de voos, e que
	// é associado a uma variavel voos que está no
	// contexto.
	@Factory("voos")
	public void iniciaVoos() {
		this.voos = this.trechoSelecionado.getVoos();
	}
	
	// Transfere o trecho selecionado para o cadastro.
	// Aqui também com a anotação, inicia a conversação.
	@Begin
	public String manipulaVoos(Trecho trecho) {
		this.trechoSelecionado = this.entityManager.merge(trecho);
		log.info("Trecho selecionado: #0", this.trechoSelecionado);
		return "/paginas/voos.xhtml";
	}
	
	// Salva o voo e redireciona para a lista novamente.
	public String salvarVoo() {
		this.trechoSelecionado.addVoo(this.voo);
		log.info("Salvando voo #0", this.voo);
		this.voo = new Voo();
		return "/paginas/voos.xhtml";
	}
	
	public Trecho getTrechoSelecionado() {
		return this.trechoSelecionado;
	}

	// Todo session bean precisa esse método com essas anotações
	// para ser invocado na sua destruição.
	@Destroy
	@Remove
	public void destruicaoObrigatoria() {
		log.info("Chamando metodo de destruicao obrigatoria");
	}
}
