package dev.KAMA.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "t_id")
	private int tId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;

	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
	private Set<Report> reports = new HashSet<Report>();
	
//	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
//	private Set<Showcase> showcases = new HashSet<Showcase>();
	
	public Teacher() {
		super();
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Set<Report> getReports() {
		return reports;
	}

//	public Set<Showcase> getShowcases() {
//		return showcases;
//	}
//
//	public void setShowcases(Set<Showcase> showcases) {
//		this.showcases = showcases;
//	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", username=" + username + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + "]";
	}

	

	
	
}
