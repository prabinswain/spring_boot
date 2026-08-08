package com.generics;

public class User {

	long number;
	String name;
	String mail;
	
	public User(long l, String string, String string2) {
		this.number = l;
		this.name= string;
		this.mail = string2;
	}

    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) number;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (mail == null ? 0 : mail.hashCode());
        System.out.println("inside hashcode method");
        return hash;
    }
    
}
