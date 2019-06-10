import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

public class ChangePin {
	public void CP() throws Exception
	{
	Scanner sc= new Scanner(System.in);
	Connection con= new Connector().getConnection();
	Statement st=con.createStatement();
	System.out.println("Enter  account number:");
	int AN=sc.nextInt();
	System.out.println("Change My Pin into:");
	int Pin=sc.nextInt();
	String query="Update deposit set Pin_Number="+Pin+" where Account_Number="+AN+"";
	String query1="Update account set Pin_Number="+Pin+" where Account_Number="+AN+"";
	st.executeUpdate(query);
	st.executeUpdate(query1);	
	}

}
