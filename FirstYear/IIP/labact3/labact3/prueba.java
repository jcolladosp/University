import java.util.*;
public class prueba {

	public static void main(String[] args) {
			int min, h, m;
			Scanner kbd = new Scanner(System.in).useLocale(Locale.US);
			System.out.println("hola");
			min = kbd.nextInt();
			h=(min/60);
			m=(min%60);
			System.out.println(h + ":" + m);
			

	}

}
