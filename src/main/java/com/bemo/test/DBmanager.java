package com.bemo.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "DBmanager", eager = true)
@SessionScoped
public class DBmanager implements Serializable {

private static final long serialVersionUID = 1L;

   private String data = "sample data";
	
   public String showResult(){
      return "result";
   }

   public void updateData(ActionEvent e){
      data="Hello World";
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }
}
