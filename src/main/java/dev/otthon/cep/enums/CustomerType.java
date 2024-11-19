package dev.otthon.cep.enums;

import lombok.Getter;

@Getter
public enum CustomerType {

    INDIVIDUAL_CUSTOMER(1, "Pesoa Física"),
    BUSINESS_CUSTOMER(2, "Pessoa Jurídica");

    private int code;
    private String description;

    private CustomerType(int code, String description) {
        this.description = description;
    }

    public static CustomerType codeToEnum(Integer code) {
        if (code == null) {
            return null;
        }
        for (CustomerType value : CustomerType.values()) {
            if (code.equals(value.getCode())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código de tipo de cliente inválido: " + code);
    }
}
