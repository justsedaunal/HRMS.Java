package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface EmailVerificationService {
	 boolean validate(Candidate candidate);
}
