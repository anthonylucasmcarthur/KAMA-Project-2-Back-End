package dev.KAMA.entities;

import java.util.HashSet;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "child")
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	private int cId;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "p_id")
	private Parent parent;
	
	@OneToMany(mappedBy = "child", fetch = FetchType.EAGER)
	private Set<Report> reports = new HashSet<Report>();
	
	@OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Showcase> showcases = new HashSet<Showcase>();
	

	public Child() {
		super();
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}

	public Set<Showcase> getShowcases() {
		return showcases;
	}

	public void setShowcases(Set<Showcase> showcases) {
		this.showcases = showcases;
	}

	@Override
	public String toString() {
		return "Child [cId=" + cId + ", fname=" + fname + ", lname=" + lname + "]";
	}

	
	
	
	
}
