package br.com.caelum.aeris.logic;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import br.com.caelum.aeris.entity.Localidade;

@Name("localidadesHandler")
public class LocalidadesHandler {

	@Logger
	private Log logger;
	
	/**
	 * MŽtodo que cria um mapa das localidades do enum {@link Localidade}
	 * para alimentar o campo "Localidade"
	 */
	@Factory(value="localidades", scope=ScopeType.APPLICATION)
	public Localidade[] initLocalidades() {
		logger.info("Iniciando localidades");
		return Localidade.values();
	}
}
