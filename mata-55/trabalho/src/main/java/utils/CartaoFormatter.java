package utils;

public class CartaoFormatter {

  public static String formatarNumeroDoCartao(String numeroCartao) {
    if (numeroCartao != null && numeroCartao.length() == 16) {
      return numeroCartao.substring(0, 4) + " " + numeroCartao.substring(4, 8) + " " + numeroCartao.substring(8, 12)
          + " " + numeroCartao.substring(12, 16);
    }
    return numeroCartao;
  }
}