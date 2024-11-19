package dev.otthon.cep.entities;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(nullable = false)
    private String addressLine1; // Logradouro

    @Column(nullable = false)
    private String streetNumber;

    private String addressLine2; // Complemento

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private EstadosBrasileiros states;

    @ManyToOne
    @JoinColumn(name = "customer_id") // Define a chave estrangeira na tabela de endereços
    private Customer customer;

}
