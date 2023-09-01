package br.gov.sp.fatec.crud_estudante.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.crud_estudante.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import br.gov.sp.fatec.crud_estudante.dtos.StudentRequest;
import br.gov.sp.fatec.crud_estudante.dtos.StudentResponse;
import br.gov.sp.fatec.crud_estudante.entities.Student;
import br.gov.sp.fatec.crud_estudante.mappers.StudentMapper;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository repository;

    public List<Student> getStudents(){
        return this.repository.findAll();
    }

    public Student getStudent(long id){
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student Not Found"));
    }

    public void deleteStudentById(long id){
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Student not Found", null);
        }
    }
   
    public StudentResponse save(StudentRequest student){
        var entity = this.repository.save(StudentMapper.toEntity(student));
        return StudentMapper.toDTO(entity);
    }

    public void update( long id, Student student){
        try{
            var updateStudent = this.repository.getReferenceById(id);
            updateStudent.setName(student.getName());
            updateStudent.setEmail(student.getEmail());
            updateStudent.setAddress(student.getAddress());
            updateStudent.setPhoneNumber(student.getPhoneNumber());
            updateStudent.setCourse(student.getCourse());
            this.repository.save(updateStudent);
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Student Not Found");
        }
    }
}
