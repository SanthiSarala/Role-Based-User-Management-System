package com.vcube.dao;

import com.vcube.model.RegisterModel;

public interface StudentInterface {
	public void insertStudent();
	public RegisterModel validateUser(String username, String password, String role) ;
	     
	
}
        
    