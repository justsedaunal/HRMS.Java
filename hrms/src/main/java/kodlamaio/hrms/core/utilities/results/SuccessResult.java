package kodlamaio.hrms.core.utilities.results;

public class SuccessResult extends Result{

	public SuccessResult(boolean success) {
		super(success);
		// TODO Auto-generated constructor stub
	}
	public SuccessResult(boolean success, String message) {
		super(true, message);
		// TODO Auto-generated constructor stub
	}


}
