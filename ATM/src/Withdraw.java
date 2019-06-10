import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Withdraw {
	public void WD() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Connection con= new Connector().getConnection();
		Statement st=con.createStatement();
		System.out.println("Enter Your Account Number:");
		int AN=sc.nextInt();
		System.out.println("Enter Your Pin Number");
		int Pin=sc.nextInt();
		String query="select * from deposit where Pin_Number="+Pin+"";
		ResultSet rs=st.executeQuery(query);
		if(rs.next())
		{
		System.out.println("Available Balance:");
		System.out.println(rs.getInt("Total_Amount"));
		System.out.println("Enter the amount to withdraw:");
		int W=sc.nextInt();
		if(rs.getInt("Total_Amount")>=W)
		{
		int Amount=rs.getInt("Total_Amount")-W;
		String query1="Update deposit set With_Draw="+W+" where Pin_Number="+Pin+"";
		String query2="update deposit set Total_Amount="+Amount+" where Pin_Number="+Pin+"";
		String query3="insert into ministatement (account_no,withdraw)values('"+AN+"','"+W+"')";
        st.executeUpdate(query1);
        st.executeUpdate(query2);
        st.executeUpdate(query3);
        System.out.println("---->>>Successfully Withdrawn the Money<<<-----");
		}
		else
		{
			System.out.println("--->>>Not enough Balance<<<---");
		}
		}
		else
		{
			System.out.println("--->>Wrong Pin Number<<---");
		}
		}
}
	