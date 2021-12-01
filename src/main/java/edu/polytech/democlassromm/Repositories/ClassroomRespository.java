package edu.polytech.democlassromm.Repositories;

import edu.polytech.democlassromm.Entities.Classroom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassroomRespository extends CrudRepository<Classroom, Integer> {
   List<Classroom> findByName(@Param("name") String name);


    @Query("select  c from Classroom c where c.student in (select max(c.student) from Classroom c)")
    Classroom bestClassroom();
    @Query("select s, cl, c from Student s, Classroom  cl, Club c group by c")
    Iterable<Object[]> StudentInClubsPerClass();


}
