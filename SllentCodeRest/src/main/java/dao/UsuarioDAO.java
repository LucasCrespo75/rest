package dao;

import entidade.Usuario;

/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO � uma interface, onde compartilha a chamada dos metodos, mas n�o os implementam.
 */

public interface UsuarioDAO {
	
	public void inserirUsuario(Usuario usuario);
	
	public Usuario pesquisar(String cpf);

	public void alterarUsuario(Usuario usuario);

}
