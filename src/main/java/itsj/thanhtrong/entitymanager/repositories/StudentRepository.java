package itsj.thanhtrong.entitymanager.repositories;

import itsj.thanhtrong.entitymanager.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by: IntelliJ IDEA
 * User     : trongnt
 * Date     : Mon, 7/4/2022
 * Time     : 15:08
 * Filename : StudentRepository
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
