package lk.uva.uvateafactory.report.controller;

import lk.uva.uvateafactory.report.dao.CountByAreaDao;
import lk.uva.uvateafactory.report.dao.CountByDesignationDao;
import lk.uva.uvateafactory.report.entity.CountByArea;
import lk.uva.uvateafactory.report.entity.CountByDesignation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    @Autowired
    private CountByDesignationDao countbydesignaitondao;

    @Autowired
    private CountByAreaDao countByAreaDao;

    @GetMapping(path ="/countbydesignation",produces = "application/json")
    public List<CountByDesignation> getDesignation() {

        List<CountByDesignation> designations = this.countbydesignaitondao.countByDesignation();
        long totalCount = 0;

        for (CountByDesignation countByDesignation : designations) {
            totalCount += countByDesignation.getCount();
        }

        for (CountByDesignation countByDesignation : designations) {
            long count = countByDesignation.getCount();
            double percentage = (double) count / totalCount * 100;
            percentage = Math.round(percentage * 100.0) / 100.0;
            countByDesignation.setPercentage(percentage);
        }

        return designations;
    }

    @GetMapping(path ="/countbyareas",produces = "application/json")
    public List<CountByArea> getAreas() {

        List<CountByArea> areas = this.countByAreaDao.countByArea();
        long totalCount = 0;

        for (CountByArea countByArea : areas) {
            totalCount += countByArea.getCount();
        }

        for (CountByArea countByArea : areas) {
            long count = countByArea.getCount();
            double percentage = (double) count / totalCount * 100;
            percentage = Math.round(percentage * 100.0) / 100.0;
            countByArea.setPercentage(percentage);
        }

        return areas;
    }

}
