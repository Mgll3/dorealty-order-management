package com.doreality.order_management.model.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDTO {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String address;

}
