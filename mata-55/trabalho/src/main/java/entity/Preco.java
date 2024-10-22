package entity;

public class Preco {
  // private Long id;
  private Double valor;

  public Preco( Double valor) {
    // this.id = id;
    this.valor = valor;
  }

  public Preco() {

  }

  // ETAPA 3 DO PROJETO - Composição e Agregação
  public Double calcularPrecoArea(double area) {
    return valor * area;
  }

  // public Long getId() {
  //   return id;
  // }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String toString() {
    return valor.toString();
  }

}