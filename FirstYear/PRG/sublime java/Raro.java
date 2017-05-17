class Raro {
/** n>=0 */
public static int act5(int a, int b) {

if (a<b) return 0;

else return act5(a-b,b)+1;
}
public static void main(String[] args) { act5(10,2); }
}