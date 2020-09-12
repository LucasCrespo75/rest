package dao;

import java.util.Date;
import java.util.List;

import entidade.Entrada;

/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO � uma interface, onde compartilha a chamada dos metodos, mas n�o os implementam.
 */

public interface EntradaDAO {
	
	public void inserirEntrada(Entrada entrada);
	public List<Entrada> pesquisarEntrada(Entrada entrada,
			Date dataInicio, Date dataFim);

}
