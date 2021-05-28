package kodlamaio.hrms.entities.concretes;


import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = " employee_confirms_employers ")

public class EmployeeConfirmsEmployer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employer_id")
	private int employer_id;

	@Column(name = "is_confirmed")
	private boolean is_confirmed;
	
	@Column(name = "created_at")
	private Date created_at;
	
	@Column (name="confirm_date")
	private Timestamp confirm_date;
	

	@Column(name = "employee_id")
	private int employee_id;

}
