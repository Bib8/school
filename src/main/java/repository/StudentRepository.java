package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;
import java.util.Collection;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAge(Integer age);

    Collection<Student> findStudentByAgeBetween(Integer minAge, Integer maxAge);
    Collection<Student> findStudentByNameExistsIgnoreCase();
    Collection<Student> findStudentByNameContainsIgnoreCase(String str);
    Collection<Student> findAllByAgeBefore(Integer age);
    Collection<Student> findStudentByAgeExists();
    Collection<Student> findAllByNameContainsOrderByName(String str);



}
