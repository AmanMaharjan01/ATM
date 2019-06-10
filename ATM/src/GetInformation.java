
import java.util.Scanner; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class GetInformation {
	public void Info1() throws Exception
	{
	  //try
	   //{
		Scanner inp= new Scanner(System.in);
		Connection con= new Connector().getConnection();
		Statement st=con.createStatement();
		System.out.println("Enter Account Number:");
		int AN=inp.nextInt();
		System.out.println("Enter First Name:");
		String FName=inp.next();
		System.out.println("Enter Last Name");
		String LName=inp.next();
	    System.out.println("Enter Contact Number:");
		long Contact=inp.nextLong();
		System.out.println("Enter Address:");
	    String Address=inp.next();
	    System.out.println("Enter Pin Number:");
	    int Pin=inp.nextInt();
	    String query="insert into account (Account_Number,First_Name,Last_Name,Address,Phone_Number,Pin_Number)values("+AN+",'"+FName+"','"+LName+"','"+Address+"','"+Contact+"','"+Pin+"')";
	    String query2="insert into deposit (Account_Number,Pin_Number)values("+AN+","+Pin+")";
	    st.executeUpdate(query);
		st.executeUpdate(query2);
		System.out.println("--->>>You have created account sucessfully<<<---");
		}
		//catch(Exception e)
		//{
			//System.out.println("--->>>Account Number is Already in Use<<<----");
		//}
		
}
//}

