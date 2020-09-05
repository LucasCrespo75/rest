package dao;

import entidade.Entrada;

/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO � uma interface, onde compartilha a chamada dos metodos, mas n�o os implementam.
 */

public interface EntradaDAO {
	
	public void inserirEntrada(Entrada entrada);

	public void alterarEntrada(Entrada entrada);
	
	public Entrada pesquisarEntrada(int id);


}
