package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ConfirmOfTheEmployerByEmployee;
import kodlamaio.hrms.entities.concretes.Employer;

public interface ConfirmOfTheEmployerByEmployeeDao extends JpaRepository<ConfirmOfTheEmployerByEmployee, Integer>{

	boolean existsById(Employer employer);

}
