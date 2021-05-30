package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = " verification_codes ")

public class VerificationCode {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
    @ManyToOne(targetEntity = User.class,fetch=FetchType.LAZY)

	@JoinColumn(name = "users_id",referencedColumnName = "id")
	private User userId;

	@Column(name = "code")
	private String verificationCode;
	
    @CreationTimestamp
	@Column(name = "created_at")
	private Date created_at;

	@Column(name = "is_verified")
	private boolean is_verified;
	

	 
}
