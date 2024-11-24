package dev.otthon.cep.dtos;

import dev.otthon.cep.entities.Address;
import dev.otthon.cep.entities.Customer;
import dev.otthon.cep.enums.CustomerType;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {

    private Long id;

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
    private LocalDate birthdate;

    @NotNull(message = "{field.customer-type.required}")
    @Min(value = 0, message = "{field.customer-type.invalid}")
    @Max(value = 1, message = "{field.customer-type.invalid}")
    private Integer customerType;

    @NotNull(message = "{field.required}")
    private Set<@Pattern(regexp = "^[1-9][0-9]{9,10}$", message = "Invalid phone number. It must contain 10 or 11 digits.") String> phoneNumber;

    @NotEmpty(message = "{field.required}")
    private List<Address> addresses;

    public CustomerDTO(Customer entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public CustomerType getCustomerType() {
        return CustomerType.valueOf(customerType);
    }

    public void setCustomerType(CustomerType customerType) {
        if (customerType != null) {
            this.customerType = customerType.getCode();
        }
    }

}
