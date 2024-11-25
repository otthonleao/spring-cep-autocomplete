package dev.otthon.cep.services;

import dev.otthon.cep.dtos.WebmaniaResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private static final String URL_TEMPLATE = "https://webmaniabr.com/api/1/cep/%s/?app_key=SR0jnSwM1MjOPn8Ur198TbUrwtXwHxqO&app_secret=zCgcOpr0izDju8MAPFgRPJnXcGk5AKr2pUiTIo1G57L3G1PF";

    public WebmaniaResponseDTO getAdressByCep(String cep) {
        String url = String.format(URL_TEMPLATE, cep);
        RestTemplate restTemplate = new RestTemplate();
        WebmaniaResponseDTO response = restTemplate.getForObject(url, WebmaniaResponseDTO.class);
        return response;
    }

    public boolean cepExists(String cep) {
        WebmaniaResponseDTO response = getAdressByCep(cep);
        return response.getCep() != null;
    }
}
