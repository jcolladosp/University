// CSD Jose Collado

 

public class Pool4 extends Pool3 { //kids cannot enter if there are instructors waiting to exit
    int esperando = 0;
    @Override
    public synchronized long instructorRests(int id) {
         esperando++;
        while(kids>0){
          log.leaveWait(id);
          espera();
         
          }
        
        esperando--; 
        instructors--;
        notifyAll();
        return log.rests(id);
    }

    
    @Override
    public synchronized long kidSwims(int id) {
        while ((kids + 1 > log.maxKI() * instructors) || (kids+instructors)>= log.capacity() || esperando!=0) {
            log.enterWait(id);
            espera();
        }
        
        kids++;
        notifyAll();
        return log.swims(id);
    }
    
}
