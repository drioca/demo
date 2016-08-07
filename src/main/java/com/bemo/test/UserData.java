package com.bemo.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {

private static final long serialVersionUID = 1L;

	private String responsible;
	private String name;
	private int fee;
	private Date deadline; 
	

	
   private static final ArrayList<Task> tasks 
   = new ArrayList<Task>(Arrays.asList(       
   		new Task("Marketing", "Peter", 30,new java.util.Date(System.currentTimeMillis())),
      	new Task("Marketing", "Pan", 35,new java.util.Date(System.currentTimeMillis()))
      
   ));


   public ArrayList<Task> getTasks() {
      return tasks;
   }

   public String addTask() {		 
      Task task = new Task(responsible,name,fee,deadline);
      tasks.add(task);
      return null;
   }

   public String deleteTask(Task task) {
      tasks.remove(task);		
      return null;
   }

   public String editTask(Task task){
      task.setCanEdit(true);
      return null;
   }

   public String saveTasks(){
      //set "canEdit" of all tasks to false 
      for (Task task : tasks){
         task.setCanEdit(false);
      }		
      return null;
   }
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getResponsible() {
      return responsible;
   }

   public void setResponsible(String responsible) {
      this.responsible = responsible;
   }

   public int getFee() {
      return fee;
   }

   public void setFee(int fee) {
      this.fee = fee;
   }

   public Date getDeadline() {
      return deadline;
   }

   public void setDeadline(Date deadline) {
      this.deadline = deadline;
   }
   
   public static int age;
  
   public int getAge() {
      return age;
   	}
   public void setAge(int age) {
      this.age = age;
	}
public static String dbemanerrormsg;
   public String getdbemanerrormsg() {
      return dbemanerrormsg;
   	}
   public void setdbemanerrormsg(String dbemanerrormsg) {
      this.dbemanerrormsg = dbemanerrormsg;
	}
	
	public static String dbemanerrormsg2;
   public String getdbemanerrormsg() {
      return dbemanerrormsg;
   	}
   public void setdbemanerrormsg2(String dbemanerrormsg2) {
      this.dbemanerrormsg2 = dbemanerrormsg2;
	}

//aVg
public static String aVg;
   public String getaVg() {
      return aVg;
   	}
   public void setaVg(String aVg) {
      this.aVg = aVg;
	}

}
