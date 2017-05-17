public void insertar(E e){
	int vecesinser = 0;


	inicio();
	while(!esFin()){
		if(recuperar.compareTo(e)<0){
			siguente();
			super.insertar(e);
			vecesinser++;

		}
		else siguente();


	}
	if(vecesinser ==0) super.insertar(e);

}

public int detector(String[] v,int left, int rigth){
	if()


}