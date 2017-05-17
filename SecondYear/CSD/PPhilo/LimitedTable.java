// CSD Mar 2016 Jose Collado
 
public class LimitedTable extends RegularTable { //max 4 in dinning-room
	int nphilo;

	public LimitedTable(Log log) {

		super(log);
		nphilo = 0;
	}


	public synchronized void enter(int id) {
		if (nphilo>=4){
			log.wenter(id);
			waiting();
		}
		nphilo++;
		log.enter(id);
	}
	public synchronized void exit(int id)  {
		nphilo--;

		if(nphilo==4){notifyAll();}


		log.exit(id);

	}
}
