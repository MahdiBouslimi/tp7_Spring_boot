package edu.polytech.democlassromm.Repositories;

import edu.polytech.democlassromm.Entities.Classroom;
import edu.polytech.democlassromm.Entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRespository extends CrudRepository<Student, Integer> {


   List<Student> findByNsc(@Param("nsc") int nsc);

   @Query("select c from Student c where c.nsc IN (select max(c.nsc) from Student c)")
   Student bestStudent();

}
