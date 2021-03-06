package org.springframework.data.demo.data;

import com.mysema.query.annotations.QueryEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@QueryEntity
public class UserInfo {
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date dateOfBirth;

	private String emailAddress;

	@NotNull
	private String fullName;

	// Using a string id for use in both MongoDB and JPA.
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotNull
	@Column(unique = true)
	@Indexed(unique = true)
	private String userId;


    public UserInfo() {
		super();
	}

	public UserInfo(String userId, String fullName) {
		super();
		this.userId = userId;
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public String getFullName() {
		return this.fullName;
	}

	public String getId() {
		return this.id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfo{");
        sb.append("dateOfBirth=").append(dateOfBirth);
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
