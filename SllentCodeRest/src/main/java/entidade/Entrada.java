package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ENTRADA")
public class Entrada {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ENTRADA")
	@SequenceGenerator(name = "S_ENTRADA", sequenceName = "S_ENTRADA", initialValue = 1, allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private int id;
	
	@Column(name = "NOME_CLIENTE", nullable = false)
	private String nome_cliente;
	@Column(name = "TEL_CLIENTE", nullable = false)
	private String tel_cliente;
	@Column(name = "DATA", nullable = false)
	private Date data;
	
	@OneToOne
	@JoinColumn(name = "ID_VEICULO", referencedColumnName = "PLACA", nullable = false)
	private Veiculo veiculo;
	
	@OneToOne
	@JoinColumn(name = "ID_USUARIO", referencedColumnName = "CPF", nullable = false)
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getTel_cliente() {
		return tel_cliente;
	}

	public void setTel_cliente(String tel_cliente) {
		this.tel_cliente = tel_cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
