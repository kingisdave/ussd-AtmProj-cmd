import java.util.Scanner;
public class ThirdAtm{
	static Scanner userInput = new Scanner(System.in);
	// static String[][] firstMenus = new String[5][4];

	static String[] firstMenus = {
		"User SignUp ",
		"Sign In",
		"Account Balance ",
		"Make Deposit ",
		"Transfer ",
		"Withdraw ",
		"End Transaction \n ",
	};
	static String[] userQuestions = {
		" FirstName ", " LastName ", " Email ", " Password "
	};
	static String[] userDetail = new String[5];
	static String[][] usersDetails;
	
	static int myValues;
	static double balances= 100.00;
	
	public static void firstDisplay(int startfd, int endfd, boolean logged){
		System.out.println("\n Bank/ATM app\n");

		int i= 0;
		for (int ii=startfd; ii<firstMenus.length-endfd; ii++) {
			i++;
			System.out.println("> "+i+"."+firstMenus[ii]);
			if (ii == firstMenus.length-(endfd+1)) {
				if (ii > startfd && ii < firstMenus.length-endfd) {
					System.out.println("Choose any option to start transaction \n");
					System.out.print("Your Reply> ");
					myValues = Integer.parseInt(userInput.nextLine());
					if (logged) {
						// if (myValues > startfd && myValues <= firstMenus.length-endfd ) {
						// 	// if (myValues == 1) {
						// 	// 	register();
						// 	// } else if (myValues == 2) {
						// 	// 	login();
						if(myValues == 1){
							accBalance();
						} else if (myValues == 2) {
							makeDeposit();
						} else if (myValues == 3) {
							transferMoney();
						} else if (myValues == 4) {
							withdrawMoney();
						} else if(myValues == 5){
							logOut();
						} else {
							System.out.print("Error due to Invalid input \n");
							firstDisplay(0, 5, false);
						}
					} else{
						if (myValues == 1) {
							register();
						} else if(myValues == 2) {
							login();
						} else {
							System.out.print("Error due to Invalid input \n");
							firstDisplay(0, 5, false);
						}
					}
				} else{
					System.out.print("Invalid ");
					firstDisplay(0, 5, false);
				}
			}
		}
	}
	public static void register(){
		System.out.println("Insert your details to register?> \n");
		
		for (int i=0; i<userQuestions.length; i++) {
			System.out.print(userQuestions[i] +">>> ");
			
			String myDetails = userInput.nextLine();
			if(!(myDetails.equals(""))){
				userDetail[i] = myDetails;
				
			} else {
				System.out.print(" Invalid/Empty "+ userQuestions[i]+ " \n");
				register();
			}
			if(i == userQuestions.length-1){
				System.out.print("\n Thanks for registering your details \n");
				userDetail[4] = "0.00";
				firstDisplay(0, 5, false);
			}
		}
	}
	public static void login(){
		System.out.println("Login Here\n");
		for (int i=2; i<userQuestions.length; i++) {
			System.out.print(userQuestions[i] +">> ");
			String myDetails = userInput.nextLine();
			if(!(myDetails.equals("")) && myDetails.equals(userDetail[i])){
				if(i == userQuestions.length-1){
					System.out.print("\n Welcome to your homepage \n");
					firstDisplay(2, 0, true);
				}
			} else {
				System.out.print(" Invalid "+ userQuestions[i]+ " \n");
				login();
			}
		}
	}
	public static void accBalance(){
		if(balances > 0){
			userDetail[4] = String.valueOf(balances);
		}
		System.out.println("\n Your main Account Balance is: $"+ userDetail[4]);
		firstDisplay(2, 0, true);
	}

	public static void makeDeposit(){
		System.out.println("\n Welcome to the deposit zone, Make a deposit now \n");
		System.out.print("Amount To Deposit >> $");
			String amtValues = userInput.nextLine();
			if (!(amtValues.equals("")) && Integer.parseInt(amtValues) > 0) {
				System.out.println(" Deposit to your account?   1. Yes   2. No ");
				System.out.print(" Your reply >> ");
				String userValues = userInput.nextLine();
				if (!(userValues.equals("")) && userValues.equals("1") || userValues.equals("Yes")) {
					balances += Integer.parseInt(amtValues);
					System.out.print("\n You have deposited $"+ amtValues +" to your account number with main Balance: $"+ balances+ "\n");
					System.out.println("Thank you for banking with us!!");
					System.out.println("--------------------------------------");
				} else {
					System.out.print("Beneficiaries' Account Number >> ");
					String accNumber = userInput.nextLine();
					if(!(accNumber.equals("")) && Integer.parseInt(accNumber) > 0){
						System.out.print("\n You have deposited $"+ amtValues +" to the account number "+accNumber+ " \n");
						System.out.println("Thank you for banking with us!!");
						System.out.println("--------------------------------------");
					} else {
						System.out.print("\n This is a fake Account Number");
						firstDisplay(2, 0, true);
					}
				}
				
			} else {
				System.out.print("\n Invalid Input. Make a valid input!!");
				firstDisplay(2, 0, true);
			}
		firstDisplay(2, 0, true);
	}
	public static void transferMoney(){
		System.out.println("\n Welcome to your Transfer zone. Enter the Amount to Transfer. \n");
		
		if (balances > 0) {
			System.out.print("Transfer Amount >> $");
			String amtValues = userInput.nextLine();
			if (!(amtValues.equals("")) && Integer.parseInt(amtValues) > 0) {
				if (balances > Integer.parseInt(amtValues)) {
					System.out.print("Beneficiaries' Account Number >> ");
					String accNumber = userInput.nextLine();
					if(!(accNumber.equals("")) && Integer.parseInt(accNumber) > 0){
						System.out.println("Are you sure you want to Transfer?  1. Yes   2. No");
						System.out.print(" Your reply >> ");
						String userValues = userInput.nextLine();
						if (!(userValues.equals("")) && userValues.equals("1") || userValues.equals("Yes")) {
							balances -= Integer.parseInt(amtValues);
							System.out.print("\n You have transfered $"+ amtValues +" to the account number "+accNumber+ ". Remaining $"+ balances+ "\n");
							System.out.println("Thank you for banking with us!!");
							System.out.println("--------------------------------------");
						} else {
							System.out.print("\n No more Transfer to make!!! \n");
						}
						firstDisplay(2, 0, true);
					} else {
						System.out.print("\n This is a fake Account Number");
						firstDisplay(2, 0, true);
					}
				} else {
					System.out.print("\n Your account balance is not enough!!");
					firstDisplay(2, 0, true);
				}
			} else {
				System.out.print("\n Invalid Input. Make a valid input!!");
				firstDisplay(2, 0, true);
			}
		} else {
			System.out.print("\n Your account balance is low. Make a deposit before another transaction!");
			firstDisplay(2, 0, true);
		}
	}
	public static void withdrawMoney(){
		System.out.println("\n Withdrawal made easy! Make your money withdrawal now!!!\n");
		if (balances > 0) {
			System.out.print(" Amount to Withdraw >> $");
			String amtValues = userInput.nextLine();
			if (!(amtValues.equals("")) && Integer.parseInt(amtValues) > 0) {
				if (balances > Integer.parseInt(amtValues)) {
					System.out.println("Are you ready to Withdraw in cash?  1. Yes   2. No");
					System.out.print(" Your reply >> ");
					String userValues = userInput.nextLine();
					if (!(userValues.equals("")) && userValues.equals("1") || userValues.equals("Yes")) {
						balances -= Integer.parseInt(amtValues);
						System.out.print("\n You have withdrawn $"+ amtValues +" from your account. Remaining "+ balances+ "\n");
						System.out.println("\n Thank you for banking with us!!");
						System.out.println("--------------------------------------");
						firstDisplay(2, 0, true);
					} else {
						System.out.println("\n Withdrawal of cash cancelled !!! ");
						System.out.println("Thank You for banking with us!!! \n");
						System.out.println("--------------------------------------");
						firstDisplay(2, 0, true);
					}
				} else {
					System.out.print("\n Your account balance is not enough!!");
					firstDisplay(2, 0, true);
				}
			} else {
				System.out.print("\n Invalid Input. Use a valid one!!");
				firstDisplay(2, 0, true);
			}
		} else {
			System.out.print("\n Your account balance is low. Make a deposit before another transaction!");
			firstDisplay(2, 0, true);
		}
	}
	public static void logOut(){
		System.out.println("\n Get out of here mehn");
		firstDisplay(0, 5, false);
	}
	
	
	public static void main(String[] args) {
		// System.out.println("\n Welcome to your Bank/ATM app");
		firstDisplay(0, 5, false);
		// openApp(Integer.parseInt(userInput.nextLine()));
		// menuOptions();
	}
}
