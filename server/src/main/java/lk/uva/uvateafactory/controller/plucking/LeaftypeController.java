package lk.uva.uvateafactory.controller.plucking;

import lk.uva.uvateafactory.dao.plucking.LeaftypeDao;
import lk.uva.uvateafactory.entity.Leaftype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/leaftypes")
public class LeaftypeController {

    @Autowired
    private LeaftypeDao leaftypeDao;

    @GetMapping( path = "/list", produces = "application/json")
    public List<Leaftype> get() {

        List<Leaftype> leaftypes = this.leaftypeDao.findAll();

        leaftypes = leaftypes.stream().map(
                leaftype -> { Leaftype leaf = new Leaftype();
                    leaf.setId(leaftype.getId());
                    leaf.setName(leaftype.getName());
                    return leaf; }
        ).collect(Collectors.toList());

        return leaftypes;
    }

}
