// CSD Jose Collado
 

public class Pool0 implements Pool {    //free access
    Log log;
    public void make(Log log0)          {log=log0;}
    
    public  long begin(int id)          {return log.begin(id);}
    public  void end(int id)    {log.end(id);}
    
    
    public synchronized long kidSwims(int id) {
        return log.swims(id);
    }
    
    public synchronized long kidRests(int id) {
        return log.rests(id);
    }
    
    public synchronized long instructorSwims(int id) {
        return log.swims(id);
    }
    
    public synchronized long instructorRests(int id) {
        return log.rests(id);
    }
    public void espera(){
        try {   
            wait();}
        catch   (Exception  e)  {}
    }
}