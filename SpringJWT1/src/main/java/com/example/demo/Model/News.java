package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="news_id")
	private Long newsId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="short_desc")
	private String shortDescription;
	
	@Column(name="long_desc")
	private String longDescription;

	public News() {
		super();
	}

	public News( String title, String shortDescription, String longDescription) {
		super();
		this.title = title;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	
}
