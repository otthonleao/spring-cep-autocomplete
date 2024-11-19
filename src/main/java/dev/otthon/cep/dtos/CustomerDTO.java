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

    @NotBlank(message = "{field.required}")
    @Size(min = 2, max = 100, message = "{field.size.min2max100}")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "{field.name.pattern}")
    private String name;

    @NotBlank(message = "{field.required}")
    @Size(max = 255, message = "{field.size.max255}")
    @Email(message = "{field.email.invalid}")
    private String email;

    @NotNull(message = "{field.required}")
    @Past(message = "{field.date.birthdate}")
    private LocalDate birthDate;

    @NotNull(message = "{field.customer-type.required}")
    @Min(value = 1, message = "{field.customer-type.invalid}")
    @Max(value = 2, message = "{field.customer-type.invalid}")
    private Integer customerType;

    @NotNull(message = "{field.required}")
    @Positive(message = "{field.numbers.positive}")
    @Pattern(regexp = "\\d+", message = "{field.numbers.only}")
    @Size(min = 10, max = 11, message = "{field.numbers.min10max11}")
    private Set<String> phoneNumber;

    @NotBlank(message = "{field.required}")
    private List<Address> addresses;

}
