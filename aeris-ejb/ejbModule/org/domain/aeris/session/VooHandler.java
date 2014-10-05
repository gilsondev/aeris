package org.domain.aeris.session;

import br.com.caelum.aeris.entity.Trecho;

public interface VooHandler {
	String manipulaVoos(Trecho trecho);
	Trecho getTrechoSelecionado();
	void destruicaoObrigatoria();
	void iniciaVoos();
	String salvarVoo();
}
