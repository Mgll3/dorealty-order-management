package com.doreality.order_management.model.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginDTO {
    private String email;
    private String password;
}
