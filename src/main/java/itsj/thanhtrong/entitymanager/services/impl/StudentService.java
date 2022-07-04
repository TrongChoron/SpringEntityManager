package itsj.thanhtrong.entitymanager.services.impl;

import itsj.thanhtrong.entitymanager.exceptions.StudentNotFoundException;
import itsj.thanhtrong.entitymanager.models.Student;
import itsj.thanhtrong.entitymanager.repositories.StudentRepository;
import itsj.thanhtrong.entitymanager.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 7/4/2022
 * Time     : 15:09
 * Filename : StudentService
 */
@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException(
                        String.format("Student with id %d do not exist",id)));
    }

    @Override
    public Student addNewStudent(Student student) {
        Student addStudent = new Student();
        addStudent.setName(student.getName());
        addStudent.setEmail(student.getEmail());
        addStudent.setAddress(student.getAddress());
        studentRepository.save(addStudent);
        return addStudent;
    }

    @Override
    public Student updateStudent(Long id,Student student) {
        Student updateStudent =studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException(
                        String.format("Student with id %d do not exist",id)));

        updateStudent.setName(student.getName());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setAddress(student.getAddress());
        studentRepository.save(updateStudent);
        return updateStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        Student studentExist =studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException(
                        String.format("Student with id %d do not exist",id)));
        studentRepository.deleteById(id);
    }
}
