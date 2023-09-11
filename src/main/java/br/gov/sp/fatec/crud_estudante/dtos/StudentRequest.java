package br.gov.sp.fatec.crud_estudante.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record StudentRequest(
    @NotBlank() 
    String name,
    @NotBlank()
    String email,
    @NotBlank() 
    String address,
    @Min(value = 8, message = "Número deve conter pelo menos 8 números")
    String phoneNumber,
    @NotBlank() String course) {
}
