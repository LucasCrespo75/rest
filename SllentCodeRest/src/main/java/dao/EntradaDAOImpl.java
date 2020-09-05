package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Entrada;
import entidade.Usuario;
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

/**
 * Metodo alterar, recebe o usuario, criar uma transi��o, inicia e executa a a��o de merger
 */
	public void alterarEntrada(Entrada entrada) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		
		ent.merge(entrada);
		
		tx.commit();
		ent.close();

	}

/**
 * Pesquisar, pesquisar pela chave primaria que seria o cpf
 */
	public Entrada pesquisarEntrada(int id) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		Entrada entrada = ent.find(Entrada.class, id);
		
		return entrada;
		
	}


	

	
}	
	

