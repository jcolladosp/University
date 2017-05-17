import java.util.*;
public class CardGame{
	public static void main(String[] args) {
		int att1;
		int def1;
		int att2;
		int def2;
		String nam1;
		String nam2;
		Scanner kbd = new Scanner(System.in).useLocale(Locale.US);
		System.out.println("name for 1º card");
		nam1 = kbd.nextLine();
		System.out.println("name for 2º card");
		nam2 = kbd.nextLine();
		System.out.println("attack for 1º card");
		att1 = kbd.nextInt();
		System.out.println("attack for 2º card");
		att2 = kbd.nextInt();
		System.out.println("defense for 1º card");
		def1 = kbd.nextInt();
		System.out.println("defense for 2º card");
		def2 = kbd.nextInt();
		if (att1 >= def2) { System.out.println("card 1 is the winner");}
		else if (att2 >= def1) {System.out.println("card 2 is the winner");	}
	}
}