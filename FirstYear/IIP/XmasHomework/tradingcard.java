import java.util.*;
public class tradingcard{
private int attack;
private int defense;
private String name;
private boolean deal;

public tradingcard(int a, int d, String n){attack=a; defense=d; name=n; deal=false;}
public boolean getDeal(){return deal; }
public void setDeal(boolean b){deal=b; } 
public static void main(String[] args) {
 tradingcard[] cards;
 tradingcard[] hand1;
 tradingcard[] hand2;
 int ran;
 int temp;
 int att;
 int def;
 String nam;
	String player1;
	String player2;
	boolean repartir;
	int jugador = 0;
	Scanner kbd = new Scanner(System.in).useLocale(Locale.US);
//settings

System.out.println("Name for player 1:");
player1 = kbd.nextLine();
	
System.out.println("Name for player 2:");
player2 = kbd.nextLine();

System.out.println("How many cards do you want?(even number)");
temp = kbd.nextInt();
if(temp%2 != 0){ 
	System.out.println("Invalid number of cards");
	while (temp%2 != 0) {
		System.out.println("How many cards do you want?(even number)");
	temp = kbd.nextInt();
		}
}
cards = new tradingcard[temp];

//card creation
for (int count=0;count<cards.length;count++ ) {
	System.out.println("Card number "+(count+1));
	System.out.println("Attack for that card");
	att = kbd.nextInt();
	System.out.println("Defense for that card");
	def = kbd.nextInt();
	nam = kbd.nextLine();
	System.out.println("Name for that card");
	nam = kbd.nextLine();
	cards[count] = new tradingcard(att,def,nam);
}

//card deal
hand1 = new tradingcard[(cards.length)/2];
hand2 = new tradingcard[(cards.length)/2];
int pos =0;
for (int countxd = 0;countxd < cards.length ;countxd++ ) {
	repartir = true;
	while(repartir == true){
		ran = (int) Math.round(Math.random()*(cards.length-1));
		if(cards[ran].getDeal() == false){
			
			repartir = false;
			cards[ran].setDeal(true);
			if(jugador == 0){
				hand1[pos] = new tradingcard(cards[ran].attack, cards[ran].defense, cards[ran].name) ; 
				jugador = 1;
			}
			else if (jugador == 1) {
					hand2[pos] = new tradingcard(cards[ran].attack, cards[ran].defense, cards[ran].name);
					jugador =0;
					pos++;
				}	
		}
	}
}
		
//start the battle
		int result1 = 0;
		int result2 = 0;
		for (int count2 = 0;count2 < (hand1.length) ;count2++ ) {
		System.out.println("______________________________________________");
		System.out.println(player1 + " plays " + hand1[count2].name +"("+hand1[count2].attack + "/" + hand1[count2].defense + ")");
		System.out.println(player2 + " plays " + hand2[count2].name +"("+hand2[count2].attack + "/" + hand2[count2].defense + ")");	
		if (hand1[count2].attack >= hand2[count2].defense && hand2[count2].attack < hand1[count2].defense ) { 
			System.out.println(player1 + " wins the battle");
			result1++;			
		}
		else if (hand2[count2].attack >= hand1[count2].defense && hand1[count2].attack < hand2[count2].defense) {
			System.out.println(player2 + " wins the battle");
			result2++;	}	
		else {System.out.println("Both cards died. There's a draw");}		
		System.out.println("______________________________________________");	
		}
		System.out.println(" Final Result -> " + player1 + ":" +result1 + " - " + player2 + ":" + result2);
		}

	}
	




	
