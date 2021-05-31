package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.Result;


@RestController
@RequestMapping("api/confirm")
public class EmployeesController {
	
	@Autowired
	private EmployeeService employeeService ;
	@PostMapping("/register")
	public Result confirmEmployer(@RequestParam int employerId ) {
		return employeeService.confirmEmployer(employerId );
	}

}
