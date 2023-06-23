package lk.uva.uvateafactory.report.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeaCropSummaryDao extends JpaRepository<lk.uva.uvateafactory.report.entity.TeaCropSummary,Integer> {

//    @Query(value = "SELECT NEW TeaCropSummary( a.code,a.id,sum(a.id) ) FROM Plucking p inner join Area a on p.area.id=a.id group by p.area.id")
//    List<lk.uva.uvateafactory.report.entity.TeaCropSummary> teacropsummary();

    @Query(value = "SELECT NEW TeaCropSummary(p.qty,sum(p.bonus))  FROM Plucking p inner join Area a on p.area.id=a.id group by p.area.id")
    List<TeaCropSummaryDao> teacropsummary();
}
