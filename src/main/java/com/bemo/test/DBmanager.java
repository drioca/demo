package com.bemo.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "DBmanager", eager = true)
@RequestScoped
public void DBmanager (ActionEvent e){
   data="Hello World";
}
