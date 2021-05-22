import java.util.Scanner;
public class ThirdAtm{
	static Scanner userInput = new Scanner(System.in);
	// static String[][] firstMenus = new String[5][4];

	static String[] firstMenus = {
		"\n>  1.User SignUp ",
		">  2.Sign In",
		">  3.Account Balance ",
		">  4.Transfer ",
		">  5.Withdraw ",
		">  6.End Transaction \n ",
	};
	static String[] userQuestions = {
		" FirstName ", " LastName ", " Email ", " Password "
	};
	static String[] userDetail = new String[5];
	static String[][] usersDetails;
	
	static int myValues;
	static double[] balances= {0.00}; 
	
	public static void firstDisplay(){
		System.out.println("\n Welcome to your Bank/ATM app");
		// for (String menus : firstMenus) {
		// 	System.out.println(menus);
		// }
		for (int ii=0; ii<firstMenus.length-4; ii++) {
			System.out.println(firstMenus[ii]);
			if (ii == firstMenus.length-5) {
				if (ii > 0 && ii < firstMenus.length-4) {
					System.out.println("Choose any option to start transaction \n");
					System.out.print("Your Reply> ");
					myValues = Integer.parseInt(userInput.nextLine());
					if (myValues > 0 && myValues <= firstMenus.length ) {
						
						}if (myValues == 1) {
							register();
						} else if (myValues == 2) {
							login();
						} else if(myValues == 3){
							accBalance();
						} else if (myValues == 4) {
							transferMoney();
						} else if (myValues == 5) {
							withdrawMoney();
						} else {
							endTransaction();
						}
					} else {
						System.out.print("Error due to Invalid input \n");
						firstDisplay();
					}
				} else{
					System.out.print("Invalid ");
					firstDisplay();
				}
			}
		}
	}
	public static void register(){
		System.out.println("Insert your details to register?> \n");
		
		for (int i=0; i<userQuestions.length; i++) {
			System.out.print(userQuestions[i] +">>> ");
			// System.out.print("Your Reply>>");
			String myDetails = userInput.nextLine();
			if(!(myDetails.equals(""))){
				userDetail[i] = myDetails;
			} else {
				System.out.print(" Invalid/Empty "+ userQuestions[i]+ " \n");
				register();
			}
			if(i == userQuestions.length-1){
				userDetail[i] = "0.00";
				System.out.print("\n Thanks for rgistering your details \n");
				firstDisplay();
			}
		}
		// 	studentInfo[i][4] = "0";

		// 	String fullname = studentInfo[i][0] + " "+ studentInfo[i][1];
		// 	System.out.println("fullname: "+ studentInfo[i][0] + " "+ studentInfo[i][1]);
				
		// 	if( i+1 == studentInfo.length ){
		// 		System.out.println("Thanks to all Students for supplying their details");
		// 		System.out.println("\n > 1: Enter 1 to continue to write the test: ");
		// 		System.out.println("> 2: Enter 2 to re-register your students: ");
		// 		optionChosen = userInput.nextLine();
		// 		if (Integer.parseInt(optionChosen) > 0 && Integer.parseInt(optionChosen) < 3) {
		// 			if(Integer.parseInt(optionChosen) == 1){
		// 				System.out.println("\n!!!CBT TEST ARENA!!!\n");
		// 				writeTest();
		// 			}else{
		// 				System.out.println("\n!!!REGISTRATION ZONE!!!\n");
		// 				register();
		// 			}				
		// 		} else {
		// 			System.out.println("\nInvalid Reply. CLOSING!!!\n");
		// 			openApp();
		// 		}
		// 	}else {
		// 		System.out.println("Thanks for registering your details!!! "+ fullname + ", Click enter for next student");
		// 	}
		// 	userInput.nextLine();
		// }
	}
	public static void login(){
		System.out.println("Login Here\n");
		for (int i=2; i<userQuestions.length; i++) {
			System.out.print(userQuestions[i] +">> ");
			String myDetails = userInput.nextLine();
			if(!(myDetails.equals("")) && myDetails.equals(userDetail[i])){
				System.out.print(" Correct!!! Proceed\n");
			} else {
				System.out.print(" Invalid "+ userQuestions[i]+ " \n");
				login();
			}
			if(i == userQuestions.length-1){
				System.out.print("\n Welcome to your Homepage!!! \n");
				firstDisplay();
			}
		}
	}
	public static void accBalance(){
		System.out.println("check your account balance oo e");
	}
	public static void transferMoney(){
		System.out.println("you gas transfer money to the person oo");
	}
	public static void withdrawMoney(){
		System.out.println("now it is high time I'd withdrawn bountifully");
	}
	public static void endTransaction(){
		System.out.println("Get out of here mehn");
	}
	



	public static void openApp(int v){
		
	}
	
	public static void main(String[] args) {
		// System.out.println("\n Welcome to your Bank/ATM app");
		firstDisplay();
		// openApp(Integer.parseInt(userInput.nextLine()));
		// menuOptions();
	}
}
