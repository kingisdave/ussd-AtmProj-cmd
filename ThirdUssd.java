import java.util.Scanner;
public class ThirdUssd{
	static Scanner userInput = new Scanner(System.in);
	// static String[][] firstMenus = new String[5][4];

	static String[] firstMenus = {
		"\n>  1.Data Plans",
		">  2.Social Bundles",
		">  3.Balance Check",
		">  4.Xtratime/Byte",
		">  5.Gift Data \n",
	};
	static String[][] secondMenus = {
		{
			"\n> 1.Daily",	"> 2.Weekly",	"> 3.Monthly",
			"> 4.Yearly/Annual",	"> 5.Mega Plans"
		},{
			"\n Choose your bundle, and reply with the number",
			"> 1.Daily Social Bundle(whatsapp, linkedin, facebook, instagram...)",	"> 2.Weekly",	
			"> 3.Monthly",	"> 4.Yearly"		
		},{
			"\n> 1.Airtime Balance",	"> 2.Data Balance"
		},{
			"\n> 1.Xtratime Data",	"> 2.Xtratime Airtime",	"> 3.Airtime & Data Xtra "	
		},{
			"\n> 1.Buy Airtime for Friend",	"> 2.Request Airtime from Friend",	"> 3.Buy Data for friend",
			"> 4.Request Data for Friend"		
		}
	};

	static String[][][] ThirdMenus = {
		{
			{
				"\n For your Daily plans: ",	"> 1.N100 for 1GB",	
				"> 2.N200 for 3GB",	"> 3.N500 for 10GB",	"> 4.N1000 for 40GB"
			},{
				"\n For your Weekly plans: ",	"> 1.N200 for 2.5GB",	
				"> 2.N500 for 7GB",	"> 3.N1000 for 20GB",	"> 4.N2000 for 50GB"
			},{
				"\n For your Monthly plans: ",	"> 1.N500 for 6GB",
				"> 2.N1000 for 18GB",	"> 3.N2000 for 40GB",	"> 4.N5000 for 100GB"
			},{
				"\n For your Yearly/Annual plans: ",	"> 1.N5000 for 50GB",
				"> 2.N7000 for 80GB",	"> 3.N10000 for 150GB",	"> 4.N20000 for 500GB"
			}
		},{
			{
				"\n For your Daily Social plans: ",	"> 1.N50 for 1GB",	
				"> 2.N100 for 3GB",	"> 3.N200 for 10GB"
			},{
				"\n For your Weekly Social plans: ",	"> 1.N100 for 2.5GB",	
				"> 2.N200 for 7GB",	"> 3.N500 for 20GB"
			},{
				"\n For your Monthly Social plans: ",	"> 1.N200 for 6GB",
				"> 2.N500 for 18GB",	"> 3.N1000 for 40GB"
			},{
				"\n For your Yearly/Annual Social plans: ",	"> 1.N2000 for 50GB",
				"> 2.N3000 for 80GB",	"> 3.N5000 for 150GB"
			}
		},{
			{" Your account balance is: "},{" Your data balance is: "}		
		},{
			{
				"\n Borrow Data and Pay on recharge: ",	"> 1.N150 for 1GB",	
				"> 2.N300 for 3GB",	"> 3.N1000 for 10GB",	"> 4.N2000 for 40GB"
			},{
				"\n Borrow Airtime and Pay on recharge: ",	"> 1.N100",	
				"> 2.N200",	"> 3.N500",	"> 4.N1000"
			},{
				"\n Borrow Airtime & Data and Pay on recharge: ",	"> 1.N100 and 1GB for N300",
				"> 2.N200 and 2GB for N500",	"> 3.N500 and 5GB for N1000"
			}	
		},{
			{
				"\n To buy airtime for friend, Reply with Recipient's number: "
			},{
				"\n To request airtime from friend, Reply with Donor's number: "
			},{
				"\n To buy data for friend, Reply with Recipient's number: "
			},{
				"\n To request data from friend, Reply with Donor's number: "
			}
		}
	};
	static double[][] dataResults = {{1,3,10,40},{2.5,7,20,50},{6,18,40,100},{50,80,150,500}};
	static double[][] socialResults = {{1,3,10},{2.5,7,20},{6,18,40},{50,80,150}};
	static double[][] dataAmt = {{100,200,500,1000},{200,500,100,200},{500,1000,2000,5000},{5000,7000,10000,20000}};
	static double[][] socialAmt = {{1,3,10},{2.5,7,20},{6,18,40},{50,80,150}};
	static String[] plansName = {"Data plans","Social bundle plans"};
	
	static int myValues;
	static double[][] balances= {{0.00,0.00,0.00},{0.00,0.00,0.00}}; 
	static int airtimeBal = 0;
	static int dataBal = 0;
	public static void firstDisplay(){
		System.out.println("Enter your USSD code");
		System.out.print("\n Your Reply> ");
		String myValues = userInput.nextLine();
		if(myValues.equals("*131#") || myValues.equals("*141#") || myValues.equals("*556#") || myValues.equals("*123#")){
			selectNetwork(myValues);
		} else {
			System.out.print("\n Wrong Input, Please Re-");
			firstDisplay();
		}
	}
	public static void selectNetwork(String ussds){
		System.out.println(" Kindly select one of these networks");
		System.out.println("> 1.MTN");
		System.out.println("> 2.AIRTEL");
		System.out.print("\n Your Reply> ");
		myValues = Integer.parseInt(userInput.nextLine());
		if(myValues > 0 && myValues < 3){
			String myCodes = ussds;
			if(myValues == 1){
					mtnPhone(myCodes);
			} else {
				airtelPhone(myCodes);
			}
		} else {
			selectNetwork("");
		} 
	}
	public static void openApp(int v){
		
	}
	public static void mtnPhone(String mtncode){
		if (mtncode.equals("*131#")) {
			System.out.println(" WELCOME TO MTN APP");
			for (String menus : firstMenus) {
				System.out.println(menus);
			}
			System.out.print(" Your Reply> ");
			myValues = Integer.parseInt(userInput.nextLine());
			if (myValues >0 && myValues < firstMenus.length+1 ) {
				for (int u=0; u< firstMenus.length; u++) {
					if (myValues-1 == u) {
						System.out.print("---------------------------------->");
						for(int v=0; v< secondMenus[u].length; v++){
							System.out.println(secondMenus[u][v]);
						}		
						System.out.print("\n Your Reply> ");
						myValues = Integer.parseInt(userInput.nextLine());
						if (!(myValues>0 && myValues< secondMenus[u].length+1)) {
							System.out.println("Invalid Input details");
						} else {
							System.out.print("----------------------------------->");
							for(int v=0; v< secondMenus[u].length; v++){
								if (myValues-1 == v) {
									for (int j=0; j< ThirdMenus[u][v].length; j++) {
										System.out.println(ThirdMenus[u][v][j]);
										
									}
									if (u == 1) {
										System.out.print("\n Your Reply> ");
										myValues = Integer.parseInt(userInput.nextLine());
										if (myValues == 1) {
											balances[0][0] += 1.00;
											System.out.println("You have loaded " + balances[0][0] +"GB");
										} else if(myValues == 2) {
											balances[0][0] += 3.00;
											System.out.println("You have loaded " + balances[0][0] +"GB");
										} else if(myValues == 3) {
											balances[0][0] += 10.00;
											System.out.println("You have loaded " + balances[0][0] +"GB");
										}  else if(myValues == 4) {
											balances[0][0] += 40.00;
											System.out.println("You have loaded " + balances[0][0] +"GB");
										}
									} else if(u == 2) {
										System.out.print("\n Your Reply> ");
										myValues = Integer.parseInt(userInput.nextLine());
										if (myValues == 1) {
											balances[0][0] += 1.00;
											System.out.println("You have loaded " + balances[0][0] +"GB");
										} else if(myValues == 2) {
											balances[0][0] += 3.00;
											System.out.println("You have loaded " + balances[0][0] +"GB");
										} else if(myValues == 3) {
											balances[0][0] += 10.00;
											System.out.println("You have loaded " + balances[0][0] +"GB");
										}  else if(myValues == 4) {
											balances[0][0] += 40.00;
											System.out.println("You have loaded " + balances[0][0] +"GB");
										}
									} else if (u == 3) {
										
									} else if (u == firstMenus.length-1) {
										System.out.print("\n Your Reply> ");
										String phoneNo = userInput.nextLine();
										System.out.print(" Enter the amount to send ");
										System.out.print("\n Your Reply> ");
										int sentMoney = Integer.parseInt(userInput.nextLine());
										System.out.print("You have sent "+ sentMoney + " to this phone number " + phoneNo);

									}
									// if (u == firstMenus.length-1) {
									// 	System.out.print("\n Your Reply> ");
									// 	String phoneNo = userInput.nextLine();
									// 	System.out.print(" Enter the amount to send ");
									// 	System.out.print("\n Your Reply> ");
									// 	int sentMoney = Integer.parseInt(userInput.nextLine());
									// 	System.out.print("You have sent "+ sentMoney + " to this phone number " + phoneNo);

									// } else{
									// 	System.out.print("\n Your Reply> ");
									// 	myValues = Integer.parseInt(userInput.nextLine());
									// 	if (myValues == 1) {
									// 		balances[0][0] += 1.00;
									// 		System.out.println("You have loaded " + balances[0][0] +"GB");
									// 	} else if(myValues == 2) {
									// 		balances[0][0] += 3.00;
									// 		System.out.println("You have loaded " + balances[0][0] +"GB");
									// 	} else if(myValues == 3) {
									// 		balances[0][0] += 10.00;
									// 		System.out.println("You have loaded " + balances[0][0] +"GB");
									// 	}  else if(myValues == 4) {
									// 		balances[0][0] += 40.00;
									// 		System.out.println("You have loaded " + balances[0][0] +"GB");
									// 	}
									// 	firstDisplay();
									// }
								}
							}	
						}
					}
				}
			}else{
				System.out.println("\n Your code is Invalid\n");
				firstDisplay();			
			}
			
		} else if(mtncode.equals("*556#")) {
			System.out.println(" Your account balances is #"+ balances[0][0]);
		} else {
			System.out.println(" Your code is Invalid\n");
			firstDisplay();
		}	
	}
	public static void airtelPhone(String airtelcode){
		if (airtelcode.equals("*141#")) {
			System.out.println(" WELCOME TO AIRTEL APP");
			for (String menus : firstMenus) {
				System.out.println(menus);
			}
			System.out.print(" Your Reply> ");
			userInput.nextLine();
		} else if(airtelcode.equals("*123#")) {
			System.out.println(" Your account balances is #"+ balances[1][0]);
		} else {
			System.out.println(" Your code is Invalid\n");
			firstDisplay();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\n Welcome to your Sim Manager");
		firstDisplay();
		// openApp(Integer.parseInt(userInput.nextLine()));
		// menuOptions();
	}
}
