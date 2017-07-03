package com.bemo.appl;

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
	private long key_column;
	private String ctimestamp;
	private String ctimestampt;

	
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
	
	public long getKey_column() {
	return key_column;
	}
	public void setKey_column(long key_column) {
	this.key_column = key_column;
	}

  	public String getCtimestamp() {
	return ctimestamp;
	}
  	public void setCtimestamp(String ctimestamp) {
	this.ctimestamp = ctimestamp;
	} 
	public String getCtimestampt() {
	return ctimestampt;
	}
  	public void setCtimestampt(String ctimestampt) {
	this.ctimestampt = ctimestampt;
	} 
  public static String dbemanerrormsg;
	public String getdbemanerrormsg() {
      	return dbemanerrormsg;
   	}
  public void setdbemanerrormsg(String dbemanerrormsg) {
      	this.dbemanerrormsg = dbemanerrormsg;
	}
	
  public static String dbemanerrormsg2;
   	public String getdbemanerrormsg2() {
      	return dbemanerrormsg2;
   	}
  public void setdbemanerrormsg2(String dbemanerrormsg2) {
      	this.dbemanerrormsg2 = dbemanerrormsg2;
	}

//aVg
  private static String avg;
   	public String getAverage() {
      	return avg;
   	}
  public static void setAverage(String newavg) {
      	avg = newavg.subString(0,4);
	}

}
