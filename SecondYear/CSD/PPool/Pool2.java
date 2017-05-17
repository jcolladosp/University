// CSD Jose Collado

 

public class Pool2 extends Pool1{ //max kids/instructor
	@Override
    public synchronized long instructorRests(int id) {
        while(kids > log.maxKI() * (instructors - 1)) {
            log.leaveWait(id);
            espera();
        }
        
        instructors--;        
        return log.rests(id);
    }

    @Override
    public synchronized long kidSwims(int id) {
        while (kids + 1 > log.maxKI() * instructors) {
            log.enterWait(id);
            espera();
        }
        
        kids++;        
        return log.swims(id);
    }
}

