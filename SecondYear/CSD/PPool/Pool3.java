// CSD feb 2015 Juansa Sendra
 

public class Pool3  extends Pool2 { //max capacity
    @Override
    public synchronized long instructorSwims(int id) { 
		while((kids+instructors) >= log.capacity()) {
            log.enterWait(id);
            espera();
        }
        instructors++;
		notifyAll();
		return log.swims(id);
	}


    @Override
    public synchronized long kidSwims(int id) {
        while ((kids + 1 > log.maxKI() * instructors) || (kids+instructors)>= log.capacity()) {
            log.enterWait(id);
            espera();
        }
        
        kids++;
        notifyAll();
        return log.swims(id);
    }
    
    
}