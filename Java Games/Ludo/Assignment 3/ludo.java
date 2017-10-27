import java.util.*;
import java.io.*;

			

class ludo{
	public static void main(String[] args){
		
		int player=0, dice=0, enter=0, p=0, t=0;			/* player= no. of players , dice variable to store random values of dice ,  */
		
		int yellow1=0, yellow2=0, yellow3=0, yellow4=0;		/* 4 tokens for YELLOW */
		int blue1=0, blue2=0, blue3=0, blue4=0;				/* 4 tokens for BLUE */
		int red1=0, red2=0, red3=0, red4=0;					/* 4 tokens for red */
		int green1=0, green2=0, green3=0, green4=0;			/* 4 tokens for green */
		
		
		
		int[][]ludo = {{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,101,102,	103,104,105,106},
			{0,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,1,2,3,4,5,6,7,8,9,10,11,12,201,202,203,204,205,206},
			{0,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,301,302,303,304,305,306},
			{0,40,41,42,43,44,45,46,47,48,49,50,51,52,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,401,402,403,404,405,406}};											/* Ludo array declared with unique numbers to every place in the game area to easily move and compare tokens.  */
				
		Scanner in = new Scanner(System.in);			/* Scanner declared to take inputs from user. */
		
		
		board(ludo, yellow1, yellow2, yellow3, yellow4,	blue1, blue2, blue3, blue4, red1, red2, red3, red4,	green1, green2, green3, green4);			/* Calling board method to print & display tokens on the current board. */
		
		while(player<2 || player>4)						/* While loop created to check and ask to user if input for no. of players will be less than 2 or more than 4. */
		{
			System.out.println("Enter minimum 2 player or maximum 4 players.");		/* Instruction to user for giving right input. */
			System.out.print("\nEnter number of players : ");						
			player=in.nextInt();													/* Taking input for no. of players wanna play. */
		}
				
		String[] name = new String[player];				/* A string declare to save name for each player. */
		
		
		
		for(int i=0 ; i<player ; i++)					/* A loop to put the colour of their area in front of their name. */
		{
			System.out.print("\nEnter name of player "+(i+1)+" : ");
			name[i]=in.next();
			
			if(i==0)
			{
				name[i] = "YELLOW "+name[i];
			}
			
			if(i==1)
			{
				name[i] = "BLUE "+name[i];
			}
			
			if(i==2)
			{
				name[i] = "RED "+name[i];
			}
			
			if(i==3)
			{
				name[i] = "GREEN "+name[i];
			}
			
		}
		
		System.out.println("\nEnter 1 to PLAY or 0 to Exit.");
		System.out.print("Enter your choice : ");
		enter=in.nextInt();
		
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
		while(enter>=1)
		{
			in.nextLine();
			if(enter==1)							/* Condition: If player enters 1 to play it. */
			{
				while(p<player)						/* A loop to run game according to the number of players. */
				{
					
					while(p==0)						/* Loop for player */
					{							
						System.out.println("\n==============================================================================");	/* A line to seperate the screen after every player completed its turn. */
						System.out.println("\n\nLUDO Game\t\t\t\t\tPlayer "+(p+1)+" : "+name[p]);	/* Print name of the player */
						System.out.println("\nPosition of tokens on the Board:-");					/* Print position of every token on the board. */
						
						System.out.println("\n\nToken 1 = "+yellow1+"\tToken 2 = "+yellow2+"\tToken 3 = "+yellow3+"\tToken 4 = "+yellow4);
												
						System.out.println("\nRolling DICE......\nPress ENTER.");
						in.nextLine();				/* Asking to press enter to process further code. */
						
						dice=diceroll();
						System.out.println("!!..You got "+dice+" on your dice..!!");				/* Print the no. we got on dice. */
												
						
						if(ludo[p][yellow1]==0 && ludo[p][yellow2]==0 && ludo[p][yellow3]==0 && ludo[p][yellow4]==0 && dice!=6)
						{							/* not to ask to move any token if all tokens are at initial position and didnt get 6 on dice. */
							System.out.println("\nYou can't move any token. You need six to move your token into the Game area.");
							t=0;					/* declare token no. as zero so that it will not change any token. */
							p++;					/* go to next player. */
							
							board(ludo, yellow1, yellow2, yellow3, yellow4,	blue1, blue2, blue3, blue4, red1, red2, red3, red4,	green1, green2, green3, green4);			/* Calling board method to print & display tokens on the current board. */
		
									
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
						}
						
						else
						{
							System.out.print("\nWhich Token no. you want to move..?? : ");		/* Ask for the token no. to move. */
							t=in.nextInt();
							
							while(t<1 && t>4)			/* A loop if user enter the wrong token no. */
							{
								System.out.println("\n\nERROR : Wrong Token no. entered..You just have Token no. 1,2,3 & 4..!!");
								System.out.print("\nWhich Token no. you want to move..?? : ");
								t=in.nextInt();
							}
							
							while(t>=1 && t<=4)			/* A loop to change values of token according to token no. entered */
							{
								if(t==1)				/* enter if token no. 1 entered. */
								{
									if(ludo[p][yellow1]==0)	/* if token is at zero position. */
									{
										if(dice==6)			/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											yellow1=1;
											System.out.println("\nYour Token is in the Game area now.");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=1;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==1 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{	
										if((yellow1 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											yellow1=yellow1+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][yellow1]+" on the board.");
										}
										
										else if(yellow1==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-yellow1)+". \nBut you got "+dice);
										}
										
										blue1=tokencheck(ludo, yellow1, blue1, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, yellow1, blue2, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, yellow1, blue3, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, yellow1, blue4, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										red1=tokencheck(ludo, yellow1, red1, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, yellow1, red2, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, yellow1, red3, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, yellow1, red4, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, yellow1, green1, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, yellow1, green2, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, yellow1, green3, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, yellow1, green4, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
											
														/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=1;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										p++;
										t=0;
									}
										
									}
									
								}
								
								if(t==2)			/* enter if token no. 2 entered. */
								{
									if(ludo[p][yellow2]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											yellow2=1;
											System.out.println("\nYour Token is in the Game area now.");
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=2;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==2 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}				
									
									}
									
									else					/* If token is not at zero position. */
									{
										if((yellow2 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											yellow2=yellow2+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][yellow2]+" on the board.");
										}
										
										else if(yellow2==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-yellow2)+". \nBut you got "+dice);
										}
										
										blue1=tokencheck(ludo, yellow2, blue1, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, yellow2, blue2, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, yellow2, blue3, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, yellow2, blue4, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										red1=tokencheck(ludo, yellow2, red1, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, yellow2, red2, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, yellow2, red3, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, yellow2, red4, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, yellow2, green1, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, yellow2, green2, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, yellow2, green3, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, yellow2, green4, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
															/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=2;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										p++;
										t=0;
									}
									}
									
																			
								}
								
								if(t==3)				/* enter if token no. 3 entered. */
								{
									if(ludo[p][yellow3]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											yellow3=1;
											System.out.println("\nYour Token is in the Game area now.");
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=3;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==3 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
										
										
									
									}
									
									else				/* If token is not at zero position. */
									{
										if((yellow3 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											yellow3=yellow3+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][yellow3]+" on the board.");
										}
										
										else if(yellow3==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-yellow3)+". \nBut you got "+dice);
										}
										
										
										blue1=tokencheck(ludo, yellow3, blue1, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, yellow3, blue2, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, yellow3, blue3, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, yellow3, blue4, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										red1=tokencheck(ludo, yellow3, red1, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, yellow3, red2, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, yellow3, red3, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, yellow3, red4, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, yellow3, green1, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, yellow3, green2, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, yellow3, green3, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, yellow3, green4, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
														/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=3;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										p++;
										t=0;
									}
									}
																		
								}
								
								if(t==4)				/* enter if token no. 4 entered. */
								{
									if(ludo[p][yellow4]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											yellow4=1;
											System.out.println("\nYour Token is in the Game area now.");
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=4;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==4 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to movie your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{
										if((yellow4 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											yellow4=yellow4+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][yellow4]+" on the board.");
										}
										
										else if(yellow4==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-yellow4)+". \nBut you got "+dice);
										}
										
										blue1=tokencheck(ludo, yellow4, blue1, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, yellow4, blue2, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, yellow4, blue3, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, yellow4, blue4, 0, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										red1=tokencheck(ludo, yellow4, red1, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, yellow4, red2, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, yellow4, red3, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, yellow4, red4, 0, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, yellow4, green1, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, yellow4, green2, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, yellow4, green3, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, yellow4, green4, 0, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
														/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=4;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										p++;
										t=0;
									}	
																				
									}	
																								
										
								}
								
								
							}
										
							System.out.print("\nPress ENTER.");
							in.nextLine();
							
							System.out.println();
							
							board(ludo, yellow1, yellow2, yellow3, yellow4,	blue1, blue2, blue3, blue4, red1, red2, red3, red4,	green1, green2, green3, green4);			/* Calling board method to print & display tokens on the current board. */
		
							
							
						
						}
						
						
						
					}
					
					while(p==1)
					{							
						System.out.println("\n\n==============================================================================");	/* A line to seperate the screen after every player completed its turn. */
						System.out.println("\n\nLUDO Game\t\t\t\t\tPlayer "+(p+1)+" : "+name[p]);	/* Print name of the player */
						System.out.println("\nPosition of tokens on the Board:-");					/* Print position of every token on the board. */
						
						System.out.println("\n\nToken 1 = "+blue1+"\tToken 2 = "+blue2+"\tToken 3 = "+blue3+"\tToken 4 = "+blue4);
												
						System.out.println("\nRolling DICE......\nPress ENTER.");
						in.nextLine();				/* Asking to press enter to process further code. */
						
						dice=diceroll();
						System.out.println("!!..You got "+dice+" on your dice..!!");				/* Print the no. we got on dice. */
												
						
						if(ludo[p][blue1]==0 && ludo[p][blue2]==0 && ludo[p][blue3]==0 && ludo[p][blue4]==0 && dice!=6)
						{							/* not to ask to move any token if all tokens are at initial position and didnt get 6 on dice. */
							System.out.println("\nYou can't move any token. You need six to move your token into the Game area.");
							t=0;					/* declare token no. as zero so that it will not change any token. */
							if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
							{
								System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
							}
							
							if(player>2)			/* go to next player. */
							{
								p++;
							}
							else
							{
								p=0;
							}
							
							
							board(ludo, yellow1, yellow2, yellow3, yellow4,	blue1, blue2, blue3, blue4, red1, red2, red3, red4,	green1, green2, green3, green4);							/* Print Current board. */
									
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
						}
						
						else
						{
							System.out.print("\nWhich Token no. you want to move..?? : ");		/* Ask for the token no. to move. */
							t=in.nextInt();
							
							while(t<1 && t>4)			/* A loop if user enter the wrong token no. */
							{
								System.out.println("\n\nERROR : Wrong Token no. entered..You just have Token no. 1,2,3 & 4..!!");
								System.out.print("\nWhich Token no. you want to move..?? : ");
								t=in.nextInt();
							}
							
							while(t>=1 && t<=4)			/* A loop to change values of token according to token no. entered */
							{
								if(t==1)				/* enter if token no. 1 entered. */
								{
									if(ludo[p][blue1]==0)	/* if token is at zero position. */
									{
										if(dice==6)			/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											blue1=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=1;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==1 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{	
										if((blue1 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											blue1=blue1+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][blue1]+" on the board.");
										}
										
										else if(blue1==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-blue1)+". \nBut you got "+dice);
										}
										
										yellow1=tokencheck(ludo, blue1, yellow1, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, blue1, yellow2, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, blue1, yellow3, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, blue1, yellow4, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										red1=tokencheck(ludo, blue1, red1, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, blue1, red2, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, blue1, red3, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, blue1, red4, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, blue1, green1, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, blue1, green2, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, blue1, green3, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, blue1, green4, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
											
														/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=1;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										
										if(player>2)			/* go to next player. */
										{
											p++;
										}
										else
										{
											p=0;
										}
										t=0;
									}
									}
									
										
								}
								
								if(t==2)			/* enter if token no. 2 entered. */
								{
									if(ludo[p][blue2]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											blue2=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=2;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==2 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else					/* If token is not at zero position. */
									{
										if((blue2 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											blue2=blue2+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][blue2]+" on the board.");
										}
										
										else if(blue2==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-blue2)+". \nBut you got "+dice);
										}
										
										yellow1=tokencheck(ludo, blue2, yellow1, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, blue2, yellow2, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, blue2, yellow3, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, blue2, yellow4, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										red1=tokencheck(ludo, blue2, red1, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, blue2, red2, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, blue2, red3, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, blue2, red4, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, blue2, green1, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, blue2, green2, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, blue2, green3, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, blue2, green4, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
															/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=2;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										
										if(player>2)			/* go to next player. */
										{
											p++;
										}
										else
										{
											p=0;
										}
										t=0;
									}	
									}
									
																			
								}
								
								if(t==3)				/* enter if token no. 3 entered. */
								{
									if(ludo[p][blue3]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											blue3=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=3;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==3 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{
										if((blue3 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											blue3=blue3+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][blue3]+" on the board.");
										}
										
										else if(blue3==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-blue3)+". \nBut you got "+dice);
										}
										
										yellow1=tokencheck(ludo, blue3, yellow1, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, blue3, yellow2, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, blue3, yellow3, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, blue3, yellow4, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										red1=tokencheck(ludo, blue3, red1, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, blue3, red2, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, blue3, red3, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, blue3, red4, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, blue3, green1, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, blue3, green2, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, blue3, green3, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, blue3, green4, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=3;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										
										if(player>2)			/* go to next player. */
										{
											p++;
										}
										else
										{
											p=0;
										}
										t=0;
									}
									}
									
																		
								}
								
								if(t==4)				/* enter if token no. 4 entered. */
								{
									if(ludo[p][blue4]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											blue4=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=4;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==4 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to movie your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{
										if((blue4 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											blue4=blue4+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][blue4]+" on the board.");
										}
										
										else if(blue4==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-blue4)+". \nBut you got "+dice);
										}
										
										
										yellow1=tokencheck(ludo, blue4, yellow1, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, blue4, yellow2, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, blue4, yellow3, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, blue4, yellow4, 1, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										red1=tokencheck(ludo, blue4, red1, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, blue4, red2, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, blue4, red3, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, blue4, red4, 1, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, blue4, green1, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, blue4, green2, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, blue4, green3, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, blue4, green4, 1, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=4;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										
										if(player>2)			/* go to next player. */
										{
											p++;
										}
										else
										{
											p=0;
										}
										t=0;
									}
																				
									}	
																								
										
								}
								
								
							}
										
							System.out.print("\nPress ENTER.");
							in.nextLine();
							System.out.println();
							board(ludo, yellow1, yellow2, yellow3, yellow4,	blue1, blue2, blue3, blue4, red1, red2, red3, red4,	green1, green2, green3, green4);			/* Calling board method to print & display tokens on the current board. */
		
							
							
						
						}						
					
					}
					
					while(p==2)
					{							
						System.out.println("\n\n==============================================================================");	/* A line to seperate the screen after every player completed its turn. */
						System.out.println("\n\nLUDO Game\t\t\t\t\tPlayer "+(p+1)+" : "+name[p]);	/* Print name of the player */
						System.out.println("\nPosition of tokens on the Board:-");					/* Print position of every token on the board. */
						
						System.out.println("\n\nToken 1 = "+red1+"\tToken 2 = "+red2+"\tToken 3 = "+red3+"\tToken 4 = "+red4);
												
						System.out.println("\nRolling DICE......\nPress ENTER.");
						in.nextLine();				/* Asking to press enter to process further code. */
						
						dice=diceroll();
						System.out.println("!!..You got "+dice+" on your dice..!!");				/* Print the no. we got on dice. */
												
						
						if(ludo[p][red1]==0 && ludo[p][red2]==0 && ludo[p][red3]==0 && ludo[p][red4]==0 && dice!=6)
						{							/* not to ask to move any token if all tokens are at initial position and didnt get 6 on dice. */
							System.out.println("\nYou can't move any token. You need six to move your token into the Game area.");
							t=0;					/* declare token no. as zero so that it will not change any token. */
							if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
							{
								System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
							}
							if(player>3)			/* go to next player. */
							{
								p++;
							}
							else
							{
								p=0;
							}
							
							
							board(ludo, yellow1, yellow2, yellow3, yellow4,	blue1, blue2, blue3, blue4, red1, red2, red3, red4,	green1, green2, green3, green4);							/* Print Current board. */
									
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
						}
						
						else
						{
							System.out.print("\nWhich Token no. you want to move..?? : ");		/* Ask for the token no. to move. */
							t=in.nextInt();
							
							while(t<1 && t>4)			/* A loop if user enter the wrong token no. */
							{
								System.out.println("\n\nERROR : Wrong Token no. entered..You just have Token no. 1,2,3 & 4..!!");
								System.out.print("\nWhich Token no. you want to move..?? : ");
								t=in.nextInt();
							}
							
							while(t>=1 && t<=4)			/* A loop to change values of token according to token no. entered */
							{
								if(t==1)				/* enter if token no. 1 entered. */
								{
									if(ludo[p][red1]==0)	/* if token is at zero position. */
									{
										if(dice==6)			/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											red1=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=1;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==1 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{	
										if((red1 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											red1=red1+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][red1]+" on the board.");
										}
										
										else if(red1==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-red1)+". \nBut you got "+dice);
										}
										
										yellow1=tokencheck(ludo, red1, yellow1, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, red1, yellow2, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, red1, yellow3, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, red1, yellow4, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										blue1=tokencheck(ludo, red1, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, red1, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, red1, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, red1, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, red1, green1, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, red1, green2, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, red1, green3, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, red1, green4, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
											
														/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=1;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										
										if(player>3)			/* go to next player. */
										{
											p++;
										}
										else
										{
											p=0;
										}
										t=0;
									}
									}
									
										
								}
								
								if(t==2)			/* enter if token no. 2 entered. */
								{
									if(ludo[p][red2]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											red2=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=2;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==2 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else					/* If token is not at zero position. */
									{
										if((red2 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											red2=red2+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][red2]+" on the board.");
										}
										
										else if(red2==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-red2)+". \nBut you got "+dice);
										}
										
										yellow1=tokencheck(ludo, red2, yellow1, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, red2, yellow2, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, red2, yellow3, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, red2, yellow4, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										blue1=tokencheck(ludo, red2, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, red2, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, red2, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, red2, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, red2, green1, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, red2, green2, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, red2, green3, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, red2, green4, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
													/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=2;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										
										if(player>3)			/* go to next player. */
										{
											p++;
										}
										else
										{
											p=0;
										}
										t=0;
									}	
									}
									
																			
								}
								
								if(t==3)				/* enter if token no. 3 entered. */
								{
									if(ludo[p][red3]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											red3=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=3;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==3 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{
										if((red3 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											red3=red3+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][red3]+" on the board.");
										}
										
										else if(red3==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-red3)+". \nBut you got "+dice);
										}
										
										yellow1=tokencheck(ludo, red3, yellow1, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, red3, yellow2, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, red3, yellow3, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, red3, yellow4, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										blue1=tokencheck(ludo, red3, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, red3, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, red3, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, red3, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, red3, green1, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, red3, green2, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, red3, green3, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, red3, green4, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
												/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=3;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										
										if(player>3)			/* go to next player. */
										{
											p++;
										}
										else
										{
											p=0;
										}
										t=0;
									}
									}
									
																		
								}
								
								if(t==4)				/* enter if token no. 4 entered. */
								{
									if(ludo[p][red4]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											red4=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=4;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==4 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to movie your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{
										if((red4 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											red4=red4+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][red4]+" on the board.");
										}
										
										else if(red4==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-red4)+". \nBut you got "+dice);
										}
										
										
										yellow1=tokencheck(ludo, red4, yellow1, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, red4, yellow2, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, red4, yellow3, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, red4, yellow4, 2, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										blue1=tokencheck(ludo, red4, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, red4, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, red4, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, red4, blue1, 2, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										green1=tokencheck(ludo, red4, green1, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green2=tokencheck(ludo, red4, green2, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green3=tokencheck(ludo, red4, green3, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										green4=tokencheck(ludo, red4, green4, 2, 3);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
												/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=4;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										
										if(player>3)			/* go to next player. */
										{
											p++;
										}
										else
										{
											p=0;
										}
										t=0;
									}
																				
									}	
																								
										
								}
								
								
							}
										
							System.out.print("\nPress ENTER.");
							in.nextLine();
							System.out.println();
							board(ludo, yellow1, yellow2, yellow3, yellow4,	blue1, blue2, blue3, blue4, red1, red2, red3, red4,	green1, green2, green3, green4);			/* Calling board method to print & display tokens on the current board. */
		
							
							
						
						}						
					
					}
					while(p==3)
					{							
						System.out.println("\n\n==============================================================================");	/* A line to seperate the screen after every player completed its turn. */
						System.out.println("\n\nLUDO Game\t\t\t\t\tPlayer "+(p+1)+" : "+name[p]);	/* Print name of the player */
						System.out.println("\nPosition of tokens on the Board:-");					/* Print position of every token on the board. */
						
						System.out.println("\n\nToken 1 = "+green1+"\tToken 2 = "+green2+"\tToken 3 = "+green3+"\tToken 4 = "+green4);
												
						System.out.println("\nRolling DICE......\nPress ENTER.");
						in.nextLine();				/* Asking to press enter to process further code. */
						
						dice=diceroll();
						System.out.println("!!..You got "+dice+" on your dice..!!");				/* Print the no. we got on dice. */
												
						
						if(ludo[p][green1]==0 && ludo[p][green2]==0 && ludo[p][green3]==0 && ludo[p][green4]==0 && dice!=6)
						{							/* not to ask to move any token if all tokens are at initial position and didnt get 6 on dice. */
							System.out.println("\nYou can't move any token. You need six to move your token into the Game area.");
							t=0;					/* declare token no. as zero so that it will not change any token. */
							if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
							{
								System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
							}
							else
							{
								p=0;
							}
							
							
							board(ludo, yellow1, yellow2, yellow3, yellow4,	blue1, blue2, blue3, blue4, red1, red2, red3, red4,	green1, green2, green3, green4);							/* Print Current board. */
									
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
						}
						
						else
						{
							System.out.print("\nWhich Token no. you want to move..?? : ");		/* Ask for the token no. to move. */
							t=in.nextInt();
							
							while(t<1 && t>4)			/* A loop if user enter the wrong token no. */
							{
								System.out.println("\n\nERROR : Wrong Token no. entered..You just have Token no. 1,2,3 & 4..!!");
								System.out.print("\nWhich Token no. you want to move..?? : ");
								t=in.nextInt();
							}
							
							while(t>=1 && t<=4)			/* A loop to change values of token according to token no. entered */
							{
								if(t==1)				/* enter if token no. 1 entered. */
								{
									if(ludo[p][green1]==0)	/* if token is at zero position. */
									{
										if(dice==6)			/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											green1=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=1;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==1 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{	
										if((green1 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											green1=green1+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][green1]+" on the board.");
										}
										
										else if(green1==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-green1)+". \nBut you got "+dice);
										}
										
										yellow1=tokencheck(ludo, green1, yellow1, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, green1, yellow2, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, green1, yellow3, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, green1, yellow4, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										blue1=tokencheck(ludo, green1, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, green1, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, green1, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, green1, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										red1=tokencheck(ludo, green1, red1, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, green1, red2, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, green1, red3, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, green1, red4, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
											
														/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=1;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										else
										{
											p=0;
										}
										t=0;
									}
									}
									
										
								}
								
								if(t==2)			/* enter if token no. 2 entered. */
								{
									if(ludo[p][green2]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											green2=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=2;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==2 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else					/* If token is not at zero position. */
									{
										if((green2 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											green2=green2+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][green2]+" on the board.");
										}
										
										else if(green2==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-green2)+". \nBut you got "+dice);
										}
										
										yellow1=tokencheck(ludo, green2, yellow1, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, green2, yellow2, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, green2, yellow3, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, green2, yellow4, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										blue1=tokencheck(ludo, green2, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, green2, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, green2, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, green2, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										red1=tokencheck(ludo, green2, red1, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, green2, red2, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, green2, red3, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, green2, red4, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
											/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=2;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										else
										{
											p=0;
										}
										t=0;
									}	
									}
									
																			
								}
								
								if(t==3)				/* enter if token no. 3 entered. */
								{
									if(ludo[p][green3]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											green3=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=3;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==3 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to move your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{
										if((green3 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											green3=green3+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][green3]+" on the board.");
										}
										
										else if(green3==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else							/* else tell user that he cant move this token and as he didnt get right no. on dice so he loose this turn. */
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-green3)+". \nBut you got "+dice);
										}
										
										yellow1=tokencheck(ludo, green3, yellow1, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, green3, yellow2, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, green3, yellow3, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, green3, yellow4, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										blue1=tokencheck(ludo, green3, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, green3, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, green3, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, green3, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										red1=tokencheck(ludo, green3, red1, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, green3, red2, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, green3, red3, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, green3, red4, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
											/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=3;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										else
										{
											p=0;
										}
										t=0;
									}
									}
									
																		
								}
								
								if(t==4)				/* enter if token no. 4 entered. */
								{
									if(ludo[p][green4]==0)			/* if token is at zero position. */
									{
										if(dice==6)					/* Check if user got 6 on dice, then take the token into the game area. at first position. */
										{
											green4=1;
											System.out.println("\nYour Token is in the Game area now.");
												
											System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
											System.out.println("\n\nRerolling Dice :-");
											dice=diceroll();
											System.out.println("!!..You got "+dice+" on your dice..!!");
											t=4;
										}
										
										else				/* else say to user that he can't move this token and ask to choose another token */
										{
											while(t==4 || (t<1 && t>4))		/* Continue asking for token if user still telling same token or wrong token no. */
											{
												System.out.println("\nYou can't move this token out.\nYou need 6 on your dice to movie your token into the game area.");
												System.out.println("\nChoose any other token");
												System.out.print("Which Token no. you want to move..?? : ");
												t=in.nextInt();
											}
											
										}
									}
									
									else				/* If token is not at zero position. */
									{
										if((green4 + dice) <58)		/* if current value of token + dice no. is less than its home position then add value of dice in the token. */
										{
											green4=green4+dice;
											System.out.println("\nYour Token 1 is at position "+ludo[p][green4]+" on the board.");
										}
										
										else if(green4==57)			/* if token is already at home then ask for another token no. */
										{
											System.out.println("Token is already in the HOME area. Enter any other token");
											while(t<1 && t>4)
											{
												System.out.print("\nWhich Token no. you want to move..?? : ");
												t=in.nextInt();
											}
										}
										
										else
										{
											System.out.println("\n\nYou can't move token into the HOME area as you need "+(58-green4)+". \nBut you got "+dice);
										}
										
										
										yellow1=tokencheck(ludo, green4, yellow1, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow2=tokencheck(ludo, green4, yellow2, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow3=tokencheck(ludo, green4, yellow3, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										yellow4=tokencheck(ludo, green4, yellow4, 3, 0);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
																			
										blue1=tokencheck(ludo, green4, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue2=tokencheck(ludo, green4, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue3=tokencheck(ludo, green4, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										blue4=tokencheck(ludo, green4, blue1, 3, 1);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										
										red1=tokencheck(ludo, green4, red1, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red2=tokencheck(ludo, green4, red2, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red3=tokencheck(ludo, green4, red3, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
										red4=tokencheck(ludo, green4, red4, 3, 2);		/* A loop to check whether two tokens of different colours are at same position then change the last token which was at this position to zero. */
											/* check to Rerolling dice. */
									if(dice==6)
									{
										System.out.println("\n\n!!..You got another chance to roll your dice..!!\n!!..As you got six on your last dice roll..!!");
							System.out.print("\n\nPress ENTER.");
							in.nextLine();
										System.out.println("\n\nRerolling Dice :-");
										dice=diceroll();
										System.out.println("!!..You got "+dice+" on your dice..!!");
										t=4;
									}
									else
									{								
										System.out.println("\n\nNext player turn.");
										if((yellow1==57 && yellow2==57 &&  yellow3==57 &&  yellow4==57) || (blue1==57 && blue2==57 && blue3==57 && blue4==57) || (red1==57 && red2==57 && red3==57 && red4==57) || (green1==57 && green2==57 && green3==57 && green4==57))			/* go to next player. */
										{
											System.out.println("\nGAME OVER - check for winner");  p=5;  enter=0;
										}
										else
										{
											p=0;
										}
										t=0;
									}
																				
									}	
																								
										
								}
								
								
							}
										
							System.out.print("\nPress ENTER.");
							in.nextLine();
							System.out.println();
							board(ludo, yellow1, yellow2, yellow3, yellow4,	blue1, blue2, blue3, blue4, red1, red2, red3, red4,	green1, green2, green3, green4);			/* Calling board method to print & display tokens on the current board. */
		
							
							
						
						}						
					
					}
				
				}
			}
			
			else if(enter!=1 || enter!=0)
			{
				System.out.println("\n\nERROR : Wrong input enter..!!");		
				System.out.println("\nEnter 1 to PLAY or 0 to Exit.");
				System.out.print("Enter your choice : ");
				enter=in.nextInt();
			}
			
			
		}
		
		if(enter==0)
		{
			System.out.println("\n\nThanks for playing this game.\n\nExiting Game.");
			System.exit(0);
		}
		
		
	}
	
	public static int diceroll()
	{
		Random r = new Random();
		
		int x = r.nextInt(6)+1;
		
		return(x);
	}
	
	public static int tokencheck(int [][] board,int t1,int t2,int p1,int p2) /* To check one token with other. if both tokens at same position then make second token zero.*/
	{
		if((board[p1][t1]!=0) && (board[p1][t1]==board[p2][t2]))
		{
			t2=0;
			return(t2);			
		}
		else
		{
			return(t2);
		}
	}
	
	public static void board(int [][] game,	int y1, int y2, int y3, int y4,	int b1, int b2, int b3, int b4,	int r1, int r2, int r3, int r4,	int g1, int g2, int g3, int g4)
	{
		int[][] board = {	{500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500},
							{502,502,502,502,502,502,501,24,25,26,501,502,502,502,502,502,502},
							{502,58,502,502,59,502,501,23,301,27,501,502,61,502,502,62,502},
							{502,502,502,502,502,502,501,22,302,28,501,502,502,502,502,502,502},
							{502,502,502,502,502,502,501,21,303,29,501,502,502,502,502,502,502},
							{502,57,502,502,60,502,501,20,304,30,501,502,64,502,502,63,502},
							{502,502,502,502,502,502,501,19,305,31,501,502,502,502,502,502,502},
							{500,500,500,500,500,500,501,500,500,500,501,500,500,500,500,500,500},
							{13,14,15,16,17,18,501,502,306,502,501,32,33,34,35,36,37},
							{12,201,202,203,204,205,501,206,502,406,501,405,404,403,402,401,38},
							{11,10,9,8,7,6,501,502,106,502,501,44,43,42,41,40,39},
							{500,500,500,500,500,500,501,500,500,500,501,500,500,500,500,500,500},
							{502,502,502,502,502,502,501,5,105,45,501,502,502,502,502,502,502},
							{502,55,502,502,56,502,501,4,104,46,501,502,68,502,502,65,502},
							{502,502,502,502,502,502,501,3,103,47,501,502,502,502,502,502,502},
							{502,502,502,502,502,502,501,2,102,48,501,502,502,502,502,502,502},
							{502,54,502,502,53,502,501,1,101,49,501,502,67,502,502,66,502},
							{502,502,502,502,502,502,501,52,51,50,501,502,502,502,502,502,502},
							{500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500}};
						
							
		for(int i=0 ; i<board.length ; i++)
		{
			for(int j=0 ; j<17 ; j++)
			{				
				if(board[i][j]==500)
				{
					System.out.print("---");
				}
				else if(board[i][j]==501)
				{
					System.out.print(" | ");
				}
				else if(board[i][j]==502)
				{
					System.out.print("   ");
				}
				
				
				else if(board[i][j]==53 && game[0][y1]==0)
				{
					System.out.print(" Y1");
				}
				else if(board[i][j]==54 && game[0][y2]==0)
				{
					System.out.print(" Y2");
				}
				else if(board[i][j]==55 && game[0][y3]==0)
				{
					System.out.print(" Y3");
				}
				else if(board[i][j]==56 && game[0][y4]==0)
				{
					System.out.print(" Y4");
				}
				
				else if(board[i][j]==game[0][y1])
				{
					System.out.print(" Y1");
				}else if(board[i][j]==game[0][y2])
				{
					System.out.print(" Y2");
				}else if(board[i][j]==game[0][y3])
				{
					System.out.print(" Y3");
				}else if(board[i][j]==game[0][y4])
				{
					System.out.print(" Y4");
				}
				
				else if(board[i][j]==57 && game[1][b1]==0)
				{
					System.out.print(" B1");
				}
				else if(board[i][j]==58 && game[1][b2]==0)
				{
					System.out.print(" B2");
				}
				else if(board[i][j]==59 && game[1][b3]==0)
				{
					System.out.print(" B3");
				}
				else if(board[i][j]==60 && game[1][b4]==0)
				{
					System.out.print(" B4");
				}
				
				else if(board[i][j]==game[1][b1])
				{
					System.out.print(" B1");
				}else if(board[i][j]==game[1][b2])
				{
					System.out.print(" B2");
				}else if(board[i][j]==game[1][b3])
				{
					System.out.print(" B3");
				}else if(board[i][j]==game[1][b4])
				{
					System.out.print(" B4");
				}
				
				
				else if(board[i][j]==61 && game[2][r1]==0)
				{
					System.out.print(" R1");
				}
				else if(board[i][j]==62 && game[2][r2]==0)
				{
					System.out.print(" R2");
				}
				else if(board[i][j]==63 && game[2][r3]==0)
				{
					System.out.print(" R3");
				}
				else if(board[i][j]==64 && game[2][r4]==0)
				{
					System.out.print(" R4");
				}
				
				else if(board[i][j]==game[2][r1])
				{
					System.out.print(" R1");
				}else if(board[i][j]==game[2][r2])
				{
					System.out.print(" R2");
				}else if(board[i][j]==game[2][r3])
				{
					System.out.print(" R3");
				}else if(board[i][j]==game[2][r4])
				{
					System.out.print(" R4");
				}
				
				else if(board[i][j]==65 && game[3][g1]==0)
				{
					System.out.print(" G1");
				}
				else if(board[i][j]==66 && game[3][g2]==0)
				{
					System.out.print(" G2");
				}
				else if(board[i][j]==67 && game[3][g3]==0)
				{
					System.out.print(" G3");
				}
				else if(board[i][j]==68 && game[3][g4]==0)
				{
					System.out.print(" G4");
				}
				
				else if(board[i][j]==game[3][g1])
				{
					System.out.print(" G1");
				}else if(board[i][j]==game[3][g2])
				{
					System.out.print(" G2");
				}else if(board[i][j]==game[3][g3])
				{
					System.out.print(" G3");
				}else if(board[i][j]==game[3][g4])
				{
					System.out.print(" G4");
				}
				else
				{
					System.out.print(" * ");
				}
			}
			
			System.out.println();
			
		}
	
	}
}