package edu.polytech.democlassromm.Repositories;

import edu.polytech.democlassromm.Entities.Classroom;
import edu.polytech.democlassromm.Entities.Club;
import edu.polytech.democlassromm.Entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ClubRespository extends CrudRepository<Club, Integer> {
 List<Club> findByCreationDate(@Param("creationDate") Date creationDate);

    @Query("select c, count (c.students) from Club c group by c.students")
    Iterable<Object[]> studentsPerClub();

//    @Query("select count(c) from Club c where c = :club")
//    Long studentCountPerClub(@Param("club") Club club);

    @Query("select c from Club c where c.students in (select max(c.students) from Club c)")
    Club bestClub();

    @Query("select c from Club c where c.students in (select min(c.students) from Club c)")
    Club worstClub();

//    @Query(value = "select c from Student s JOIN s.club c ",)
//    Iterable<Club> findClubByStudents(@Param("s")String s);

/*
    boolean findAllByNameAndSurnameAndDate(){


    }*/

}
