package dev.otthon.cep.controllers;

import dev.otthon.cep.dtos.WebmaniaResponseDTO;
import dev.otthon.cep.services.CepService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/cep")
public class CepController {

    private final CepService cepService;

    @GetMapping("/{cep}")
    public WebmaniaResponseDTO consultCep(@PathVariable String cep) {
        return cepService.getAdressByCep(cep);
    }

}
