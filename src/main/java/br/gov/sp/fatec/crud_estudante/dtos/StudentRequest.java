package br.gov.sp.fatec.crud_estudante.dtos;

import jakarta.validation.constraints.NotBlank;

public record StudentRequest(
    @NotBlank() 
    String name,
    @NotBlank() 
    String email,
    @NotBlank() 
    String address,
    String phoneNumber,
    @NotBlank() String course) {
}
