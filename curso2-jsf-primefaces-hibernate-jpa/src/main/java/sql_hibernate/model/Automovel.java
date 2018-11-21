package sql_hibernate.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Automovel")
public class Automovel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_automovel")
	private String nome;

	@Column(name = "marca_automovel")
	private String marca;

	@Column(name = "modelo_automovel")
	private String modelo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ano_carro")
	private Date anoCarro;

	@ManyToOne
	@JoinColumn(name = "dono_carro")
	private Pessoa pessoa;

	// getter e setters
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAnoCarro(Date anoCarro) {
		this.anoCarro = anoCarro;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	//hashcode e equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovel other = (Automovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	

}
