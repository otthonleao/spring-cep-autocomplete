package dev.otthon.cep.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.otthon.cep.enums.EstadosBrasileiros;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ADDRESS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "address_line_1", nullable = false)
    private String addressLine1; // Logradouro

    @Column(name = "street_number", nullable = false)
    private String streetNumber;

    @Column(name = "address_line_2")
    private String addressLine2; // Complemento

    @Column(nullable = false)
    private String neighborhood;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private EstadosBrasileiros state;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id", nullable = false) // Define a chave estrangeira na tabela de endereços
    private Customer customer;

}
