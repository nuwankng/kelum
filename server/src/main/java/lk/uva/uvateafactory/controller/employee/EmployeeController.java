package lk.uva.uvateafactory.controller.employee;

import lk.uva.uvateafactory.dao.employee.EmployeeDao;
import lk.uva.uvateafactory.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(produces = "application/json")
    public List<Employee> get(@RequestParam HashMap<String,String> params) {

        String number = params.get("number");
        String genderid = params.get("genderid");
        String fullname = params.get("fullname");
        String designationid = params.get("designationid");
        String nic = params.get("nic");

        List<Employee> employees = this.employeeDao.findAll();

        if(params.isEmpty()) return employees;

        Stream<Employee> estream = employees.stream();

        if(number!=null) estream = estream.filter(e -> e.getNumber().equals(number));
        if(genderid!=null) estream = estream.filter(e -> e.getGender().getId()==Integer.parseInt(genderid));
        if(fullname!=null) estream = estream.filter(e -> e.getFullname().contains(fullname));
        if(designationid!=null) estream = estream.filter(e -> e.getDesignation().getId()==Integer.parseInt(designationid));
        if(nic!=null) estream = estream.filter(e -> e.getNic().contains(nic));

        return estream.collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> add(@RequestBody Employee employee) {

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        if(employeeDao.findByNumber(employee.getNumber()) != null)
            errors = errors+"<br> Existing Number";
        if(employeeDao.findByNic(employee.getNic()) != null)
            errors = errors+"<br> Existing NIC";
        if(employeeDao.findByMobile(employee.getMobile()) != null)
            errors = errors+"<br> Existing Mobile Number";

        if(errors=="") employeeDao.save(employee);
        else errors = "Server Validation Errors : <br>"+errors;

        responce.put("id",String.valueOf(employee.getId()));
        responce.put("url","/employees/"+employee.getId());
        responce.put("errors",errors);

        return responce;

    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> update(@RequestBody Employee employee) {

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Employee emp1 = employeeDao.findByNumber(employee.getNumber());
        Employee emp2 = employeeDao.findByNic(employee.getNic());
        Employee emp3 = employeeDao.findByMobile(employee.getMobile());

        if(emp1!=null && employee.getId()!=emp1.getId())
            errors = errors+"<br> Existing Number";

        if(emp2!=null && employee.getId()!=emp2.getId())
            errors = errors+"<br> Existing NIC";

        if(emp3!=null && employee.getId()!=emp3.getId())
            errors = errors+"<br> Existing Mobile Number";


        if(errors=="") employeeDao.save(employee);
        else errors = "Server Validation Errors : <br>"+errors;

        responce.put("id",String.valueOf(employee.getId()));
        responce.put("url","/employees/"+employee.getId());
        responce.put("errors",errors);

        return responce;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id) {

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Employee emp1 = employeeDao.findByMyId(id);

        if(emp1==null)
            errors = errors+"<br> Employee Does Not Existed.";

        if(errors=="") employeeDao.delete(emp1);
        else errors = "Server Validation Errors : <br>"+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/employees/"+id);
        responce.put("errors",errors);

        return responce;

    }

    @GetMapping(path = "/byfieldofficer", produces = "application/json")
    public List<Employee> getFieldOfficers() {
//        field officer -> id is 3
         List<Employee> employees = employeeDao.findAllByDesignationId(3);
         return employees;
    }

    @GetMapping(path = "/bysupervisor", produces = "application/json")
    public List<Employee> getSupervisors() {
//        supervisor -> id is 4
        List<Employee> employees = employeeDao.findAllByDesignationId(4);
        return employees;
    }

    @GetMapping(path = "/byfieldofficerandsupervisor", produces = "application/json")
    public List<Employee> getsupervisorsandfieldofficers() {
        return employeeDao.findAllFieldofficerAndSupervisors();
    }

    @GetMapping(path = "/byplucker", produces = "application/json")
    public List<Employee> getPluckers() {
         return employeeDao.findAllPluckers();
    }

    @GetMapping(path = "/bykankani", produces = "application/json")
    public List<Employee> getKankanis() {
        return employeeDao.findAllKankanis();
    }

}
