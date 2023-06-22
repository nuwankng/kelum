package lk.uva.uvateafactory.dao.area;

import lk.uva.uvateafactory.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AreaDao extends JpaRepository<Area,Integer> {

    Area findByCode(String code);

    @Query("select a from Area a where a.id = :id")
    Area findByMyId(@Param("id") Integer id);
}
