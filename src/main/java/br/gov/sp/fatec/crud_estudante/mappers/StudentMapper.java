package br.gov.sp.fatec.crud_estudante.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.sp.fatec.crud_estudante.dtos.StudentRequest;
import br.gov.sp.fatec.crud_estudante.dtos.StudentResponse;
import br.gov.sp.fatec.crud_estudante.entities.Student;

public class StudentMapper {
    public static Student toEntity(StudentRequest request){
        Student student = new Student();
        student.setName(request.name());
        student.setEmail(request.email());
        student.setAddress(request.address());
        student.setPhoneNumber(request.phoneNumber());
        student.setCourse(request.course());
        return student;
    }
    public static StudentResponse toDTO (Student student){
        return new StudentResponse(student.getId(), student.getName(), student.getEmail(), student.getAddress(), student.getPhoneNumber(), student.getCourse());
    }
    public static List<StudentResponse> toDTOList(List<Student> students){
        return students.stream().map(StudentMapper::toDTO).collect(Collectors.toList());
    }
}
