package lk.uva.uvateafactory.controller.employee;


import lk.uva.uvateafactory.dao.employee.DesignationDao;
import lk.uva.uvateafactory.entity.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/designations")
public class DesignationController {

    @Autowired
    private DesignationDao designationDao;

    @GetMapping( path = "/list", produces = "application/json")
    public List<Designation> get() {

        List<Designation> designations = this.designationDao.findAll();

        designations = designations.stream().map(
                designation -> { Designation g = new Designation();
                    g.setId(designation.getId());
                    g.setName(designation.getName());
                    return g; }
        ).collect(Collectors.toList());

        return designations;
    }

}
