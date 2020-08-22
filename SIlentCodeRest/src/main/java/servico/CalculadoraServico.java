package servico;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import entidades.RetornoCalculadoraService;
//CAMINHO servico
@Path("/calculadora")

public class CalculadoraServico {
	
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadoraService ola() {
		RetornoCalculadoraService retorno = new RetornoCalculadoraService();
		retorno.setMensagemRetorno("FUNFOU");
		return retorno;
	}
	
	@Path("/somar")//CAMINHO 
	@GET //consumo retornando algo
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadoraService somar(@QueryParam("valor1")double valor1, 
						@QueryParam("valor2")double valor2) {
		RetornoCalculadoraService retorno = new RetornoCalculadoraService();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Sucesso");
		retorno.setAcao("Soma");
		retorno.setResultadoRetorno(valor1 + valor2);
		
		
		
		
		return retorno;
		
		//return ""+ (valor1 + valor2);
}

	@Path("/subtrair")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadoraService subtrair(@QueryParam("valor1")double valor1, 
						   @QueryParam("valor2")double valor2) {
RetornoCalculadoraService retorno = new RetornoCalculadoraService();
retorno.setCodigoRetorno(0);
retorno.setMensagemRetorno("Sucesso");
retorno.setAcao("Subtrair");
retorno.setResultadoRetorno(valor1 - valor2);




return retorno;

	//	return ""+ (valor1 - valor2);
		
}
	@Path("/multiplicar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadoraService multiplicar(@QueryParam("valor1")double valor1,
							@QueryParam("valor2")double valor2) {
		RetornoCalculadoraService retorno = new RetornoCalculadoraService();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Sucesso");
		retorno.setAcao("Multiplicar");
		retorno.setResultadoRetorno(valor1 * valor2);
		
	

		return retorno;
		//return ""+ (valor1 * valor2);
}
	@Path("/dividir")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadoraService dividir(@QueryParam("valor1")double valor1, 
							@QueryParam("valor2")double valor2, @QueryParam("resultado")double resutlado) {
		RetornoCalculadoraService retorno = new RetornoCalculadoraService();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Sucesso");
		retorno.setAcao("Dividir");
		
		if(valor1 == 0) {
			retorno.setMensagemRetorno("NAO PODE SER DIVIDIDO POR ZERO");
		
		}else {
		retorno.setResultadoRetorno(valor1/valor2);;
		}
		
		return retorno;
		
		
		
		
			
		
		//return ""+ (valor1 / valor2);
		
}

		
	}
	
