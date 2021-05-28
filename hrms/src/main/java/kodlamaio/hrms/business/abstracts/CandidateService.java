package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	List<Candidate>getAll();
	 ResponseEntity<?> add(Candidate candidate);


}
