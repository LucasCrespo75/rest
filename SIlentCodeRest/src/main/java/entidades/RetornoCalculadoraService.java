package entidades;

public class RetornoCalculadoraService {
	
		private int codigoRetorno; // 0 - sucesso 1 - falha
		private String mensagemRetorno; // msg da falha ocorrida
		private String acao;//acao da calculadora
		private double resultadoRetorno;

		public int getCodigoRetorno() {
			return codigoRetorno;
		}

		public void setCodigoRetorno(int codigoRetorno) {
			this.codigoRetorno = codigoRetorno;
		}

		public String getMensagemRetorno() {
			return mensagemRetorno;
		}

		public void setMensagemRetorno(String mensagemRetorno) {
			this.mensagemRetorno = mensagemRetorno;
		}

		public String getAcao() {
			return acao;
		}

		public void setAcao(String acao) {
			this.acao = acao;
		}

		public double getResultadoRetorno() {
			return resultadoRetorno;
		}

		public void setResultadoRetorno(double resultadoRetorno) {
			this.resultadoRetorno = resultadoRetorno;
		}

	
	

}
