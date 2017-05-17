public class updclient{
        public static void main(String[]args){

            //kbd declaration//
            
            DatagramSocket clientSocket = new DatagramSocket();
            int p = clientSocket.getLocalPort();

            InetAddress IPAdress = InetAdress.getByName("localhost");

            String sentence = kbd.nextLine();
            DatagramPacket sendPacket = new DatagramPacket(sentence.getBytes(), sentence.getBytes().length, IPAdress, 7777);
            clientSocket.send(sendPacket);

            byte[] receiveDataBuffer = new byte[512];
            DatagramPacket receivePacket = new DatagramPacket(receiveDataBuffer, receiveData.length);

            clientSocket.recieve(recievePacket);

            String modifiedSentence = new String(receivePacket.getData(),0,receivePacket.getLength());

            s.o.p("From Server:" +modifiedSentence);
            clientSocket.close();
        }
}
