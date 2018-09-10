package br.com.avaliacaoJava.error;

import java.util.Date;

public class ErrorRequest {
	  
	  private Date data;
	  private String mensagem;
	  private String detalhe;

	  public ErrorRequest(Date data, String mensagem, String detalhe) {
	    super();
	    this.data = data;
	    this.mensagem = mensagem;
	    this.detalhe = detalhe;
	  }

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	  
	  
}