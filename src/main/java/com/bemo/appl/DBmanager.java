package com.bemo.appl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
//DB
   import java.net.URI;
   import java.net.URISyntaxException;
   import java.sql.Connection;
   import java.sql.Statement;
   import java.sql.ResultSet;
   import java.sql.DriverManager;
   import java.sql.SQLException;
   import java.sql.PreparedStatement;

   import java.util.ArrayList;
   import java.util.List;
   import java.io.Serializable;
   import java.util.Date;
   import java.sql.Timestamp;
   

@ManagedBean(name = "DBmanager", eager = true)
@SessionScoped
public class DBmanager implements Serializable {

private static final long serialVersionUID = 1L;
public static void main (){ }

private static Connection getConnection() throws URISyntaxException, SQLException {
    String dbUrl = System.getenv("JDBC_DATABASE_URL");
    return DriverManager.getConnection(dbUrl);
    
    
   }
   

   public void insert () {
        
      String ins = "INSERT INTO test (age) VALUES (" + Integer.toString(UserData.age) +");";

        try {
            Connection con = getConnection( ); 
            Statement stmtc = con.createStatement();
            stmtc.executeUpdate("CREATE TABLE IF NOT EXISTS public.test (key_column bigserial NOT NULL, age numeric(4,0), ctimestamp timestamptz DEFAULT now(), CONSTRAINT test_pkey PRIMARY KEY (key_column) );");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(ins);
            stmt.executeUpdate("commit;");
            con.close();
        }

     
         catch (Exception e) {
       
           // Check first if an InnerException exists
                if (e != null)
                   UserData.dbemanerrormsg = e.toString();
      } finally {
       //try{con.close();} catch(SQLException e){};
      }
   }
   
      public static void average () {
         
           try {
            Connection con = getConnection( ); 
            Statement stmt = con.createStatement();
            ResultSet rs = null;
              rs = stmt.executeQuery("SELECT AVG(age) FROM test");
       
       UserData.setAverage(rs.toString);
        
         con.close();
       
         
        }

     
         catch (Exception e) {
       
           // Check first if an InnerException exists
                if (e != null)
                   UserData.dbemanerrormsg2 = e.toString();
      } finally {
       //try{con.close();} catch(SQLException e){};
      }
      
   }

// to list
 public List<Record> getRecordList()
{
List<Record> list = new ArrayList<Record>();
PreparedStatement ps = null;
//Connection con = null;
ResultSet rs = null;
try
{
Connection con = getConnection(); 
String sql = "select * from public.test order by ctimestamp";
ps= con.prepareStatement(sql); 
rs= ps.executeQuery(); 
while (rs.next())
{
Record record = new Record();
record.setKey_column(rs.getLong("key_column"));
record.setAge(rs.getInt("age"));
//String cts = (rs.getString("ctimestamp"));
record.setCtimestamp(rs.getString("ctimestamp").substring( 0, 19));
list.add(record);
} 
con.close();
}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
try
{
//con.close();
ps.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
return list;
}
//end list
 
   }

   

