package PACK;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

@WebServlet("/DataBaseData_To_XM")
public class DataBaseData_to_XML extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Document toDocument(ResultSet rs)  throws ParserConfigurationException, SQLException{
		 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		   DocumentBuilder builder        = factory.newDocumentBuilder();
		   Document doc                   = builder.newDocument();

		   Element results = doc.createElement("Results");
		   doc.appendChild(results);

		   ResultSetMetaData rsmd = rs.getMetaData();
		   int colCount           = rsmd.getColumnCount();

		   while (rs.next())
		   {
		      Element row = doc.createElement("Row");
		      results.appendChild(row);

		      for (int i = 1; i <= colCount; i++)
		      {
		         String columnName = rsmd.getColumnName(i);
		         Object value      = rs.getObject(i);

		         Element node      = doc.createElement(columnName);
		         node.appendChild(doc.createTextNode(value.toString()));
		         row.appendChild(node);
		      }
		   }
		   return doc;
		}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();	
		PLAYGROUNDDAO dao = new PLAYGROUNDDAO();
		Document doc    = dao.getPLAYGROUNDDATA();
		  //out.println(DataBaseData_to_XML.serialize(doc));
		   out.println(DataBaseData_to_XML.class);
	}

}
