package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = " email_verification ")

public class EmailVerification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "users_id")
	private int users_id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "created_at")
	private Date created_at;
	
	@Column (name="is_verified")
	private boolean is_verified;
}

