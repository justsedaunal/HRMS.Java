package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service

public class EmployerManager implements EmployerService {
	private EmployerDao employerdao;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public EmployerManager(EmployerDao employerdao, VerificationCodeService verificationCodeService) {
		super();
		this.employerdao = employerdao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerdao.findAll();
	}

	@Override
	public Result registerEmployer(Employer employer, String password) {
//		
//		String[] splitMail = employer.getEmailAddress().split("@");
//		String[] splitMail1 = employer.getWebAddress().split("\\.");

//		if (employer.getWebAddress().split("\\.")[1]+employer.getWebAddress().split("\\.").[2]).equals(employer.getEmailAddress().split("@")[1]);
//			return new ErrorResult("Email must be with the same domain as the website!");
		
		String[] splitMail = employer.getEmailAddress().split("@");
		if (!splitMail[1].equals(employer.getWebAddress())) {
			return new ErrorResult("You can only register with an email address with your company website extension");
			}
		if (this.employerdao.existsByEmailAddress(employer.getEmailAddress())) {
			return new ErrorResult("This email address has been taken already!");
		}

		if (!employer.getPassword().equals(employer.getPassword())) {
			return new ErrorResult("password repeat is incorrect.");
		}
		employerdao.save(employer);
		String code = verificationCodeService.sendVerificationCode();
		verifyEmployer(code, employer, employer.getEmailAddress());
		return new SuccessResult("Employer has been added.");
	}

	private void verifyEmployer(String code, Employer employer, String email) {

		VerificationCode verificationCode = new VerificationCode();
		verificationCode.set_verified(true);
		verificationCode.setUserId(employer);
		verificationCode.setVerificationCode(code);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + email);
	}

}
