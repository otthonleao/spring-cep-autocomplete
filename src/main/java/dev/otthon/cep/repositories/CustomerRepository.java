package dev.otthon.cep.repositories;

import dev.otthon.cep.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
