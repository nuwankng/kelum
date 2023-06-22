package lk.uva.uvateafactory.controller.plucking;

import lk.uva.uvateafactory.dao.plucking.PluckingsessionDao;
import lk.uva.uvateafactory.entity.Pluckingseesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/pluckingsessions")
public class PluckingsessionController {

    @Autowired
    private PluckingsessionDao pluckingsessionDao;

    @GetMapping( path = "/list", produces = "application/json")
    public List<Pluckingseesion> get() {

        List<Pluckingseesion> pluckingsessions = this.pluckingsessionDao.findAll();

        pluckingsessions = pluckingsessions.stream().map(
                pluckingsession -> { Pluckingseesion ps = new Pluckingseesion();
                    ps.setId(pluckingsession.getId());
                    ps.setName(pluckingsession.getName());
                    return ps; }
        ).collect(Collectors.toList());

        return pluckingsessions;
    }

}
