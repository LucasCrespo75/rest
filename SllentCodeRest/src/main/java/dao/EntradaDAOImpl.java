package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Entrada;
import util.JpaUtil;

/**
 * 
 * @author Cleiton
 *
 *	Essa classe implementa a interface, todos os metodos mostrados na interface.
 *  Lembrando de uma coisa, a implementa��o ela recebe no construtor o entityManager,
 *  a conex�o com o banco de dados, deixando assim essa classe totalemnte independente 
 *
 */

public class EntradaDAOImpl implements EntradaDAO {

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transi��o, inicia e 
	 * executar a a��o de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserirEntrada(Entrada entrada) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(entrada.getVeiculo());
		
		ent.persist(entrada);
		
		tx.commit();
		ent.close();

	}

	@Override
	public List<Entrada> pesquisarEntrada(Entrada entrada, Date data_Inicio, Date data_Fim) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		
		Query query = ent.createQuery("from Entrada p where 1=1 " + montarWherePesquisa(entrada , data_Inicio, data_Fim));
		List<Entrada> perguntas = query.getResultList();
		return perguntas;
	}

	private String montarWherePesquisa(Entrada entrada, Date data_Inicio, Date data_Fim) {
	
	

	//public String montarWherePesquisa(String nome_cliente, String tel_cliente, Date data_Inicio, Date data_Fim,
	//		String placa) {
		
		String where = "";
		// Fazer codigo aqui	
		SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
		
		if(entrada.getNome_cliente() != null && !entrada.getNome_cliente().isEmpty()) {
			where += " and upper(e.nome_cliente) like upper('%" + entrada.getNome_cliente() + "%')";
		}
		
		if(entrada.getTel_cliente() != null && !entrada.getTel_cliente().isEmpty()) {
			where += " and upper(t.tel_cliente) like upper('%" + entrada.getTel_cliente() + "%')";
		}
		if(data_Inicio != null && data_Fim != null) {
			where += " and e.data_Entrada BETWEEN TO_DATE('" + dataSimples.format(data_Inicio) + "', 'DD/MM/YYYY') and "
					+ " TO_DATE('" + dataSimples.format(data_Fim) + "', 'DD/MM/YYYY')";
		}
		if(entrada.getVeiculo().getPlaca() != null && !entrada.getVeiculo().getPlaca().isEmpty()) {
			where += " and upper(e.Placa) like upper('%" + entrada.getVeiculo().getPlaca() + "%')";
		}
		



		
		
		
		
	//	if
		
		//telCliente
		
		
	//	if
		//dataInicio
		
		
//		if
		//dataFim
		
		
	//	if
		//placaVeiculo
		
		
		return where;
	}
	
	
}
