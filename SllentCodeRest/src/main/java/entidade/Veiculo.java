package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {
	
	@Id
	@Column(name = "PLACA", nullable = false)
	private String placa;
	@Column(name = "MODELO", nullable = false)
	private String modelo;
	@Column(name = "FABRICANTE", nullable = false)
	private String fabricante;
	@Column(name = "ANO", nullable = false)
	private int ano;
	@Column(name = "COR", nullable = false)
	private String cor;

	@OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
	private List<Peca> pecas;
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
}
