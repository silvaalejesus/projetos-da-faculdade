import java.text.NumberFormat;
import java.util.Locale;

public class Main {
  public static void main(String[] args) {
    NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
    nf.setMinimumFractionDigits(2);

    Empregado empregado1 = new Empregado("João Marcelo", "Souza" , 10000);
    Empregado empregado2 = new Empregado("Maria", "Visconde" , 15000);

    System.out.println("Salário anual de " + empregado1.getNome() + ": R$" + nf.format(empregado1.salarioAnual()));
    System.out.println("Salário anual de " + empregado2.getNome() + ": R$" + nf.format(empregado2.salarioAnual()));

    empregado1.darAumento();
    empregado2.darAumento();

    System.out.println("\nApós o aumento:");
    System.out.println("Salário anual de " + empregado1.getNome() + ": R$" + nf.format(empregado1.salarioAnual()));
    System.out.println("Salário anual de " + empregado2.getNome() + ": R$" + nf.format(empregado2.salarioAnual()));
  }
}