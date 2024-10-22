package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import enumeration.Sexo;
import utils.CPFFormatter;
import utils.RGFormatter;

public class Pessoa {

    private static long contadorId = 0;
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String data_nascimento;
    private Sexo sexo;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate data_cadastro;

    public Pessoa(String nome, String rg, String cpf, String data_nascimento, Sexo sexo, String endereco,
            String email, String telefone, LocalDate data_cadastro) {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.id = ++contadorId;
        // this.id = id;
        this.nome = nome;
        this.rg = RGFormatter.formatRG(rg);
        this.cpf = CPFFormatter.formatarCPF(cpf);
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.data_cadastro = data_cadastro;
    }

    public Pessoa() {

    }

    public Long getId() {
        return id;
    }

    // public void setId(Long id) {
    // this.id = id;
    // }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getTelefoneFormatado() {
        if (telefone.length() == 11) {
            return String.format("(%s)%s-%s", telefone.substring(0, 2), telefone.substring(2, 7),
                    telefone.substring(7, 11));
        } else if (telefone.length() == 10) {
            return String.format("(%s)%s-%s", telefone.substring(0, 2), telefone.substring(2, 6),
                    telefone.substring(6, 10));
        } else {
            return telefone; // retorna o número original se não tiver 10 ou 11 dígitos
        }
    }

    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_nascimento='" + data_nascimento + '\'' +
                ", sexo=" + sexo +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", data_cadastro=" + data_cadastro +
                '}';
    }

}
