package lk.uva.uvateafactory.controller;

import lk.uva.uvateafactory.entity.Area;
import lk.uva.uvateafactory.entity.Employee;
import lk.uva.uvateafactory.entity.Plucking;
import lk.uva.uvateafactory.util.RegexProvider;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@CrossOrigin
@RestController
@RequestMapping(value = "/regexes")
public class RegexController {

    @GetMapping(path = "/employee",produces = "application/json")
    public HashMap<String, HashMap<String,String>> employee() {
         return RegexProvider.get(new Employee());
    }

    @GetMapping(path = "/area",produces = "application/json")
    public HashMap<String, HashMap<String,String>> area() {
        return RegexProvider.get(new Area());
    }

    @GetMapping(path = "/plucking",produces = "application/json")
    public HashMap<String, HashMap<String,String>> plucking() {
        return RegexProvider.get(new Plucking());
    }


}
