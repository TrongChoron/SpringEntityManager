package itsj.thanhtrong.entitymanager.services;

import itsj.thanhtrong.entitymanager.models.Student;

import java.util.List;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 7/4/2022
 * Time     : 15:09
 * Filename : IStudentService
 */
public interface IStudentService {
    List<Student> getAllStudent();

    Student getStudentById(Long id);

    Student addNewStudent(Student student);

    Student updateStudent(Long id,Student student);

    void deleteStudent(Long id);
}
