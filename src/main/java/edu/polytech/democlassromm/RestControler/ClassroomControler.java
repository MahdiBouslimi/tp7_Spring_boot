package edu.polytech.democlassromm.RestControler;

import edu.polytech.democlassromm.Entities.Classroom;

import edu.polytech.democlassromm.Repositories.ClassroomRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin("*")
@RestController
@RequestMapping("/classroom")
public class ClassroomControler {
    @Autowired
    private ClassroomRespository classroomRespository;
    @GetMapping("/maxst")
    private Classroom bestClassroom() {

        return classroomRespository.bestClassroom() ;

    }
    @GetMapping("/all")
    private Iterable<Classroom> ClassroomList(){
        return classroomRespository.findAll();
    }
    @PostMapping("/add")
    private Classroom addClassroom(@RequestBody Classroom classroom)
    {
        return classroomRespository.save(classroom);
    }

    @PutMapping("/update/{id}")
    private Classroom modifieClassroom ( @RequestBody Classroom classroom
            , @PathVariable Integer id ){
        Classroom Class = new Classroom();
        Class =   classroomRespository.findById(id).get();
        if(Class != null){
            Class.setName(classroom.getName());

            return classroomRespository.save(Class);
        }else
            return null;

    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudentByid(@PathVariable Integer id) {
        classroomRespository.deleteById(id);
    }


    //Modifier
    @PutMapping("/modif")
    private Classroom modifierClassroom (@RequestBody Classroom classroom ){
        return classroomRespository.save(classroom);
    }

    @GetMapping("/getprofile/{name}")
    public Classroom getClassroom(@PathVariable String name){
        Classroom classroom = (Classroom) classroomRespository.findByName(name);
        return classroom ;
    }
    @GetMapping("/byId")
    public Optional<Classroom> findClassroomById(Integer id) {

        return classroomRespository.findById(id);
    }
}
