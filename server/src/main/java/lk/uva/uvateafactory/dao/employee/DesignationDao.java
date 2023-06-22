package lk.uva.uvateafactory.dao.employee;

import lk.uva.uvateafactory.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationDao extends JpaRepository<Designation,Integer> {
}
