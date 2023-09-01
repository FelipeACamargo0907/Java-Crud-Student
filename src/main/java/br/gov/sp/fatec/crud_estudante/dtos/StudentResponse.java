package br.gov.sp.fatec.crud_estudante.dtos;

public record StudentResponse(long id,
        String name,
        String email,
        String address,
        String phoneNumber,
        String course) {

}
