package edu.polytech.democlassromm;

import edu.polytech.democlassromm.Entities.Classroom;
import edu.polytech.democlassromm.Entities.Club;
import edu.polytech.democlassromm.Entities.Student;
import edu.polytech.democlassromm.Repositories.ClassroomRespository;
import edu.polytech.democlassromm.Repositories.ClubRespository;
import edu.polytech.democlassromm.Repositories.StudentRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
//allez sur http://localhost:port/swagger-ui.html
//aller sur h2 database http://localhost:prot/h2-console
public class DemoClassrommApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoClassrommApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRespository studentRepository,
                                  ClassroomRespository classroomRespository,
                                  ClubRespository clubRespository) {
        return (args) -> {
            Club c = new Club("2021-12-01T11:07:55.688Z");
            Club c1 = new Club("2022-11-01T11:07:55.688Z");
            Club c2 = new Club("2023-02-01T11:07:55.688Z");
            List<Club> clubs = new ArrayList<>();
            clubs.add(c);
            clubs.add(c1);
            List<Club> clubs2 = new ArrayList<>();
            clubs2.add(c1);
            clubs2.add(c2);
            clubRespository.save(c);
            clubRespository.save(c1);
            clubRespository.save(c2);


            Classroom cl = new Classroom("GL");
            Classroom cl1 = new Classroom("Reseaux");
            Classroom cl2 = new Classroom("BIG Data");
            List<Classroom> classrooms = new ArrayList<>();
            classrooms.add(cl);
            classrooms.add(cl1);
            classrooms.add(cl2);
            classroomRespository.saveAll(classrooms);

            Student u = new Student(123, "Abdelkhalek@gmail.com");
            Student u1 = new Student(12, "saleh@gmail.com");
            Student u2 = new Student(14, "alexa@gmail.com");
            Student u3 = new Student(15, "jacksparo@gmail.com");
            Student u4 = new Student(19, "yani@gmail.com");
            List<Student> students = new ArrayList<>();
            students.add(u);
            students.add(u1);
            students.add(u2);
            students.add(u3);
            students.add(u4);
            studentRepository.saveAll(students);
            u.setClassroom(cl);
            u.setClub(clubs2);
            studentRepository.save(u);
            u1.setClassroom(cl1);
            u1.setClub(clubs);
            studentRepository.save(u1);
            u2.setClassroom(cl1);
            u2.setClub(clubs);
            studentRepository.save(u2);
            u3.setClassroom(cl2);
            u3.setClub(clubs);
            studentRepository.save(u3);
            u4.setClassroom(cl2);
            u4.setClub(clubs2);
            studentRepository.save(u4);
            c.setStudents(students);
            c1.setStudents(students);
            c2.setStudents(students);
            clubRespository.save(c);
            clubRespository.save(c1);
            clubRespository.save(c2);

        };
    }

}
