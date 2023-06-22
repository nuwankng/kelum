package lk.uva.uvateafactory.controller.area;


import lk.uva.uvateafactory.dao.area.AreastatusDao;
import lk.uva.uvateafactory.entity.Areastatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/areastatuss")
public class AreastatusController {

    @Autowired
    private AreastatusDao areastatusDao;

    @GetMapping( path = "/list", produces = "application/json")
    public List<Areastatus> get() {

        List<Areastatus> areastatuss = this.areastatusDao.findAll();

        areastatuss = areastatuss.stream().map(
                areastatus -> { Areastatus as = new Areastatus();
                    as.setId(areastatus.getId());
                    as.setName(areastatus.getName());
                    return as; }
        ).collect(Collectors.toList());

        return areastatuss;
    }

}
