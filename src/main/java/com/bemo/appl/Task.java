package com.bemo.test;
import java.util.Date;

public class Task {
   private String responsible;
   private String name;
   private int fee;
   private Date deadline;
   private boolean canEdit;

   public Task (String name,String responsible,int fee,Date deadline){
      this.name = name;
      this.responsible = responsible;
      this.fee = fee;
      this.deadline = deadline;
      canEdit = false;
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

   public boolean isCanEdit() {
      return canEdit;
   }

   public void setCanEdit(boolean canEdit) {
      this.canEdit = canEdit;
   }	
}
