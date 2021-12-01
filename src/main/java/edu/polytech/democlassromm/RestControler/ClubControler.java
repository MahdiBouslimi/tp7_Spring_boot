package edu.polytech.democlassromm.RestControler;

import edu.polytech.democlassromm.Entities.Classroom;
import edu.polytech.democlassromm.Entities.Club;
import edu.polytech.democlassromm.Entities.Student;
import edu.polytech.democlassromm.Repositories.ClubRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;


@CrossOrigin("*")
@RestController
@RequestMapping("/club")
public class ClubControler {
    @Autowired
    private ClubRespository clubRespository;

    @GetMapping("/best")
    private Club bestClub(){
        return clubRespository.bestClub();
    }
    @GetMapping("/worst")
    private Club worstClub(){
        return clubRespository.worstClub();
    }

    @GetMapping("/nbStudentClub")
    Iterable<Object[]> studentsPerClub(){
       return clubRespository.studentsPerClub();
    }

    @GetMapping("/nbClub")
    private Long CountClub(){
      return   clubRespository.count();
    }
    @GetMapping("/all")
    private Iterable<Club> ClubList(){
        return clubRespository.findAll();
    }

    @PostMapping("/add")
    private Club addClub(@RequestBody Club club)
    {
        return clubRespository.save(club);
    }

    @PutMapping("/update/{id}")
    private Club modifieClub ( @RequestBody Club club
            , @PathVariable Integer id ){
        Club club1 = new Club();
        club1 = clubRespository.findById(id).get();
        if(club1 != null){
            club1.setId(club.getId());
            club1.setCreationDate(club.getCreationDate());
            return clubRespository.save(club);
        }else
            return null;

    }
    @DeleteMapping("/delete/{id}")
    public void deleteclubByid(@PathVariable Integer id) {
        clubRespository.deleteById(id);
    }
    //Modifier
    @PutMapping("/modif")
    private Club modifierClub (@RequestBody Club club ){
        return clubRespository.save(club);
    }


    @GetMapping("/getprofile/{cd}")
    public Club getCreationDate(@PathVariable Date cd){
        Club appUser = (Club) clubRespository.findByCreationDate(cd);
        return appUser ;
    }
    @GetMapping("/byId")
    public Optional<Club> findClubById(Integer id) {

        return clubRespository.findById(id);
    }

}
