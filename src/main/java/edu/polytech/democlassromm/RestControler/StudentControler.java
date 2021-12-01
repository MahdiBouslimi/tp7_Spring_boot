package edu.polytech.democlassromm.RestControler;

import edu.polytech.democlassromm.Entities.Classroom;
import edu.polytech.democlassromm.Entities.Student;
import edu.polytech.democlassromm.Repositories.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin("*")
@RestController
@RequestMapping("/students")
public class StudentControler {
    @Autowired
    private StudentRespository studentRespository;
    //Get All Students from Database
    @GetMapping("/all")
    private Iterable<Student> StudentsList(){
        return studentRespository.findAll();
    }

    @PostMapping("/add")
    private Student addStudent(@RequestBody Student student)
    {
        return studentRespository.save(student);
    }

    @PutMapping("/update/{id}")
    private Student modifieradmin ( @RequestBody Student student
            , @PathVariable Integer id ){
        Student ancien = new Student();
        ancien =   studentRespository.findById(id).get();
        if(ancien != null){
            ancien.setNsc(student.getNsc());
            ancien.setEmail(student.getEmail());
            return studentRespository.save(ancien);
        }else
            return null;

    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudentByid(@PathVariable Integer id) {
        studentRespository.deleteById(id);
    }

    //Modifier
    @PutMapping("/modif/{id}")
    private Student modifierstudents (@RequestBody Student student , @PathVariable Integer id ){

        return studentRespository.save(student);
    }
    @GetMapping("/mmm")
    private Student bestStudent() {

        return studentRespository.bestStudent() ;

    }
    @GetMapping("/count")
    private Long count() {

        return studentRespository.count() ;

    }


    @GetMapping("/getprofile/{st}")
    public Student getSudent(@PathVariable int st ){
        Student student = (Student) studentRespository.findByNsc(st);
        return student ;
    }
    @GetMapping("/byId")
    public Optional<Student> findStudentById(Integer id) {

        return studentRespository.findById(id);

}
}
