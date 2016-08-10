package com.bemo.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;

@ManagedBean(name="records")
@RequestScoped
public class Record {

private long key_column;
private int age;
private Date ctimestamp;
public long getKey_column() {
return key_column;
}
public void setKey_column(long key_column) {
this.key_column = key_column;
}
public int getAge() {
return age;}

public void setAge(int age) {
this.age = age;
}
public Date getCtimestamp() {
return ctimestamp;
}
public void setCtimestamp(Date ctimestamp) {
this.ctimestamp = ctimestamp;
} 
}