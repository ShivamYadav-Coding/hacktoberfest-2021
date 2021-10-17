class Robots 
{
	void fun1 ()
	{
	
		
		System.out.print("\n\n\n\t\t\t\t");
		
		for(int a=0; a<12; a++) {
			System.out.print("*");
		}
		System.out.println();
		for(int b=0; b<4; b++) {
			System.out.println("\t\t\t\t*\t   *");
		}
		System.out.print("\t\t\t\t");
		for(int c=0; c<12; c++) {
			System.out.print("*");
		}
		System.out.println();
		for(int d=0; d<3; d++) {
			System.out.println("\t\t\t\t   *   *");
		}
		System.out.print("\t\t\t  ");
		for(int e=0; e<24; e++) {
			System.out.print("*");
		}
		System.out.println();
		for(int f=0; f<8; f++) {
			System.out.println("\t\t\t  *\t\t\t *");
		}
	
		System.out.print("\t\t\t  ");
		for(int g=0; g<24; g++) {
			System.out.print("*");
		}
		System.out.println();
		for(int h=0; h<6; h++) {
			System.out.println("\t\t\t   |  |\t\t     |  |");
		}
		System.out.print("\t\t\t  /   |\t\t    /   |");
		System.out.print("\n\t\t         /\t\t   /");
		System.out.println();
		System.out.print("\t\t\t ");
		//System.out.println();
		for(int i=0; i<6; i++){
			System.out.print("@");
		}
		System.out.print("\t\t   ");
		for(int j=0; j<6; j++) {
			System.out.print("@");
		}
		System.out.println();

		//return z;
	}
}
 
 class stop
 {
 	public static void main(String[] args) {
 	//int z;
 	Robots objb = new Robots();
 	objb.fun1();
 	//System.out.println(z);	

 	}
 }