package com.vti.entity;

import java.util.Arrays;

public class News implements INews {
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	private int rate[] ;
	
	public int[] getRate() {
		return rate;
	}
	public void setRate(int[] rate) {
		this.rate = rate;
	}
	public News(String title, String publishDate, String author, String content ,int[] rate) {
		super(); 
		int count = 0;
		this.id = ++count;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.averageRate = averageRate;
		this.rate = rate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getAverageRate() {
		return averageRate;
	}
	@Override
	public void display() {
		System.out.println("News [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", author=" + author
				+ ", content=" + content + ", averageRate=" + averageRate + "]");
		
	}
	@Override
	public float Caculate() {
		averageRate = (float) ((rate[0] + rate[1] + rate[2]) /3);
		return averageRate;
	}
	
	
	
}
