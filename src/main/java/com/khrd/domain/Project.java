package com.khrd.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Project {
	private int no;
	private String title;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end_date;
	private String state;
		
	public Project() {

	}

	public Project(int no, String title, String content, Date start_date, Date end_date, String state) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.start_date = start_date;
		this.end_date = end_date;
		this.state = state;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Project [no=" + no + ", title=" + title + ", content=" + content + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", state=" + state + ", getNo()=" + getNo() + ", getTitle()=" + getTitle()
				+ ", getContent()=" + getContent() + ", getStart_date()=" + getStart_date() + ", getEnd_date()="
				+ getEnd_date() + ", getState()=" + getState() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
