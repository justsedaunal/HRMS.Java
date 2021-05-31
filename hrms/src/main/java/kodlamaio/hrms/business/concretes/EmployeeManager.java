package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployeeManager implements EmployeeService {
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, EmployerDao employerDao) {
		super();
		this.employeeDao = employeeDao;
		this.employerDao = employerDao;
	}

	private EmployerDao employerDao;
	private EmployeeDao employeeDao;

	@Override
	public Result confirmEmployer(int employerId) {
//	this.employeeDao.activateEmployer(employerId);
		Employer employer = new Employer();
		employer = this.employerDao.findById(employerId).orElse(null);
		if (employer != null) 
		
		{
			employer.setVerified(true);
			this.employerDao.save(employer);
			return new SuccessResult("Emloyer has been confirmed.");

		}
		else {
			return new ErrorResult("Employer has not been found.");
		}

	}

}
