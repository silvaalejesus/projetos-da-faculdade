package entity;

import enumeration.Disponibilidade;
import enumeration.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Locacao {

    private static long contadorId = 0;
    private Long id;
    private Long clienteId;
    private Long imovelId;
    private String inicioLocacao;
    private String horaInicioLocacao;
    private String fimLocacao;
    private String horaFimLocacao;
    private double valorCaucao;
    private Status statusLocacao;
    private Imovel imovel;

    // Formatação de data e hora
    // private DateTimeFormatter dateFormatter =
    // DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // private DateTimeFormatter timeFormatter =
    // DateTimeFormatter.ofPattern("HH:mm:ss");

    public Locacao(Long clienteId, Long imovelId, String inicioLocacao, String horaInicioLocacao,
            String fimLocacao, String horaFimLocacao, double valorCaucao, Status statusLocacao) {
        this.id = ++contadorId;
        // this.id = id;
        this.clienteId = clienteId;
        this.imovelId = imovelId;
        this.inicioLocacao = inicioLocacao;
        this.horaInicioLocacao = horaInicioLocacao;
        this.fimLocacao = fimLocacao;
        this.horaFimLocacao = horaFimLocacao;
        this.valorCaucao = valorCaucao;
        this.statusLocacao = statusLocacao;
    }

    public Locacao(Long clienteId, Imovel imovel, Long imovelId, String inicioLocacao, String horaInicioLocacao,
            String fimLocacao, String horaFimLocacao, double valorCaucao, Status statusLocacao) {
        this.id = ++contadorId;
        // this.id = id;
        this.imovel = imovel;
        this.clienteId = clienteId;
        this.imovelId = imovelId;
        this.inicioLocacao = inicioLocacao;
        this.horaInicioLocacao = horaInicioLocacao;
        this.fimLocacao = fimLocacao;
        this.horaFimLocacao = horaFimLocacao;
        this.valorCaucao = valorCaucao;
        this.statusLocacao = statusLocacao;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public long calcularQuantidadeDias() {
        LocalDate inicio = LocalDate.parse(inicioLocacao, formatter);
        LocalDate fim = LocalDate.parse(fimLocacao, formatter);
        return ChronoUnit.DAYS.between(inicio, fim);
    }

    public double calcularValorTotal() {
        long quantidadeDias = calcularQuantidadeDias();
        // System.out.println(imovel.getPreco().getValor());
        return imovel.getPreco().getValor() * quantidadeDias;
    }

    // Método para cancelar a locação
    public void cancelarLocacao() {
        this.statusLocacao = Status.CANCELADO;
        // this.imovel.setDisponibilidade(Disponibilidade.S);
        System.out.println("Locação cancelada com sucesso.");
    }

    public Locacao() {

    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public Long getImovelId() {
        return imovelId;
    }

    public String getInicioLocacao() {
        return inicioLocacao;
    }

    public void setInicioLocacao(String inicioLocacao) {
        this.inicioLocacao = inicioLocacao;
    }

    public String getHoraInicioLocacao() {
        return horaInicioLocacao;
    }

    public void setHoraInicioLocacao(String horaInicioLocacao) {
        this.horaInicioLocacao = horaInicioLocacao;
    }

    public String getFimLocacao() {
        return fimLocacao;
    }

    public void setFimLocacao(String fimLocacao) {
        this.fimLocacao = fimLocacao;
    }

    public String getHoraFimLocacao() {
        return horaFimLocacao;
    }

    public void setHoraFimLocacao(String horaFimLocacao) {
        this.horaFimLocacao = horaFimLocacao;
    }

    public double getValorCaucao() {
        return valorCaucao;
    }

    public void setValorCaucao(double valorCaucao) {
        this.valorCaucao = valorCaucao;
    }

    public Status getStatusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(Status statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    public String getInicioLocacaoFormatado() {
        return this.inicioLocacao;
    }

    public String getHoraInicioLocacaoFormatado() {
        return this.horaInicioLocacao;
    }

    public String getFimLocacaoFormatado() {
        return this.fimLocacao;
    }

    public String getHoraFimLocacaoFormatado() {
        return this.horaFimLocacao;
    }

    public void dados() {
        String ANSI_COLOR = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BOLD = "\u001b[1m";

        String dados = String.format(
                ANSI_BOLD + "Locacao" + ANSI_RESET + " {\n" +
                        ANSI_COLOR + "\tid = %s,\n" +
                        "\tclienteId = %s,\n" +
                        "\timovelId = %s,\n" +
                        "\tinicioLocacao = %s,\n" +
                        "\thoraInicioLocacao = %s,\n" +
                        "\tfimLocacao = %s,\n" +
                        "\thoraFimLocacao = %s,\n" +
                        "\tvalorCaucao = R$%s,\n" +
                        "\tqtddias = %s,\n" +
                        "\ttotal do aluguel = %s,\n" +
                        "\tstatusLocacao = %s,\n" + ANSI_RESET +
                        "}",
                id, clienteId, imovelId, getInicioLocacaoFormatado(), getHoraInicioLocacaoFormatado(),
                getFimLocacaoFormatado(), getHoraFimLocacaoFormatado(), valorCaucao, calcularQuantidadeDias(),
                calcularValorTotal(), statusLocacao);

        System.out.println(dados);
    }

}
