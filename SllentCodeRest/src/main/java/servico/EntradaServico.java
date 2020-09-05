package servico;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.EntradaDAO;
import dao.EntradaDAOImpl;
import entidade.Entrada;
import entidade.Peca;
import entidade.RetornoServico;

@Path("/entrada")
public class EntradaServico {

	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Servi�o de Entrada ativo";
	}
	
	@Path("/cadastrarEntrada")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoServico cadastrarEntrada(Entrada entrada) {
		RetornoServico retorno = new RetornoServico();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Cadastrado com sucesso!");
		
		for (Peca peca : entrada.getVeiculo().getPecas()) {
			peca.setVeiculo(entrada.getVeiculo());
		}
		
		entrada.setData(new Date());
		
		EntradaDAO entradaDAO = new EntradaDAOImpl();
		entradaDAO.inserirEntrada(entrada);
		
		return retorno;
	}
	@Path("/editarEntrada")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoServico editarEntrada(Entrada entrada) {
		RetornoServico retorno = new RetornoServico();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Editado com sucesso!");
		
		Entrada novo = new Entrada();
		
		novo.setNome_cliente(new String());
		novo.setTel_cliente(new String());
		novo.setData(new Date());
		
		boolean achou = false;
		
		
		if(novo.getNome_cliente().isEmpty() 
		&& novo.getTel_cliente().isEmpty()) {
	//	&& novo.getData() { achar qual o metodo de Date
		}
		achou = true;
		
		if(achou) {
			System.out.println("EROO");
			
		}else {
			
			EntradaDAO entradaDAO = new EntradaDAOImpl();
			entradaDAO.alterarEntrada(entrada);
			entradaDAO.inserirEntrada(novo);
			novo = new Entrada();
		}
		return retorno;
	
}
	@Path("/pesquisarEntrada")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoServico pesquisarEntrada(@QueryParam("id") int id) {
		RetornoServico retorno = new RetornoServico();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Teste do teste");
		
		EntradaDAO entradaDAO = new EntradaDAOImpl();
		retorno.setEntradaRetorno(entradaDAO.pesquisarEntrada(id));
		
		return retorno;
	}
	
}
