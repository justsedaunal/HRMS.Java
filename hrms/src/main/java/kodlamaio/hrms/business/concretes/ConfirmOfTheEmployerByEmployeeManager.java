package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmOfTheEmployerByEmployeeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmOfTheEmployerByEmployeeDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class ConfirmOfTheEmployerByEmployeeManager implements ConfirmOfTheEmployerByEmployeeService {

	private ConfirmOfTheEmployerByEmployeeDao confirmOfTheEmployerByEmployeeDao;

	@Autowired
	public ConfirmOfTheEmployerByEmployeeManager(ConfirmOfTheEmployerByEmployeeDao confirmOfTheEmployerByEmployeeDao) {
		super();
		this.confirmOfTheEmployerByEmployeeDao = confirmOfTheEmployerByEmployeeDao;
	}

////	@Override
//	public Result add(Employer employer) {
////		 if (this.confirmOfTheEmployerByEmployeeDao.existsById//Existsbyemployeryap(employer.getId())) {
////			 
////		 }
////		this.confirmOfTheEmployerByEmployeeDao.saveAndFlush(employer.getId());
////		return new SuccessResult("The employer has been confirmed.");
//	}

}
