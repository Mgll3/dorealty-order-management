package com.doreality.order_management.service.interfaces;

import com.doreality.order_management.model.dto.request.user.AthAnswerDTO;
import com.doreality.order_management.model.dto.request.user.LoginDTO;
import com.doreality.order_management.model.dto.request.user.RegisterDTO;
import com.doreality.order_management.model.entity.User;

public interface IUserService {

    public User createUser(RegisterDTO dtoRegistrer);

    public AthAnswerDTO authenticate(LoginDTO loginDTO);

    public Boolean existsEmail(String email);

    public User findByEmail(String email);
}
