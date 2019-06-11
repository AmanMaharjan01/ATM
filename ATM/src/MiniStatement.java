import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MiniStatement {
  public void statement() throws Exception
  {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter your Account number:");
	   int AN=sc.nextInt();
	    Document document=new Document();
		PdfWriter.getInstance(document, new FileOutputStream("D:\\made pdf\\Transaction8.pdf"));
		document.open();
		document.add(new Paragraph("Date:"+new Date().toString()));
		Image image= Image.getInstance("D:\\made pdf\\55.jpg");
		document.add(new Paragraph (" "));
		document.add(image);
		document.add(new Paragraph("------------------------------BANK STATEMENT-------------------------",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.YELLOW)));
		document.add(new Paragraph("_____________________________________________________________________________"));
		document.add(new Paragraph("Customers Account Number: "+AN+""));
		document.add(new Paragraph(" "));
		PdfPTable table=new PdfPTable(3);
		table.addCell("Transaction Type");
		table.addCell("Amount");
		table.addCell("Date");
	
		
		int amount,i=0;
		System.out.println("----------------------------------------------------------------------------------");
		Connection con= new Connector().getConnection();
		Statement st=con.createStatement();
		//String q="select Total_Amount from deposit where Account_Number="+AN+"";
		String query="select * from ministatement where Account_Number="+AN+"";
		ResultSet rs=st.executeQuery(query);
		
			while(rs.next() && i<=5)
			{
				System.out.println("---------------------------------------------------"); 
			if(rs.getInt("Deposit")==0)
			{
			
				amount=rs.getInt("With_Draw");
				table.addCell(amount+"");
				System.out.println("Transaction type:"+"withdraw");
				table.addCell("withdraw");
			}
			else
			{		
				amount=rs.getInt("Deposit");
				table.addCell(amount+"");
				System.out.println("Transaction type:"+"Deposit");
				table.addCell("Deposit");
			}
				System.out.println("Amount:"+ amount);
			//System.out.println(rs.getDate(5));
		System.out.println(rs.getTimestamp("Time"));
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(rs.getTimestamp("Time"));
		table.addCell(timeStamp);
		}
			rs.close();
			String query1="select * from deposit where Account_Number="+AN+" ";
			ResultSet rs1=st.executeQuery(query1);
			rs1.next();
			//query=rs1.getInt(6)+"";
			//document.add(new Paragraph("Your Total Balance:"+rs1.getInt("q")));
			document.add(new Paragraph(""));
			document.add(new Paragraph("-------------------------------------------------------------------------"));
			document.add(new Paragraph("Following are your lastest Transaction:-"));
			document.add(new Paragraph(""));
			System.out.println("---------------------------------------------------------------------------------");
			document.add(new Paragraph(" "));
			document.add(table);
			Image image1= Image.getInstance("D:\\made pdf\\6.png");
			document.add(new Paragraph (" "));
			document.add(image1);
			//document.add(table);
			document.close();
	

	}
}



