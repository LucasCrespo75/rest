package dao;

import entidade.Usuario;

/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO é uma interface, onde compartilha a chamada dos metodos, mas não os implementam.
 */

public interface UsuarioDAO {
	
	public void inserirUsuario(Usuario usuario);
	
	public Usuario pesquisar(String cpf);

	public void alterarUsuario(Usuario usuario);

}
