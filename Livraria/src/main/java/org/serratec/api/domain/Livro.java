package org.serratec.api.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Identificador do livro")
	private long id;
	
	@NotBlank(message = "Preencha o titulo")
	@Size(max = 40)
	@Column(nullable = false, length = 40, name = "titulo")
	private String titulo;
	
	@NotBlank(message = "Preencha o ISNB")
	@Size(max = 20)
	@Column(nullable = false, length = 20, name = "isbn")
	private String isnb;
	
	@NotBlank(message = "Preencha a data de publicação")
	@Size(max = 40)
	@Column(nullable = false, name = "data_publicacao")
	@Past(message = "Essa data não é coerente")
	private LocalDate dataPublicacao;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name = "livro_autor",
			joinColumns = @JoinColumn(name = "id_livro"),
			inverseJoinColumns = @JoinColumn(name = "id_autor"))
	private List<Autor> autores;
	
	public Livro() {
		super();
	}

	public Livro(long id, String titulo, String isnb, LocalDate dataPublicacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isnb = isnb;
		this.dataPublicacao = dataPublicacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsnb() {
		return isnb;
	}

	public void setIsnb(String isnb) {
		this.isnb = isnb;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return id == other.id;
	}
	
	
}
