package entity;

import enumeration.FormaDePagamento;
import utils.CPFFormatter;
import utils.CartaoFormatter;

public class DadosDePagamento {

	private long id;
	private long clienteId;
	private String numeroCartao;
	private String nomeTitular;
	private String dataValidade;
	private String codigoSeguranca;
	private FormaDePagamento formaDePagamento;
	private String cpfTitular;

	public DadosDePagamento(long id, long clienteId, String numeroCartao, String nomeTitular, String dataValidade,
			String codigoSeguranca, FormaDePagamento formaDePagamento, String cpfTitular) {
		this.id = id;
		this.clienteId = clienteId;
		this.numeroCartao = CartaoFormatter.formatarNumeroDoCartao(numeroCartao);
		this.nomeTitular = nomeTitular;
		this.dataValidade = dataValidade;
		this.codigoSeguranca = codigoSeguranca;
		this.formaDePagamento = formaDePagamento;
		this.cpfTitular = CPFFormatter.formatarCPF(cpfTitular);
	}

	public DadosDePagamento() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNumeroCartao() {
		return CartaoFormatter.formatarNumeroDoCartao(numeroCartao);
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public void dados() {
		String ANSI_BOLD = "\u001b[1m";
		String ANSI_RESET = "\u001b[0m";
		String ANSI_YELLOW = "\u001b[93m";

		String dados = String.format(
				ANSI_BOLD + "Dados de Pagamento" + ANSI_RESET + " {\n" +
						ANSI_YELLOW +
						"\tid = %d,\n" +
						"\tID do Cliente = %d,\n" +
						"\tNumero do Cartao = %s,\n" +
						"\tNome do Titular = %s,\n" +
						"\tData de Validade = %s,\n" +
						"\tCodigo de Seguranca = %s,\n" +
						"\tForma de Pagamento = %s,\n" +
						"\tCPF do Titular = %s\n" +
						ANSI_RESET +
						"}",
				id, clienteId, numeroCartao, nomeTitular, dataValidade, codigoSeguranca, formaDePagamento, cpfTitular);

		System.out.println(dados);
	}

}
