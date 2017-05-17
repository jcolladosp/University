public class exercise1 extends Thread{
    int dick;
    public exercise1 (int dick){this.dick = dick;}
    public void run(){
        System.out.println("Allahu akbar");
        try{sleep(10);}
        catch(InterruptedException e){}
    }
    public static void main (String[]args){
        for(int k=0;k<10;k++){
            exercise1 e = new exercise1(k);
            e.start();
            System.out.println("ring ring");
        }
    }
}
