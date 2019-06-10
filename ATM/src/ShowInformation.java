import java.sql.Connection;
import java.util.Scanner; 
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowInformation {
	public void Info2() throws Exception
	{
		Scanner sc= new Scanner(System.in);
		Connection con= new Connector().getConnection();
		Statement st=con.createStatement();
		System.out.println("Enter  account number:");
		int AN=sc.nextInt();
		String query="select * from account where Account_Number="+AN+"";
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String Accinfo="\nName : "+rs.getString("First_Name")+" "+rs.getString("Last_Name")+" \nAddress: "+rs.getString("Address")+" \nPhone Number:  "+rs.getInt("Phone_Number"); 
		System.out.println(Accinfo);
	}

}
