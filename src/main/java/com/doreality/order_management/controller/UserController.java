package com.doreality.order_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doreality.order_management.model.dto.request.user.*;
import com.doreality.order_management.model.entity.User;
import com.doreality.order_management.service.interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/user")
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @Operation(summary = "Registrar usuario", description = "Endpoint para registrar un nuevo usuario", tags = {
            "Usuario" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario registrado correctamente", content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "409", description = "Conflicto - Este correo electrónico ya está registrado", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "501", description = "Error al procesar la solicitud", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO registerDto) {

        if (userService.existsEmail(registerDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        // Llama al método en el servicio para crear el usuario a partir del DTO
        User user = userService.createUser(registerDto);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Operation(summary = "Iniciar sesión", description = "Endpoint para autenticar y obtener un token de acceso", tags = {
            "Usuario" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autenticación exitosa", content = @Content(schema = @Schema(implementation = AthAnswerDTO.class))),
            @ApiResponse(responseCode = "401", description = "No autorizado - Error al autenticar", content = @Content(schema = @Schema(implementation = AthAnswerDTO.class)))
    })
    @PostMapping("/login")
    public ResponseEntity<AthAnswerDTO> login(@RequestBody LoginDTO loginDto) {
        try {
            AthAnswerDTO answer = userService.authenticate(loginDto);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());

            if (e.getMessage().equals("User not found")) {
                return new ResponseEntity<>(new AthAnswerDTO("User not found"), HttpStatus.UNAUTHORIZED);
            }

            return new ResponseEntity<>(new AthAnswerDTO("Error al autenticar"), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
