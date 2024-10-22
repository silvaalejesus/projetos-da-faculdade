package entity;

import enumeration.TipoDeConta;

public class DadosBancarios {
    private String nomeBanco;
    private String numeroAgencia;
    private String numeroConta;
    private String digito;
    private TipoDeConta tipoConta;

    public DadosBancarios(String nomeBanco, String numeroAgencia, String numeroConta, String digito,
            TipoDeConta tipoConta) {
        this.nomeBanco = nomeBanco;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.digito = digito;
        this.tipoConta = tipoConta;
    }

    public DadosBancarios() {
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public TipoDeConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoDeConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public void dados() {
        String ANSI_COLOR = "\u001B[96m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BOLD = "\u001b[1m";

        String dados = String.format(
                ANSI_BOLD + "Dados Bancarios" + ANSI_RESET + " {\n" +
                        ANSI_COLOR + "\tNome do Banco = %s,\n" +
                        "\tNumero da Agencia = %s,\n" +
                        "\tNumero da Conta = %s,\n" +
                        "\tDigito da Conta = %s,\n" +
                        "\tTipo da Conta = %s\n" + ANSI_RESET +
                        "}",
                nomeBanco, numeroAgencia, numeroConta, digito, tipoConta);

        System.out.println(ANSI_COLOR + dados + ANSI_RESET);
    }

}
