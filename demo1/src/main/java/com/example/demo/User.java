package com.example.demo;

public class User {
    String name;
    String sele;
    public String getSele() {
		return sele;
	}
	public void setSele(String sele) {
		this.sele = sele;
	}
	String[] MyColors;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
    
    public String[] getMyColors() {
        return MyColors;
    }
    public void setMyColors(String[] myColors) {
        MyColors = myColors;
    }
}