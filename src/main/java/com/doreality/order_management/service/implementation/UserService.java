package com.doreality.order_management.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.doreality.order_management.model.dto.request.user.AthAnswerDTO;
import com.doreality.order_management.model.dto.request.user.LoginDTO;
import com.doreality.order_management.model.dto.request.user.RegisterDTO;
import com.doreality.order_management.model.entity.User;
import com.doreality.order_management.model.entity.UserType;
import com.doreality.order_management.model.repository.UserRepository;
import com.doreality.order_management.service.interfaces.IUserService;

import jakarta.transaction.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    @Transactional
    public User createUser(RegisterDTO dtoRegistrer) {
        User user = new User();
        user.setEmail(dtoRegistrer.getEmail());
        user.setPassword(securityService.passwordEncoder(dtoRegistrer.getPassword()));
        user.setName(dtoRegistrer.getName());
        user.setLastname(dtoRegistrer.getLastname());
        user.setAddress(dtoRegistrer.getAddress());

        // Assign user type 1 "USER" in the database
        user.setUserType(new UserType(1L));

        return userRepository.save(user);
    }

    @Transactional
    public AthAnswerDTO authenticate(LoginDTO loginDTO) {
        String token = securityService.authenticate(loginDTO);
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new DataAccessException("User not found") {
                });
        return new AthAnswerDTO(token, user.getName(), user.getLastname(), user.getUserType().getType());
    }

    public Boolean existsEmail(String email) {
        return userRepository.existsByUseremail(email);
    }

}
