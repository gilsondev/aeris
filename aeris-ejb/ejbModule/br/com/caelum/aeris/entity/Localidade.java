package br.com.caelum.aeris.entity;

public enum Localidade {
	SAO_PAULO("S‹o Paulo"),
	RIO_DE_JANEIRO("Rio de Janeiro"),
	NOVA_IORQUE("Nova Iorque"),
	PARIS("Paris"),
	LONDRES("Londres"),
	MOSCOU("Moscou");
	
	private final String name;
	
	private Localidade(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
