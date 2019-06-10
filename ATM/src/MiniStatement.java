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
  public void statement()
  {
	    Document document=new Document();
		PdfWriter.getInstance(document, new FileOutputStream("D:/Transaction.pdf"));
		document.open();
		document.add(new Paragraph("Date:"+new Date().toString()));
		document.add(new Paragraph("BANK STATEMENT",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.RED)));
		document.add(new Paragraph("_____________________________________________________________________________"));
		document.add(new Paragraph("Account Number: "+AN+""));
		document.add(new Paragraph(" "));
		PdfPTable table=new PdfPTable(3);
		table.addCell("Transaction Type");
		table.addCell("Amount");
		table.addCell("Date");
	
		
		int amount,i=0;
		System.out.println("----------------------------------------------------------------------------------");
		Connection con= new Connector().getConnection();
		Statement st=con.createStatement();
		String query="select * from ministatement where account_no="+AN+" order by sn desc";
		ResultSet rs=st.executeQuery(query);
		
			while(rs.next() && i<=5)
			{
				System.out.println("---------------------------------------------------");
			System.out.println("Transaction type:"+rs.getString(6)); 
			table.addCell(rs.getString(6));
			if(rs.getInt(3)==0)
			{
			
				amount=rs.getInt(4);
				table.addCell(amount+"");
			}
			else
			{		
				amount=rs.getInt(3);
				table.addCell(amount+"");
			}
				System.out.println("Amount:"+ amount);
			//System.out.println(rs.getDate(5));
		System.out.println(rs.getTimestamp(5));
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(rs.getTimestamp(5));
		table.addCell(timeStamp);
		}
			rs.close();
			String query1="select * from costumer where Account_Number="+AN+" ";
			ResultSet rs1=st.executeQuery(query1);
			rs1.next();
			query=rs1.getInt(6)+"";
			document.add(new Paragraph("Main Balance:"+query));
			document.add(new Paragraph("Sent by:AMan Bank Pvt.Ltd"));
			
			System.out.println("---------------------------------------------------------------------------------");
			document.add(new Paragraph(" "));
			document.add(table);
			document.close();
	

	}



	



}
  }
}
