package com.vtalent.insurance.model;

public class Year {
	private int y_id;
	private String year;
	
    public Year() {
		super();
	}
	public Year(int y_id, String year) {
		super();
		this.y_id = y_id;
		this.year = year;
	}
	public int getY_id() {
		return y_id;
	}
	public void setY_id(int y_id) {
		this.y_id = y_id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	

}
