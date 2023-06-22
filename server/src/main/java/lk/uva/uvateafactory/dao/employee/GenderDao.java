package lk.uva.uvateafactory.dao.employee;

import lk.uva.uvateafactory.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderDao extends JpaRepository<Gender,Integer> {
}
