package lk.uva.uvateafactory.dao.plucking;

import lk.uva.uvateafactory.entity.Plucking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PluckingDao extends JpaRepository<Plucking,Integer> {

    @Query("select p from Plucking p where p.id = :id")
    Plucking findByMyId(@Param("id") Integer id);

}
