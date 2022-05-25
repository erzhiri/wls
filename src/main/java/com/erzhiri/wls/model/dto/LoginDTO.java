package com.erzhiri.wls.model.dto;

import lombok.Data;

/**
 * @author erzhiri
 * @version 0.1.0
 * @since 0.1.0
 **/

@Data
public class LoginDTO {

    private String username;

    private String password;

    private String role;
}
