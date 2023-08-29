package br.gov.sp.fatec.crud_estudante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.crud_estudante.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
