package lk.uva.uvateafactory.controller.employee;


import lk.uva.uvateafactory.dao.employee.EmployeestatusDao;
import lk.uva.uvateafactory.entity.Employeestatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/employeestatuses")
public class EmployeestatusController {

    @Autowired
    private EmployeestatusDao employeestatusDao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Employeestatus> get() {
        List<Employeestatus> employeestatuss = this.employeestatusDao.findAll();

        employeestatuss = employeestatuss.stream().map(
                employeestatus -> { Employeestatus d = new Employeestatus();
                    d.setId(employeestatus.getId());
                    d.setName(employeestatus.getName());
                    return d;
                }
        ).collect(Collectors.toList());

        return employeestatuss;
    }

}
