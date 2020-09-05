package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.RetornoServico;
import entidade.Usuario;

@Path("/usuario")
public class UsuarioServico {

	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Servi�o de usuario ativo";
	}
	
	@Path("/cadastrarUsuario")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoServico cadastrarUsuario(Usuario usuario) {
		RetornoServico retorno = new RetornoServico();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Teste do teste");
		
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		usuarioDAO.inserirUsuario(usuario);
		
		return retorno;
	}
	
	@Path("/pesquisarUsuario")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoServico pesquisarUsuario(@QueryParam("cpf") String cpf) {
		RetornoServico retorno = new RetornoServico();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Teste do teste");
		
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		retorno.setUsuarioRetorno(usuarioDAO.pesquisar(cpf));
		
		return retorno;
	}
}
