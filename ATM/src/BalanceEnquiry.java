import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BalanceEnquiry {
public void balance() throws Exception
{

	Scanner sc=new Scanner(System.in);
	Connection con= new Connector().getConnection();
	Statement st=con.createStatement();
	System.out.println("Enter You Account number:");
	int AN=sc.nextInt();
	String query="select Total_Amount from deposit where Account_Number="+AN+"";
	ResultSet rs=st.executeQuery(query);
	rs.next();
	int result=rs.getInt("Total_Amount");
	System.out.println("Available Balance:");
	System.out.println(result);
}
}
