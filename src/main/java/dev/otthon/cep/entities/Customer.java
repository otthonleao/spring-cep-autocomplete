package dev.otthon.cep.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.otthon.cep.enums.CustomerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TB_CUSTOMER")
@Inheritance(strategy = InheritanceType.JOINED) // Cria uma tabela para cada subclasse
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    @Column(nullable = false)
    private Integer customerType;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "phone_numbers", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "phone_number", nullable = false)
    private Set<String> phoneNumber = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public Customer(String name, String email, LocalDate birthdate, CustomerType customerType) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        setCustomerType(customerType);
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
