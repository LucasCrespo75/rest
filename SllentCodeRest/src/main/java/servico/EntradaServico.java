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
		return "Serviço de Entrada ativo";
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
	
	@Path("/pesquisarEntrada")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoServico pesquisarEntrada( @QueryParam("nomeCliente") String nomeCliente, 
											@QueryParam("telCliente") String telCliente, 
											@QueryParam("dataInicio") Date dataInicio, 
											@QueryParam("dataFim") Date dataFim, 
											@QueryParam("placaVeiculo") String placaVeiculo) {
		
		return null;
	}
	
}
