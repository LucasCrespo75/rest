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
 *  Lembrando de uma coisa, a implementação ela recebe no construtor o entityManager,
 *  a conexão com o banco de dados, deixando assim essa classe totalemnte independente 
 *
 */

public class EntradaDAOImpl implements EntradaDAO {

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia e 
	 * executar a ação de persistir, tudo dando certo realiza o commit no final
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
 * Metodo alterar, recebe o usuario, criar uma transição, inicia e executa a ação de merger
 */
	public void alterarUsuario(Usuario usuario) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(usuario);
		
		tx.commit();
		ent.close();

	}

/**
 * Pesquisar, pesquisar pela chave primaria que seria o cpf
 */
	public Usuario pesquisar(String cpf) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		Usuario usuario = ent.find(Usuario.class, cpf);
		
		return usuario;
		
	}	
	
}
