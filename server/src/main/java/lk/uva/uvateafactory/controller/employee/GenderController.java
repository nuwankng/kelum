package lk.uva.uvateafactory.controller.employee;


import lk.uva.uvateafactory.dao.employee.GenderDao;
import lk.uva.uvateafactory.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/genders")
public class GenderController {

    @Autowired
    private GenderDao genderDao;

    @GetMapping( path = "/list", produces = "application/json")
    public List<Gender> get() {

        List<Gender> genders = this.genderDao.findAll();

        genders = genders.stream().map(
                gender -> { Gender g = new Gender();
                    g.setId(gender.getId());
                    g.setName(gender.getName());
                    return g; }
        ).collect(Collectors.toList());

        return genders;
    }

}
