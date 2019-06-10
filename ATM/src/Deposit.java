
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Deposit {
 public void amount() throws Exception
 {
		Scanner sc=new Scanner(System.in);
		Connection con= new Connector().getConnection();
		Statement st=con.createStatement();
		System.out.println("Enter You Account number:");
		int AN=sc.nextInt();
		String query="select * from deposit where Account_Number="+AN+"";
		ResultSet rs=st.executeQuery(query);
		if(rs.next())
		{
		System.out.println("Enter the balance to deposit:");
		int bal=sc.nextInt();
		String query1="insert into ministatement (account_no,deposit)values("+AN+","+bal+")";
		bal+=rs.getInt("Total_Amount");
		query="update deposit set Total_Amount="+bal+" where Account_Number="+AN+";"; 
		st.execute(query);
		st.execute(query1);
		System.out.println("--->>>Successfully Deposited<<<---");
		}
		else
			System.out.println("<<<----Invalid Account---->>>");


}
}
