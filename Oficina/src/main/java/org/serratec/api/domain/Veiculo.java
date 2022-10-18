package org.serratec.api.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Identificador do veículo")
	private Long id;

	@NotBlank(message = "Preencha a placa")
	@Size(max = 7)
	@Column(nullable = false, length = 7)
	@ApiModelProperty(value = "Placa do veículo")
	private String placa;

	@NotBlank(message = "Preencha a marca")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	@ApiModelProperty(value = "Marca do veículo")
	private String marca;

	@NotBlank(message = "Preencha o modelo")
	@Size(max = 40)
	@Column(nullable = false, length = 40)
	@ApiModelProperty(value = "Modelo do veículo")
	private String modelo;

	@Embedded
	private Caracteristica caracteristica;
	
  //@OneToOne(cascade = CascadeType.ALL) // Qualquer alteração no 'pai' reflete no filho 
  //@OneToOne(cascade = CascadeType.REMOVE) // Apagar o veículo também apaga todas as manutenções feitas nele
  //@OneToOne(cascade = CascadeType.PERSIST) // Insert
  //@OneToOne(cascade = CascadeType.MERGE) // Insert para os filhos e Updates nos já existentes
  //@OneToOne(cascade = CascadeType.SAVE_UPDATE) // (somente = Insert para os filhos e Updates nos já existentes)
  //@OneToOne(cascade = CascadeType.REPLICATE) // Banco de dados replicados
	
  //@OneToOne(fetch= FetchType.LAZY) // Retorna todos os dados de uma lista e depois faz um get para cada item selecionado (Performance)
	
	@OneToOne(fetch= FetchType.EAGER) // Retorna toda a informação solicitada com um JOIN! 
	@JoinColumn(name = "id_proprietario") //Qual a coluna responsável por fazer a ligação entre as duas tabelas
	private Proprietario proprietario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	
}
