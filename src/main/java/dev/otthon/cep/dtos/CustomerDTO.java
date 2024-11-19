package dev.otthon.cep.dtos;

import dev.otthon.cep.entities.Address;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private UUID id;

    @NotBlank(message = "O nome não pode ser nulo ou vazio.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "O nome deve conter apenas letras e espaços.")
    private String name;

    @NotBlank(message = "O email é obrigatório e não pode estar vazio.")
    @Size(max = 255, message = "O email não pode ter mais de 255 caracteres.")
    @Email(message = "O email deve ser válido, por exemplo: meu_email@dominio.com")
    private String email;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Past(message = "A data de nascimento deve estar no passado.")
    private LocalDate birthDate;

    @NotNull(message = "O tipo de cliente é obrigatório: 1 - Pessoa Física, 2 - Pessoa Jurídica.")
    @Min(value = 1, message = "O tipo de cliente deve ser 1 (Pessoa Física) ou 2 (Pessoa Jurídica).")
    @Max(value = 2, message = "O tipo de cliente deve ser 1 (Pessoa Física) ou 2 (Pessoa Jurídica).")
    private Integer customerType;

    @NotNull(message = "O números de telefone é obrigatório.")
    @Pattern(regexp = "\\d+", message = "O campo deve conter apenas números.")
    @Size(min = 10, max = 11, message = "O campo deve ter entre 10 e 11 caracteres.")
    private Set<String> phoneNumber;

    @NotNull(message = "O endereço é obrigatório.")
    private List<Address> addresses;

}
