package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service

public class CandidateManager implements CandidateService {

	private static final String userDao = null;
	private CandidateDao candidateDao;
    private VerificationCodeService verificationCodeService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao,VerificationCodeService verificationCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public List<Candidate> getAll() {
		// TODO Auto-generated method stub
		return candidateDao.findAll();
	}

	@Override
	public Result registerCandidate(Candidate candidate, String password) {
		
        
        
//        if (!this.verifyApiService.ApiControl(candidate)) {
////			return new ErrorResult("Mernis Kimlik Doğrulaması Başarısız Oldu");
////		}
        if (this.candidateDao.existsByEmailAddress(candidate.getEmailAddress())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (candidateDao.equals(candidate.getIdentificationNumber())) {
			return new ErrorResult("TC Kimlik Numarası Daha Önce Kullanıldı");
		}		
		if (!candidate.getPassword().equals(candidate.getPassword())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		candidateDao.save(candidate);
        String code = verificationCodeService.sendVerificationCode();
        verifyCandidate(code , candidate, candidate.getEmailAddress());
        return new SuccessResult("Candidate has been added.");
	
    }

	private void verifyCandidate(String code, Candidate candidate, String email) {

        VerificationCode verificationCode = new VerificationCode( );
        verificationCode.set_verified(true);
        verificationCode.setUserId(candidate);
        verificationCode.setVerificationCode(code);
        this.verificationCodeService.add(verificationCode);
        System.out.println("Verification code has been sent to " + email);
    }

		
		
	}

