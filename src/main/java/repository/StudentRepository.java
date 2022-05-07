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
    Collection<Student> findAllByNameOrderByNameContainsIgnoreCase();
    Collection<Student> findStudentByNameContainsIgnoreCase(String str);
    Collection<Student> findAllByAgeBefore(Integer age);
    Collection<Student> findAllByAgeOrderByAge();

/*1. Получить всех студентов, возраст которых находится между 10 и 20 (можно подставить любые числа, главное, чтобы нижняя граница была меньше верхней).
2. Получить всех студентов, но отобразить только список их имен.
3. Получить всех студентов, у которых в имени присутствует буква «О» (или любая другая).
4. Получить всех студентов, у которых возраст меньше идентификатора.
5. Получить всех студентов упорядоченных по возрасту.*/
}
