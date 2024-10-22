package enumeration;

public enum TipoDeImovel {
    APARTAMENTO,
    CASA,
    TERRENO,
    CHACARA,
    SITIO,
    SALA_COMERCIAL,
    GALPAO,
    KITNET,
    COBERTURA,
    FLAT
}

// public enum TipoDeImovel {
// APARTAMENTO(1),
// CASA(2),
// TERRENO(3),
// CHACARA(4),
// SITIO(5),
// SALA_COMERCIAL(6),
// GALPAO(7),
// KITNET(8),
// COBERTURA(9),
// FLAT(10);

// private final int codigo;

// TipoDeImovel(int codigo) {
// this.codigo = codigo;
// }

// public int getCodigo() {
// return codigo;
// }

// public static TipoDeImovel fromCodigo(int codigo) {
// for (TipoDeImovel tipo : TipoDeImovel.values()) {
// if (tipo.getCodigo() == codigo) {
// return tipo;
// }
// }
// throw new IllegalArgumentException("Código inválido: " + codigo);
// }
// }
