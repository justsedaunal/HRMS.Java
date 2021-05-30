package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Candidate;
@Repository
@EnableJpaRepositories
public interface CandidateDao extends JpaRepository<Candidate, Integer>{
Candidate findCandidateById(int id);

boolean existsByEmailAddress(String emailAddress);

}
