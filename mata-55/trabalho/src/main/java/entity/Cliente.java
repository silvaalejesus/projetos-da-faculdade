package entity;

import java.time.LocalDate;
import java.util.*;

import enumeration.FormaDePagamento;
import enumeration.Sexo;

public class Cliente extends Pessoa {
    
    // ETAPA 3 DO PROJETO - Composição e Agregação. Uso de ArrayList
    private List<DadosDePagamento> dadosDePagamento = new ArrayList<DadosDePagamento>();

    // pagamentoPrincipal
    private FormaDePagamento pagamentoUtilizado;

    public Cliente(String nome, String rg, String cpf, String data_nascimento, Sexo sexo, String endereco,
            String email, String telefone, LocalDate data_cadastro) {
        super(nome, rg, cpf, data_nascimento, sexo, endereco, email, telefone, data_cadastro);
    }

    public Cliente(String nome, String rg, String cpf, String data_nascimento, Sexo sexo, String endereco,
            String email, String telefone, LocalDate data_cadastro, List<DadosDePagamento> dadosDePagamento,
            FormaDePagamento pagamentoUtilizado) {
        super(nome, rg, cpf, data_nascimento, sexo, endereco, email, telefone,
                data_cadastro);
        this.dadosDePagamento = dadosDePagamento;
        this.pagamentoUtilizado = pagamentoUtilizado;
    }

    public Cliente() {

    }

    public List<DadosDePagamento> getdadosDePagamento() {
        return dadosDePagamento;
    }

    public void setdadosDePagamento(List<DadosDePagamento> dadosDePagamento) {
        this.dadosDePagamento = dadosDePagamento;
    }

    public FormaDePagamento getPagamentoUtilizado() {
        return pagamentoUtilizado;
    }

    public void setPagamentoUtilizado(FormaDePagamento pagamentoUtilizado) {
        this.pagamentoUtilizado = pagamentoUtilizado;
    }

    public void dados() {
        String ANSI_BOLD = "\u001b[1m";
        String ANSI_RESET = "\u001b[0m";
        String ANSI_MAGENTA = "\u001b[95m";

        String proprietario = String.format(
                ANSI_BOLD + "Cliente" + ANSI_RESET + " {\n" +
                        ANSI_MAGENTA +
                        "\tid = %s,\n" +
                        "\tnome = %s,\n" +
                        "\trg = %s,\n" +
                        "\tcpf = %s,\n" +
                        "\tdata_nascimento = %s,\n" +
                        "\tsexo = %s,\n" +
                        "\tendereco = %s,\n" +
                        "\temail = %s,\n" +
                        "\ttelefone = %s,\n" +
                        "\tdata_cadastro = %s\n" +
                        ANSI_RESET +
                        "}",
                getId(), getNome(), getRg(), getCpf(), getData_nascimento(), getSexo(), getEndereco(), getEmail(),
                getTelefoneFormatado(), getData_cadastro());

        System.out.println(proprietario);
        System.out.println(ANSI_BOLD + ANSI_MAGENTA + "CARTOES CADASTRADOS:" + ANSI_RESET);

        for (DadosDePagamento pagamento : dadosDePagamento) {
            pagamento.dados();
        }

        System.out.println("}");
    }

}
