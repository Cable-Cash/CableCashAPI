package com.cablecash.api.model.dto.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String email;
    private String senha;
    private Integer idCliente;
    private Boolean habilitado;

}
