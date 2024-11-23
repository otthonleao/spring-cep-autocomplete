package dev.otthon.cep.services;

import dev.otthon.cep.dtos.CustomerDTO;
import dev.otthon.cep.entities.Address;
import dev.otthon.cep.entities.Customer;
import dev.otthon.cep.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public CustomerDTO insertCustomer(CustomerDTO customerDTO) {
        Customer entity = new Customer();
        toEntity(customerDTO, entity);
        entity = customerRepository.save(entity);
        return new CustomerDTO(entity);
    }

    private void toEntity(CustomerDTO customerDTO, Customer customer) {
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setBirthdate(customerDTO.getBirthdate());
        customer.setCustomerType(customerDTO.getCustomerType()); // Conversão para enum
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        if (customerDTO.getAddresses() != null) {
            customer.getAddresses().clear(); // Limpa os endereços existentes (para evitar duplicação)
            for (Address address : customerDTO.getAddresses()) {
                address.setCustomer(customer); // Configura o cliente no endereço
                customer.getAddresses().add(address); // Adiciona à lista de endereços do cliente
            }
        }
    }
}
