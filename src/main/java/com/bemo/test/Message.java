package com.bemo.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "message", eager = true)
@RequestScoped
public class Message {
	
	private String message = "Hello World! in Message.Message.java";
	
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}