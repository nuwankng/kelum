package lk.uva.uvateafactory.controller.area;


import lk.uva.uvateafactory.dao.area.AreacategoryDao;
import lk.uva.uvateafactory.entity.Areacategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/areacategorys")
public class AreacategoryController {

    @Autowired
    private AreacategoryDao areacategoryDao;

    @GetMapping( path = "/list", produces = "application/json")
    public List<Areacategory> get() {

      //helloo
        List<Areacategory> areacategorys = this.areacategoryDao.findAll();

        areacategorys = areacategorys.stream().map(
                areacategory -> { Areacategory ac = new Areacategory();
                    ac.setId(areacategory.getId());
                    ac.setName(areacategory.getName());
                    return ac; }
        ).collect(Collectors.toList());

        return areacategorys;
    }

}
