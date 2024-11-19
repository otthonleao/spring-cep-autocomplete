package dev.otthon.cep.enums;

import lombok.Getter;

@Getter
public enum EstadosBrasileiros {

    AC("Acre", "AC", 12),
    AL("Alagoas", "AL", 27),
    AM("Amazonas", "AM", 13),
    AP("Amapá", "AP", 16),
    BA("Bahia", "BA", 29),
    CE("Ceará", "CE", 23),
    DF("Distrito Federal", "DF", 53),
    ES("Espírito Santo", "ES", 32),
    GO("Goiás", "GO", 52),
    MA("Maranhão", "MA", 21),
    MT("Mato Grosso", "MT", 51),
    MS("Mato Grosso do Sul", "MS", 50),
    MG("Minas Gerais", "MG", 31),
    PA("Pará", "PA", 15),
    PB("Paraíba", "PB", 25),
    PR("Paraná", "PR", 41),
    PE("Pernambuco", "PE", 26),
    PI("Piauí", "PI", 22),
    RJ("Rio de Janeiro", "RJ", 33),
    RN("Rio Grande do Norte", "RN", 24),
    RS("Rio Grande do Sul", "RS", 43),
    RO("Rondônia", "RO", 11),
    RR("Roraima", "RR", 14),
    SC("Santa Catarina", "SC", 42),
    SP("São Paulo", "SP", 35),
    SE("Sergipe", "SE", 28),
    TO("Tocantins", "TO", 17);

    private final String nome;
    private final String uf;
    private final int codigoIBGE;

    private EstadosBrasileiros(String nome, String uf, int codigoIBGE) {
        this.nome = nome;
        this.uf = uf;
        this.codigoIBGE = codigoIBGE;
    }

    public static String getEstadoByCodigoIBGE(int codigoIBGE) {
        for (EstadosBrasileiros estado : EstadosBrasileiros.values()) {
            if (estado.getCodigoIBGE() == codigoIBGE) {
                return estado.getNome();
            }
        }
        throw new IllegalArgumentException("Código IBGE inválido: " + codigoIBGE);
    }



}
