package com.bemo.test;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {

   private static final long serialVersionUID = 1L;

   @ManagedProperty(value="#{param.pageId}")
   private String pageId;
//-------------------------------------------------------
   public String moveToPage1(){
      return "page1";
   }
   public String moveToDatatablepage(){
      return "datatablepage";
   }
   public String moveToLoginpage(){
      return "loginpage";
   }
   public String moveToHomePage(){
      return "home";
   }
//-------------------------------------------------------
   
   public String processPage1(){
      return "page";
   }
   public String processDatatablepage(){
      return "page";
   }
   public String processLoginpage(){
      return "page";
   }   
//-------------------------------------------------------
   


}
