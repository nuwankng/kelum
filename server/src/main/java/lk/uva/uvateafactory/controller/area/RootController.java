package lk.uva.uvateafactory.controller.area;


import lk.uva.uvateafactory.dao.area.RootDao;
import lk.uva.uvateafactory.entity.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/roots")
public class RootController {

    @Autowired
    private RootDao rootDao;

    @GetMapping( path = "/list", produces = "application/json")
    public List<Root> get() {

        List<Root> roots = this.rootDao.findAll();

        roots = roots.stream().map(
                root -> { Root r = new Root();
                    r.setId(root.getId());
                    r.setName(root.getName());
                    return r; }
        ).collect(Collectors.toList());

        return roots;
    }

}
