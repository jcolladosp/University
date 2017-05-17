// CSD Jose Collado

 
public class Pool1 extends Pool0{//there cannot be kids alone
	int kids = 0;
	int instructors = 0;
    
    public synchronized long kidSwims(int id) {
		while(instructors<=0){
		  log.enterWait(id);
		  espera();
		  }
        
		kids++;
		notifyAll();
        return log.swims(id);
	}
	
	public synchronized long kidRests(int id) {
	    kids--;
		notifyAll();
		return log.rests(id);
	}
	
	public synchronized long instructorSwims(int id) { 
		instructors++;
		notifyAll();
		return log.swims(id);
	}
	
	public synchronized long instructorRests(int id) {
		while(kids>0){
		  log.leaveWait(id);
		  espera();
		  }
	    instructors--;
		notifyAll();
	    return log.rests(id);
	}

}