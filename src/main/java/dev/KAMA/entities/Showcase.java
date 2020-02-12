package dev.KAMA.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "showcase")
public class Showcase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cw_id")
	private int cwId;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "upload_date")
	private long date = System.currentTimeMillis();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_id")
	@JsonManagedReference
	private Child child;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_id")
	@JsonManagedReference
	private Teacher teacher;

	public Showcase() {
		super();
	}

	public int getCwId() {
		return cwId;
	}

	public void setCwId(int cwId) {
		this.cwId = cwId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Showcase [cwId=" + cwId + ", link=" + link + ", comment=" + comment + ", date=" + date + "]";
	}

}
