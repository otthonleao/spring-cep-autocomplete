package dev.otthon.cep.controllers;

import dev.otthon.cep.dtos.CustomerDTO;
import dev.otthon.cep.services.CepService;
import dev.otthon.cep.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CepService cepService;

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {

        System.out.println(cepService.getAdressByPostalCode(customerDTO.getAddresses().get(0).getPostalCode()));

        customerDTO = customerService.insertCustomer(customerDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customerDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(customerDTO);
    }
}
