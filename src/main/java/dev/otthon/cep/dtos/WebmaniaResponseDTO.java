package dev.otthon.cep.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebmaniaResponseDTO {

      private String endereco;
      private String bairro;
      private String cidade;
      private String uf;
      private String cep;
      private String ibge;

}
