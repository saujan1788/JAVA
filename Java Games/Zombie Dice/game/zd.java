import java.util.*;

	// Gurcharn SIngh Sikka : 2899330
	//Saujanya Bohara		: 2875170
	
class zd{
	public static void main(String[] args)
	{
		int p = 0 ;
		int k = 1 ;
		int dice1,dice2,dice3;		// declaring variables for randomly generating dices.
		int roll1=0, roll2=0, roll3=0; // declaring variables for randomly rolling dices.
		int Sscore=0, Bscore=0;
		int play=1;
		String decision="";
		int air=0;
				
		Scanner in = new Scanner(System.in);
		
		Random r = new Random();
		
		System.out.print("\t\t\t=================WELCOME TO ZOMBIE DICE GAME=================");
		System.out.println("\n\nWARNING:- Entering this Game Means You converting Yourself into a ZOMBIE.");
		System.out.println("         AND you will Start Killing Humans to eat their Brains.");
		System.out.println("         If you will not kill and Eat Human's Brain, Humans will Blast your Face with their Shotgun.");
		
		// SAUJANYA BOHARA: Welcome Screen (Zombie Land)
		
		System.out.println("                                                                                 __ __ __ __  __");
		System.out.println("                                                                  ()             || || || ||  ||");
		System.out.println("           _                                                                     |-------------|");
		System.out.println("          /_\\    ~`~     /\\                                                      |             |");
		System.out.println("         /___\\          /  \\   ~`~                                               |-------------|");
		System.out.println("        /_____\\        /    \\                                                    \\             /");
		System.out.println("       /_______\\      /	     \\                                        ~`~         \\           /");
		System.out.println("      /_________\\    /        \\                                                    \\         /");
		System.out.println("     /___________\\  /          \\                                                    |||||||||");
		System.out.println("    /_____________\\/            \\                                   ~`~             |||||||||");
		System.out.println("   /_______________\\             \\                                                  |||||||||");
		System.out.println("  /_________________\\      	  \\                     ___________________         |||||||||");
		System.out.println(" /___________________\\       	   \\                   |   WARNING !!!     |        |||||||||");
		System.out.println("/_____________________\\_____________\\                  |                   |        |||||||||");
		System.out.println("   |||||========|||||        ||||              	       | ZOMBIES AHEAD     |        |||||||||");
		System.out.println("   |||||        |][][][][][][][]|   		       |___________________|        |||||||||");
		System.out.println("   |||||========|||||        ||||                         ||            ||          |||||||||");
		System.out.println("   |||||========|||||        ||||[][][][][][][][][][][][][][][][][][][][][][][][]-|-|||||||||");
		System.out.println("   |||||        |||||        ||||XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|-|||||||||");
		System.out.println("   |||||========|||||        ||||XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|-|||||||||");
		System.out.println("   |||||        |[][][][][][][][|XXXXXXXXXX|                       |XXXXXXXXXXXXXX|-|||||||||");
		System.out.println("   |||||========|||||        ||||XXXXXXXXXX|                       |XXXXXXXXXXXXXX|-|||||||||");
		System.out.println("   |||||========|||||        ||||XXXXXXXXXX|                       |XXXXXXXXXXXXXX|-|||||||||");
		System.out.println("   |||||        |||||        ||||XXXXXXXXXX|                       |XXXXXXXXXXXXXX|-|||||||||");
		System.out.println("   |||||========|||||        ||||XXXXXXXXXX|                       |XXXXXXXXXXXXXX|-|||||||||");
		System.out.println("   |||||        |{}{}{}{}{}{}{}{|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-|||||||||");
		System.out.print("   |||||========|||||        ||||XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-|||||||||");
		System.out.print("                                                      ");
		
		System.out.print("\n\nEnter 1 : To Say Yes to Enter or"); // ask user to play or not.
		System.out.print("\nEnter 0 : To Go Away exit from this Zombie Land.");
		air=in.nextInt();
		
		while(air>=1)
		{	
		if(air==1)
		{
		System.out.print("\nEnter Number of People(Players) wanna enter the Zombie Lnad : "); // Gurcharn Singh : Turn Based System
		p=in.nextInt();		
		
		String[] player = new String[p]; //array to enter player names.
		int[][] score = new int[p][2];	// array to save scores of player.
		
		String[] dices = {"Green","Red","Green","Yellow","Green","Red","Green","Yellow","Green","Red","Yellow","Green","Yellow"};//array for a cup having all dices.
		
		String[] red = {"Shotgun","Shotgun","Shotgun","Footprint","Footprint","Brain"}; // array for red dice
		String[] green = {"Shotgun","Footprint","Footprint","Brain","Brain","Brain"}; //array for green dices
		String [] yellow = {"Shotgun","Shotgun","Footprint","Footprint","Brain","Brain"};// array for yellow dices.
		
		System.out.println("\n");
		
		for(int i=0 ; i < p ; i++)
		{
			System.out.print("Enter Player "+(i+1)+" Name : ");//entering player names
			player[i]=in.next();			
			
			for(int l=0 ; l<2 ; l++)
			{
				score[i][l]=0; //putting initial value 0 for every player scores in array.
			}
		}
		
		while(k<(p+1)) // loop for changing or switching players
		{
			System.out.println("\n\t\t\t\t\tTurn : Player "+k);
			System.out.print("\nEnter 1 :- If you are ready to PLAY GAME.");
			play=in.nextInt();
			
			while(play==1)
			{						// Gurcharn Singh : Randomly Generating Dice & Rolling Dices
				dice1=r.nextInt(13);
				dice2=r.nextInt(13);
				dice3=r.nextInt(13);
				
				System.out.println("\n\nPlayer Name: \t\t\t"+player[(k-1)]);
				System.out.println("\nYour THREE Dices are : ");
				System.out.println("1st Dice : "+dices[dice1]);
				System.out.println("2nd Dice : "+dices[dice2]);
				System.out.println("3rd Dice : "+dices[dice3]);
						
				
				for(int j=1 ; j<=3 ; j++)
				{								// SAUJANYA BOHARA : Checking Dices to Add Player Scores.
					if(j==1)//dice 1 check
					{
						if(dices[dice1]=="Red")
						{
							roll1=r.nextInt(6);
							System.out.println("\n\nYour "+dices[dice1]+" dice got a : "+red[roll1]);
							
							if(red[roll1]=="Shotgun")
							{
								System.out.println("OOPS...Your Victim Fought Back...!!");
								
								Sscore=Sscore+1;
							}
							
							else if(red[roll1]=="Brain")
							{
								System.out.println("YUMMY...Your Ate Your Victim's Brain...!!");
								
								Bscore=Bscore+1;
							}
							
							else if(red[roll1]=="Footprint")
							{
								System.out.println("Your Victim Escaped..!!");
							}
						}
						
						else if(dices[dice1]=="Green")
						{
							roll1=r.nextInt(6);
							System.out.println("\n\nYour "+dices[dice1]+" dice got a : "+green[roll1]);
							
							if(green[roll1]=="Shotgun")
							{
								System.out.println("OOPS...Your Victim Fought Back...!!");
								
								
								Sscore=Sscore+1;
							}
							
							else if(green[roll1]=="Brain")
							{
								System.out.println("YUMMY...Your Ate Your Victim's Brain...!!");
								
								Bscore=Bscore+1;
							}
							
							else if(green[roll1]=="Footprint")
							{
								System.out.println("Your Victim Escaped..!!");
							}
						}
						
						else if(dices[dice1]=="Yellow")
						{
							roll1=r.nextInt(6);
							System.out.println("\n\nYour "+dices[dice1]+" dice got a : "+yellow[roll1]);
							
							if(yellow[roll1]=="Shotgun")
							{
								System.out.println("OOPS...Your Victim Fought Back...!!");
								
								
								Sscore=Sscore+1;
							}
							
							else if(yellow[roll1]=="Brain")
							{
								System.out.println("YUMMY...Your Ate Your Victim's Brain...!!");
								
								Bscore=Bscore+1;
							}
							
							else if(yellow[roll1]=="Footprint")
							{
								System.out.println("Your victim Escaped..!!");
							}
						}
						
					}
					
					else if(j==2)//checking dice 2
					{				
						if(dices[dice2]=="Yellow")
						{
							roll2=r.nextInt(6);
							System.out.println("\nYour "+dices[dice2]+" dice got a: "+yellow[roll2]);
							
							
							if(yellow[roll2]=="Shotgun")
							{
								System.out.println("OOPS...Your Victim Fought Back...!!");
								
								
								Sscore=Sscore+1;
							}
							
							else if(yellow[roll2]=="Brain")
							{
								System.out.println("YUMMY...Your Ate Your Victim's Brain...!!");
								
								Bscore=Bscore+1;
							}
							
							else if(yellow[roll2]=="Footprint")
							{
								System.out.println("Your victim Escaped..!!");
							}
						}
						
						else if(dices[dice2]=="Green")
						{
							roll2=r.nextInt(6);
							System.out.println("\nYour "+dices[dice2]+" dice got a: "+green[roll2]);
							
							if(green[roll2]=="Shotgun")
							{
								System.out.println("OOPS...Your Victim Fought Back...!!");
								
								
								Sscore=Sscore+1;
							}
							
							else if(green[roll2]=="Brain")
							{
								System.out.println("YUMMY...Your Ate Your Victim's Brain...!!");
								
								Bscore=Bscore+1;
							}
							
							else if(green[roll2]=="Footprint")
							{
								System.out.println("Your Bictim Escaped..!!");
							}
						}
						
						else if(dices[dice2]=="Red")
						{
							roll2=r.nextInt(6);
							System.out.println("\nYour "+dices[dice2]+" dice got a: "+red[roll2]);
							
							if(red[roll2]=="Shotgun")
							{
								System.out.println("OOPS...Your Victim Fought Back...!!");
								
								
								Sscore=Sscore+1;
							}
							
							else if(red[roll2]=="Brain")
							{
								System.out.println("YUMMY...Your Ate Your Victim's Brain...!!");
								
								Bscore=Bscore+1;
							}
							
							else if(red[roll2]=="Footprint")
							{
								System.out.println("Your victim Escaped..!!");
							}
						}
						
					}
					
					else if(j==3)
					{
						if(dices[dice3]=="Red")
						{
							roll3=r.nextInt(6);
							System.out.println("\nYour "+dices[dice3]+" dice got a: "+red[roll3]);
							
							if(red[roll3]=="Shotgun")
							{
								System.out.println("OOPS...Your Victim Fought Back...!!");
								
								
								Sscore=Sscore+1;
							}
							
							else if(red[roll3]=="Brain")
							{
								System.out.println("YUMMY...Your Ate Your Victim's Brain...!!");
								
								Bscore=Bscore+1;
							}
							
							else if(red[roll3]=="Footprint")
							{
								System.out.println("Your victim Escaped..!!");
							}
						}
						
						else if(dices[dice3]=="Yellow")
						{
							roll3=r.nextInt(6);
							System.out.println("\nYour "+dices[dice3]+" dice got a: "+yellow[roll3]);
							
							
							if(yellow[roll3]=="Shotgun")
							{
								System.out.println("OOPS...Your Victim Fought Back...!!");
								
								
								Sscore=Sscore+1;
							}
							
							else if(yellow[roll3]=="Brain")
							{
								System.out.println("YUMMY...Your Ate Your Victim's Brain...!!");
								
								Bscore=Bscore+1;
							}
							
							else if(yellow[roll3]=="Footprint")
							{
								System.out.println("Your victim Escaped..!!");
							}
						}
						
						else if(dices[dice3]=="Green")
						{
							roll3=r.nextInt(6);
							System.out.println("\nYour "+dices[dice3]+" dice got a: "+green[roll3]);
							
							if(green[roll3]=="Shotgun")
							{
								System.out.println("OOPS...Your Victim Fought Back...!!");
								
								
								Sscore=Sscore+1;
							}
							
							else if(green[roll3]=="Brain")
							{
								System.out.println("YUMMY...Your Ate Your Victim's Brain...!!");
								
								Bscore=Bscore+1;
							}
							
							else if(green[roll3]=="Footprint")
							{
								System.out.println("Your Victim Escaped..!!");
							}
						}
										
					}
								
				}
				
				
				System.out.println("\n\nSHOTGUNS : "+Sscore);
				System.out.println("BRAINS   : "+Bscore);
				
				if(Sscore>=3)
				{				// Gurcharn Singh : Checking Scores and switch Turn Accordingly.
					play=0;
					System.out.println("\nTurn Over...!!");
					System.out.println("You reached maximum limit of shotguns.");
					
					Sscore=0;
					Bscore=0;
					
					System.out.println("Sorry...But, Your Score for this Turn is Zero now.");
					
					if(k==p)
					{
						k=0;
					}
				}
				
				else if((Bscore+score[(k-1)][1])>=13)
				{
					play=0;
					
					score[(k-1)][0]=score[(k-1)][0]+Sscore;
					Sscore=0;
					score[(k-1)][1]=score[(k-1)][1]+Bscore;
					Bscore=0;
					
					System.out.println("\nYou got maximum number of Brains.");
					System.out.println("You Might be the only winner, But let other finish this round.");
					System.out.println("\nChanging Turn.");
				}
				
				else
				{
					System.out.println("\nEnter 1 to Play Again OR Enter 0 to Stop and save your score. ");
					System.out.print("Enter your choice : ");
					play=in.nextInt();					
					
					if(play!=1)
					{
						System.out.println("\n\nChanging Turn..");
						System.out.println("\nNext Player Please...!!");
						score[(k-1)][0]=score[(k-1)][0]+Sscore;
						Sscore=0;
						score[(k-1)][1]=score[(k-1)][1]+Bscore;
						Bscore=0;
						
						if(k==p)
						{
							for(int a=0 ; a<p ; a++)
							{
								if((score[a][1])<13)
								{
									k=0;
									play=0;
								}
								
								else
								{
									k=(p+1);
									a=p;
								}
							}
							
							if(k!=(p+1))
							{							
								System.out.println("\nNext Round...");
							}
						
						}
					
					}
				}								
			}
			
			
						
			play=1;			
			
			k++;
			
		}
		
		air=0;
		
		System.out.println("\n\n\t\t- Score Board -\n");		//SAUJANYA BOHARA: Scorechart And Declaring Winner and Looser
		System.out.println("Names v &  Scores >\t\t\tShotguns\tBrains\t\tDecision\n");
		
		for(int m=0 ; m<p ; m++)
		{
			System.out.print(player[m] +"'s Scores :- \t\t");
			
			for(int n=0 ; n<2 ; n++)
			{
				System.out.print("\t | "+ score[m][n] +" | \t");	
			}
			for(int e=0 ; e<p ; e++)
				{
					if(score[m][1]>=score[e][1])
					{
						decision="WIINNER";
					}
					
					else if(score[m][1]<=score[e][1])
					{
						decision="LOOSER";
					}
					
					else
					{
						decision=" ";
					}
				}
			
			System.out.print("\t\t"+decision);
			
			System.out.println();
		}
		
		}
		
		else
		{
			System.out.print("\nWrong INPUT..!!");
			System.out.print("\n\nEnter 1 : To Say Yes to Enter or");
			System.out.print("\nEnter 0 : To Go Away exit from this Zombie Land.");
			air=in.nextInt();		
		}
		
	}
	
	if(air==0)
		{
			System.out.println("\n\nRUN Away : Go Away from the Zombie Land Fast otherwise zombie will catch you soon.");
			System.exit(0);			
		}
		
		
		
		
		
		
	}
	
}