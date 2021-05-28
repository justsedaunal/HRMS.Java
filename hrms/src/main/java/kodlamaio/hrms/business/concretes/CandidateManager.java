package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service

public class CandidateManager implements CandidateService {

	@Autowired
	private CandidateDao candidatedao;
	private EmailVerificationService emailVerificationService;

	public CandidateManager(CandidateDao candidatedao, EmailVerificationService emailVerificationService) {
		super();
		this.candidatedao = candidatedao;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public List<Candidate> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> add(Candidate candidate) {
		// TODO Auto-generated method stub
		return null;
	}}
//	@Override
//	public ErrorResult add(Candidate candidate) {
//
//		if (checkIfRealPerson(Long.parseLong(candidate.getIdentificationNumber()), candidate.getFirstName(),
//				candidate.getLastName(), candidate.getBirthDate())== false) {
//			return new ErrorResult("TCKN could not be verified.");
//		}
//
//		if (!checkIfNullInfoForJobseeker(jobseeker, confirmPassword)) {
//
//			return new ErrorResult("You have entered missing information. Please fill in all fields.");
//		}
//
//		if (!checkIfExistsTcNo(jobseeker.getNationalId())) {
//
//			return new ErrorResult(jobseeker.getNationalId() + " already exists.");
//		}
//
//		if (!checkIfEmailExists(jobseeker.getEmail())) {
//
//			return new ErrorResult(jobseeker.getEmail() + " already exists.");
//		}
//
//		jobseekerService.add(jobseeker);
//		String code = verificationService.sendCode();
//		verificationCodeRecord(code, jobseeker.getId(), jobseeker.getEmail());
//		return new SuccessResult("Registration has been successfully completed");
//	}		return null;
//	private boolean checkIfRealPerson(long parseLong, String firstName, String lastName, Date date) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	}
//
//	@Override
//	public List<Candidate> getAll() {
//		return this.candidatedao.findAll();
//	}
//
//}
