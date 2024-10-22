package entity;

import java.time.LocalDate;
import java.util.*;

import enumeration.Sexo;

public class Proprietario extends Pessoa {

    // um proprietario pode ter varios imoveis. Cada imóvel pertence a apenas um
    // proprietário.
    // ETAPA 3 DO PROJETO - Composição e Agregação. Uso de ArrayList
    private List<Imovel> imoveis = new ArrayList<Imovel>();
    private DadosBancarios dadosBancarios;

    public Proprietario( String nome, String rg, String cpf, String data_nascimento, Sexo sexo, String endereco,
            String email, String telefone, LocalDate data_cadastro) {
        super( nome, rg, cpf, data_nascimento, sexo, endereco, email, telefone, data_cadastro);
    }

    public Proprietario( String nome, String rg, String cpf, String data_nascimento, Sexo sexo, String endereco,
            String email, String telefone, LocalDate data_cadastro, List<Imovel> imoveis,
            DadosBancarios dadosBancarios) {
        super( nome, rg, cpf, data_nascimento, sexo, endereco, email, telefone, data_cadastro);
        this.imoveis = imoveis;
        this.dadosBancarios = dadosBancarios;
    }

    public Proprietario(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public Proprietario() {

    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public DadosBancarios getDadosBancarios() {
        return dadosBancarios;
    }

    public void setDadosBancarios(DadosBancarios dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public void dados() {
        String ANSI_BOLD = "\u001b[1m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";

        String proprietario = String.format(
                ANSI_BOLD + "Proprietario {" + ANSI_RESET + "\n" +
                        ANSI_BLUE + "\tid = %s,\n" +
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
                getId(),
                getNome(), getRg(), getCpf(), getData_nascimento(), getSexo(), getEndereco(), getEmail(),
                getTelefoneFormatado(), getData_cadastro());

        System.out.println(proprietario);
        dadosBancarios.dados();

        for (Imovel imovel : imoveis) {
            imovel.dados();
        }

        System.out.println(ANSI_BLUE + "}" + ANSI_RESET);
    }

}
