package br.com.avaliacaoJava.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="endereco")
@ApiModel(description = "Classe Endereco.")
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id Endereco.", example = "1", required = true, position = 0)
	private Long id;
	
	@Column
	@NotNull
	@ApiModelProperty(notes = "Rua do endereço.", example = "Rua teste", required = true, position = 1)
	private String rua;
	
	@Column
	@NotNull
	@ApiModelProperty(notes = "Número do endereço.", example = "10", required = true, position = 2)
	private Integer numero;
	
	@Column
	@ApiModelProperty(notes = "Bairro do endereço.", example = "bairro teste", required = false, position = 3)
	private String bairro;
	
	@Column
	@ApiModelProperty(notes = "Complemento do endereço.", example = "apt. 4", required = false, position = 4)
	private String complemento;
	
	@Column
	@NotNull
	@Size(min=8,max=8, message="CEP deve conter 8 caracteres")
	@ApiModelProperty(notes = "CEP do endereço sem '-'.", example = "11111111", required = true, position = 5)
	private String cep;
	
	@Column
	@NotNull
	@ApiModelProperty(notes = "Cidade do endereço.", example = "São Paulo", required = true, position = 6)
	private String cidade;
	
	@Column
	@NotNull
	@ApiModelProperty(notes = "Estado do endereço.", example = "São Paulo", required = true, position = 7)
	private String estado;

	public Endereco() {

	}
	
	public Endereco(String rua, int numero, String bairro, String complemento, String cep, String cidade,
			String estado) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
