package w2;
import java.util.Scanner;

public class TaxMain {

	public static int[][] range2001= {{27050, 65550,136750,297350 }, {45200, 109250, 166500 ,297350},
            {22600, 54625 , 832650, 148675},{36250, 93650, 151650, 297350}} ;
	
	public static int[][] range2009= {{8350, 33950 , 82250, 171550, 372950}, {16700, 67900, 137050, 208850 ,372950},
	{8350 , 33950 , 68525 , 104425 ,186475 } , {11950 , 45500, 117450 , 190200 , 372950}};
	
	public static double taxRate2001[]= {15 , 27.5 , 30.5 , 35.5 ,39.1};
	public static double taxRate2009[]= {10, 15 ,25 , 28 , 33 , 35};
		
	public static void main(String[] args) {
		
		
		int option=4;
		while(option !=0 )
		{
			menu();
			Scanner input = new Scanner(System.in);
			option=input.nextInt();
			switch(option) {
			  case 0:
				  System.out.println("hope see u soon");
			    break;
			  case 1:
				  personalIncomeTax();
				  
			    break;
			  case 2:
				  printTax();
				  break;
			  default:
			    // code block
			}
			
		}
		

	}
	
	public static void menu()
	{
		System.out.println("Please choose one of below options");
		System.out.println("Compute personal income Tax (1)");
		System.out.println("Print the tax tables for taxable incomes (2)");
		System.out.println("Exit(0)");
		System.out.print(" option : ");
	}
	
	public static void personalIncomeTax(){
		System.out.println("0 - single filer");
		System.out.println("1 - married jointly or qualifying widow(er)");
		System.out.println("2 - married separately");
		System.out.println("3 - head of household)");
		System.out.print("Enter the filing status: ");
		Scanner input = new Scanner(System.in);
		int filingStatus= input.nextInt();
		while (filingStatus<0 || filingStatus>3 )
		{
			System.out.println("filing status is invalid");
			System.out.print("Enter the filing status: ");
			filingStatus= input.nextInt();
		}
		System.out.print("Enter the Taxable Income :$");
		double income = input.nextDouble();
		Tax tax= new Tax(filingStatus,range2009 ,taxRate2009 ,income);
		System.out.println("Tax is: $"+ tax.getTax() +"\n\n");
	}
	
	public static void printTax(){
		
		System.out.print("Enter the amount from: $");
		Scanner input = new Scanner(System.in);
		double start= input.nextDouble();
		System.out.print("Enter the amount from: $");
		double end= input.nextDouble();
		double temp=start;
		/*while (temp < end)
		{
			int j =0 ;
			Tax[] Tax0;
			Tax[] Tax1;
			Tax[] Tax2;
			Tax[] Tax3;
			Tax0[j] = new Tax(0 ,range2009,taxRate2009, temp );
			Tax1[j] = new Tax(1 ,range2009,taxRate2009, temp );
			Tax2[j] = new Tax(2 ,range2009,taxRate2009, temp );
			Tax3[j] = new Tax(0 ,range2009,taxRate2009, temp );
			
			j++;
			temp+=1000; 
			Tax tax= new Tax(filingStatus,range2009 ,taxRate2009 ,income);
			System.out.println("Tax is: $"+ tax.getTax() +"\n\n");	
			
		}*/
		
		System.out.println("2001 tax tables for taxable income from $"+ start + " to $" + end);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("TaxableIncome\tSingle  Married Joint \t Married Seperate Head of House" );
		System.out.println("-----------------------------------------------------------------");
		
		for (double i = start;  i <= end ; i+=1000)
		{
			
			System.out.print(i + "\t\t");
			for(int j = 0; j < 4; j++) {
				Tax tax= new Tax(j,range2009 ,taxRate2009 ,i);
				System.out.print( tax.getTax() +"\t\t");	
			}
			System.out.println();
		}
		
	}
	
}
