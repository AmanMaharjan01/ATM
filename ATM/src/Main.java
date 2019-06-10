import java.util.Scanner; 

public class Main {
	
  public static void main(String args[]) throws Exception
  {
	  while(true)
	  {
	  System.out.println("\n\nOptions:-");
	  System.out.println(" 1)Go To Bank\n 2)Go To ATM\n 3)Exit");
	  System.out.println("Note:- Choose option as 1,2 or 3");
	  Scanner sc= new Scanner(System.in);
	  System.out.println("Enter your choice:\n");
	  int option = sc.nextInt();
	  switch(option)
	  {
	  case 1:
	  {
		  GoToBank GB= new GoToBank();
		  GB.GotoBank();
		  break;
	  }
	  case 2:
	  {
		  GoToAtm GA= new GoToAtm();
		  GA.GotoAtm();
		  break;
	  }
	  case 3:
	  {
		  System.exit(0);
	  }
	  }
	  }
	  
	
}

}
