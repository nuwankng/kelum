package lk.uva.uvateafactory.controller.area;

import lk.uva.uvateafactory.dao.area.AreaDao;
import lk.uva.uvateafactory.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/areas")
public class AreaController {

    @Autowired
    private AreaDao areaDao;

    @GetMapping(produces = "application/json")
    public List<Area> get(@RequestParam HashMap<String,String> params) {

        String code = params.get("code");
        String rootid = params.get("rootid");
        String areacategoryid = params.get("areacategoryid");
        String supervisorid = params.get("supervisorid");
        String fieldofficerid = params.get("fieldofficerid");

        List<Area> areas = this.areaDao.findAll();

        if(params.isEmpty()) return areas;

        Stream<Area> areaStream = areas.stream();

        if(code!=null) areaStream = areaStream.filter(a -> a.getCode().equals(code));
        if(rootid!=null) areaStream = areaStream.filter(a -> a.getRoot().getId()==Integer.parseInt(rootid));
        if(areacategoryid!=null) areaStream = areaStream.filter(a -> a.getAreacategory().getId()==Integer.parseInt(areacategoryid));
        if(supervisorid!=null) areaStream = areaStream.filter(a -> a.getEmpsupervisor().getId() == Integer.parseInt(supervisorid));
        if(fieldofficerid!=null) areaStream = areaStream.filter(a -> a.getEmpfieldofficer().getId()==Integer.parseInt(fieldofficerid));

        return areaStream.collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> add(@RequestBody Area area) {

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        if(areaDao.findByCode(area.getCode()) != null)
            errors = errors+"<br> Existing Area Code";

        if(errors=="") areaDao.save(area);
        else errors = "Server Validation Errors : <br>"+errors;

        responce.put("id",String.valueOf(area.getId()));
        responce.put("url","/areas/"+area.getId());
        responce.put("errors",errors);

        return responce;

    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> update(@RequestBody Area area) {

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Area area1 = areaDao.findByCode(area.getCode());

        if(area1!=null && area.getId()!=area1.getId())
            errors = errors+"<br> Existing Code Number";

        if(errors=="") areaDao.save(area);
        else errors = "Server Validation Errors : <br>"+errors;

        responce.put("id",String.valueOf(area.getId()));
        responce.put("url","/areas/"+area.getId());
        responce.put("errors",errors);

        return responce;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id) {

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Area area1 = areaDao.findByMyId(id);

        if(area1==null)
            errors = errors+"<br> Area Does Not Existed.";

        if(errors=="") areaDao.delete(area1);
        else errors = "Server Validation Errors : <br>"+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/areas/"+id);
        responce.put("errors",errors);

        return responce;

    }

}
