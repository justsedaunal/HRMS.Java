package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)

@Data
@Entity

@Table(name="candidates")
@NoArgsConstructor

public class Candidate extends User{
	

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identification_number")
	private String identificationNumber;
	
	@Column(name = "birth_date")
	private Date birthDate;

}
