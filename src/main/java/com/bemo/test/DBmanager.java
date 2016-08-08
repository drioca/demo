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
    import java.sql.Connection;
    import java.sql.Statement;
    import java.sql.ResultSet;
    import java.sql.DriverManager;
    import java.sql.SQLException;

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
            Statement stmtc = con.createStatement();
            stmtc.executeUpdate("CREATE TABLE IF NOT EXISTS public.test (key_column bigserial NOT NULL DEFAULT nextval('test_key_column_seq'::regclass),
	age numeric(131089,0),"timestamp" timestamptz,ctimestamp timestamptz DEFAULT now(),CONSTRAINT test_pkey PRIMARY KEY (key_column)
);
CREATE UNIQUE INDEX test_pkey ON public.test (key_column);");
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
   
      public void aVerage () {
          float iaVg = 0f;
        ResultSet rs;
        try {
            Connection con = getConnection( ); 
            Statement stmt = con.createStatement();
            
            rs = stmt.executeQuery("SELECT AVG(age) FROM test"); 
if(rs.next())
      iaVg = rs.getFloat(1);
       UserData.aVg = Float.toString(iaVg);
        stmt.executeUpdate("commit;");
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
 
   }

   

