package br.com.avaliacaoJava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String caminho;
    private String nomecampo;
    private Object valorCampo;

    public NotFoundException( String caminho, String nomeCampo, Object valorCampo) {
        super(String.format("%s não encontrado %s : '%s'", caminho, nomeCampo, valorCampo));
        this.caminho = caminho;
        this.nomecampo = nomeCampo;
        this.valorCampo = valorCampo;
    }

	
	public String getCaminho() {
		return caminho;
	}


	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}


	public String getNomecampo() {
		return nomecampo;
	}

	public void setNomecampo(String nomecampo) {
		this.nomecampo = nomecampo;
	}

	public Object getValorCampo() {
		return valorCampo;
	}

	public void setValorCampo(Object valorCampo) {
		this.valorCampo = valorCampo;
	}

    
    
	
	
	
}
