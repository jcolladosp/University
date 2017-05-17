class 22 {
	public static int max(int[] a){return max(a,a.length-1);}
	public static int max(int[] a,int b){
			if(b<=0) return a[0];
			else {
				int m = max(a,b-1);
				return (m>a[b])? m:a[b];
			}
	}
