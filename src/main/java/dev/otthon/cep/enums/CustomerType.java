package dev.otthon.cep.enums;

import lombok.Getter;

@Getter
public enum CustomerType {

    PF(0, "Pessoa Física", "Individual Costumer"),
    PJ(1, "Pessoa Jurídica", "Business Costumer");

    private final int code;
    private final String tipo;
    private final String type;

    private CustomerType(int code, String tipo, String type) {
        this.code = code;
        this.tipo = tipo;
        this.type = type;
    }

    public static CustomerType valueOf(int code) {
        for (CustomerType value : CustomerType.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid CustomerType code");
    }
}
