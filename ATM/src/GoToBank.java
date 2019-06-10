import java.util.Scanner;

public class GoToBank {
 public void GotoBank() throws Exception
{
	System.out.println();
	System.out.println("-------->>>Welcome To Our Bank<<<-------");
	System.out.println(" 1)Create Account\n 2)Deposit\n 3)Exit");
	System.out.println("Enter Option: ");
	Scanner sc=new Scanner(System.in);
	int option1= sc.nextInt();
	switch(option1)
	{
	case 1:
		GetInformation GI= new GetInformation();
		GI.Info1();
		break;
	case 2:
		Deposit D=new Deposit();
		D.amount();
		break;
	case 3:
		System.exit(0);
	}
}
}
