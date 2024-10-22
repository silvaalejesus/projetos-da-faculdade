package utils;

public class RGFormatter {
    public static String formatRG(String rg) {
        rg = rg.replaceAll("[^0-9A-Za-z]", ""); // Remove caracteres não alfanuméricos
        return rg.replaceAll("(\\d{2})(\\d{3})(\\d{3})([A-Za-z]{2})", "$1.$2.$3-$4");
    }
}
