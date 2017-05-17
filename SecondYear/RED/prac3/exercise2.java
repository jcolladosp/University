public class exercise2 extends Thread{
    int dick;
    String s;
    public exercise2 (int dick, String s){this.dick = dick; this.s = s;}
    public void run(){
        System.out.println(s);
        try{sleep(100);}
        catch(InterruptedException e){}
    }
    public static void main (String[]args){
        for(int k=0;k<10;k++){
            String s = "This is thread :" +k;
            exercise2 e = new exercise2(k,s);
            e.start();
        }
    }
}


