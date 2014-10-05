package br.com.caelum.aeris.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Voo {
	@Id
	@GeneratedValue
	private Long id;
	
	private String codigo;
	
	@Temporal(TemporalType.DATE)
	private Date dataPartida = new Date();
	
	@Temporal(TemporalType.TIME)
	private Date horaPartida = new Date();
	
	@Temporal(TemporalType.DATE)
	private Date dataChegada = new Date();
	
	@Temporal(TemporalType.TIME)
	private Date horaChegada = new Date();
	
	@ManyToOne
	private Trecho trecho;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public Date getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(Date horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public Date getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Trecho getTrecho() {
		return trecho;
	}

	public void setTrecho(Trecho trecho) {
		this.trecho = trecho;
	}

	public Long getId() {
		return id;
	}
	
	public String toString() {
		return String.format("{Voo id=%d, codigo=%s, horaPartida=%tR, dataPartida=%tD, trecho=%s}",
				id, codigo, horaPartida, dataPartida, trecho);
	}
}
