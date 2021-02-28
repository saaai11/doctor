package appointment.doctor.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fullcheckups")
public class FullCheckup {
	
	@Id
	@Column(name = "checkupid")
	private String checkupId; 
	
	@Column(name = "userid")
	private String userId;
	
	@Column(name = "date")
	private Date date; 
	
	@Column(name = "time")
	private Time time;
	
    @Column(name = "status")
    private boolean status;
    
    @Column(name = "ckeckuptype")
	private String ckeckupType;
    
    

	public String getCheckupId() {
		return checkupId;
	}

	public void setCheckupId(String checkupId) {
		this.checkupId = checkupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	} 
	
	

}
