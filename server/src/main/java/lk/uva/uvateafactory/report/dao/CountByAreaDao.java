package lk.uva.uvateafactory.report.dao;

import lk.uva.uvateafactory.report.entity.CountByArea;
import lk.uva.uvateafactory.report.entity.CountByDesignation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountByAreaDao extends JpaRepository<CountByArea,Integer> {

    @Query(value = "SELECT NEW CountByArea(r.name, COUNT(a.code)) FROM Area a, Root r WHERE a.root.id = r.id GROUP BY r.id")
    List<CountByArea> countByArea();

}
