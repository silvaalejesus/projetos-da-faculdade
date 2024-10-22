package utils;

public class CEPFormatter {

    public String extraiEFormataCEP(String endereco) {
        String[] partes = endereco.split(", ");
        String cep = partes[partes.length - 1];
        return formatarCEP(cep);
    }

    public String formatarCEP(String cep) {
        if (cep != null && cep.length() == 8) {
            return cep.substring(0, 5) + "-" + cep.substring(5);
        }
        return cep;

    }
}
