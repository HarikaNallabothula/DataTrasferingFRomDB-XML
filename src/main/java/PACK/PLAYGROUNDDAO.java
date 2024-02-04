package PACK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.w3c.dom.Document;

public class PLAYGROUNDDAO {

	

	public Document getPLAYGROUNDDATA() {
		Document doc = null;

		   try
		   { Class.forName("org.postgresql.Driver");
			 Connection con=DriverManager.getConnection("jdbc:postgresql://38.242.196.35:35777/extio_db","extio_user","7Aw$S(5+7aKF0R6p");
		        ResultSet rs = con.createStatement().executeQuery("select * from playground");
		      doc = DataBaseData_to_XML.toDocument((ResultSet) rs);

		      rs.close();
		     
		   }
		   catch (Exception e)
		   {
		      e.printStackTrace();
		   }

		   return doc;
		   
		}
	
		
	}