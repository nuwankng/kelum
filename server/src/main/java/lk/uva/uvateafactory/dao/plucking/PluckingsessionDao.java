package lk.uva.uvateafactory.dao.plucking;

import lk.uva.uvateafactory.entity.Leaftype;
import lk.uva.uvateafactory.entity.Pluckingseesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PluckingsessionDao extends JpaRepository<Pluckingseesion,Integer> {

}
