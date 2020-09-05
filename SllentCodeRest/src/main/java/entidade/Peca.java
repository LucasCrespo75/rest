package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PECA")
public class Peca {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PECA")
	@SequenceGenerator(name = "S_PECA", sequenceName = "S_PECA", initialValue = 1, allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "FABRICANTE", nullable = false)
	private String fabricante;
	@Column(name = "VALOR", nullable = false)
	private double valor;
	
	@ManyToOne
	@JoinColumn(name = "ID_VEICULO", referencedColumnName = "PLACA", nullable = false)
	private Veiculo veiculo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
