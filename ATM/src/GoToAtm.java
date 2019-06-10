import java.util.Scanner;

public class GoToAtm {
public void GotoAtm() throws Exception
{   
	System.out.println();
	System.out.println("------>>>ATM<<-------");
	System.out.println(" 1)Account Information\n 2)Withdraw\n 3)BalanceEnquiry\n 4)Bank Statement\n 5)Exit");
	System.out.println("Enter Option: ");
	Scanner sc=new Scanner(System.in);
	int option2= sc.nextInt();
	switch(option2)
	{
	case 1:
		ShowInformation SI=new ShowInformation();
		SI.Info2();
		break;
	case 2:
		Withdraw W=new Withdraw();
		W.WD();
		break;
	case 3:
		BalanceEnquiry BE=new BalanceEnquiry();
		BE.balance();
		break;
	case 4:
		MiniStatement MS=new MiniStatement();
		MS.statement();
		break;
	case 5:
		System.exit(0);
	}
}
}
