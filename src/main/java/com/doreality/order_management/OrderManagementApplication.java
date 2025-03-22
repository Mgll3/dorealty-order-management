package com.doreality.order_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}

	/*
	 * TODO:
	 * -
	 * ? Conectar Sql server del docker al proyecto y crearle la DB
	 * ? Crear carpetas y con manejo de errores
	 * ? Crear entidades y montarlas en la DB
	 * ? Agregar seguridad
	 * Controladores y services de Create basicos
	 * 
	 * @Valid
	 * 
	 * 
	 * Pruebas Unitarias
	 * 
	 * 
	 * Hacer que la DB coloque automaticamente con el SP private LocalDate
	 * creationDate;
	 * 
	 * private double totalPrice;
	 * 
	 * 
	 * Agregar Docker compose
	 * Crear Dockerfile
	 * Montar diagrama de clases y E.R.
	 * 
	 */

}
