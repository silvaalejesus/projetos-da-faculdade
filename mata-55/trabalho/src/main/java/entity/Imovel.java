package entity;

import enumeration.Disponibilidade;
import enumeration.TipoDeImovel;

public class Imovel {
    
    private static long contadorId = 0;
    private Long id;
    private Long proprietarioId;
    private String endereco;
    private TipoDeImovel tipo;
    private int quartos;
    private int banheiros;
    private double area;
    private Preco preco;
    private Disponibilidade disponibilidade;
    private String descricao;

    public Imovel(long proprietarioId, String endereco, TipoDeImovel tipo, int quartos, int banheiros,
            double area, Preco preco, Disponibilidade disponibilidade, String descricao) {
        this.id = ++contadorId;
        // this.id = id;
        this.proprietarioId = proprietarioId;
        this.endereco = endereco;
        this.tipo = tipo;
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.area = area;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.descricao = descricao;
    }

    public Imovel() {

    }
    
    // ETAPA 3 DO PROJETO - Composição e Agregação
    public double calcularPreco(){
        return preco.calcularPrecoArea(area);
    }

    // Getters e setters (métodos de acesso) para os atributos...

    public Long getId() {
        return id;
    }

    public Long getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Long proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoDeImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeImovel tipo) {
        this.tipo = tipo;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Preco getPreco() {
        return preco;
    }

    public void setPreco(Preco preco) {
        this.preco = preco;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void dados() {
        String ANSI_COLOR = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BOLD = "\u001b[1m";

        String dados = String.format(
                ANSI_BOLD + "Imovel" + ANSI_RESET + " {\n" +
                        ANSI_COLOR + "\tid = %d,\n" +
                        "\tproprietarioId = %d,\n" +
                        "\tendereco = %s,\n" +
                        "\ttipo = %s,\n" +
                        "\tquartos = %d,\n" +
                        "\tbanheiros = %d,\n" +
                        "\tarea = %.2f,\n" +
                        "\tpreco unitario = R$ %s,\n" +
                        "\tdisponibilidade = %s,\n" +
                        "\tdescricao = %s\n" + ANSI_RESET +
                        "}",
                id, proprietarioId, endereco, tipo, quartos, banheiros, area, preco, disponibilidade, descricao);

        System.out.println(dados);
    }

}
