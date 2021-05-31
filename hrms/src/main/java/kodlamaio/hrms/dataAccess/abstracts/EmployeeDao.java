package kodlamaio.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	@Modifying
    @Transactional
    @Query(value = "update employers set is_verified = true where id = (:id)", nativeQuery = true)
   public void activateEmployer(@Param("id") int id);

}
