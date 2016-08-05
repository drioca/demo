package com.bemo.test;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
//DB
   import java.net.URI;
    import java.net.URISyntaxException;
    import java.sql

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
        
      String iNs = "INSERT INTO test (age) VALUES (" + Integer.toString(UserData.age) +");";

        try {
            Connection con = getConnection( ); 
            Statement stmt = con.createStatement();
        stmt.executeUpdate(iNs);
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
   
      public String aVerege () {
        
      

        try {
            Connection con = getConnection( ); 
            Statement stmt = con.createStatement();
            
       ResultSet rs = stmt.executeQuery("SELECT AVG(age) FROM test");
       
        stmt.executeUpdate("commit;");
         con.close();
         return rs.toString();
        }

     
         catch (Exception e) {
       
           // Check first if an InnerException exists
                if (e != null)
                   UserData.dbemanerrormsg = e.toString();
      } finally {
       //try{con.close();} catch(SQLException e){};
      }
   }
 
   }

   

