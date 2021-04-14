package com.corin.dogHotel.join;

public class Pet {
   
	private String name;
    private String gender;
    private String type;
    
    public Pet(String name, String gender, String type) {
		super();
		this.name = name;
		this.gender = gender;
		this.type = type;
	}
	public Pet() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
