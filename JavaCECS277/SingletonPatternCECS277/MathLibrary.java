public class MathLibrary {
	private MathLibrary() {}
	private static MathLibrary uniqueInstance;
	public synchronized static MathLibrary getInstance(){
	     if (uniqueInstance == null)
	            uniqueInstance = new MathLibrary();
	     return uniqueInstance;
	}
	
	public int someMathMethod() {
		return -1;
	}
	
	public double anotherMathMethod() {
		return 0;
	}
	public static void main(String[] args) {
		MathLibrary test = MathLibrary.getInstance();
		System.out.println(test.someMathMethod());
		System.out.println(test.anotherMathMethod());
	}
	
}


/**
 * Singleton.java
 *
 * The singleton pattern.
 *
 * Note - there are more efficient approaches than what is
 * being used here - notably the  double-checked locking idiom.
 */

/*public class Singleton
{
   private static Singleton instance;

   // declare the constructor as private which prevents object creation via new
   private Singleton() { }

   public static  Singleton getInstance() {
     if (instance == null) 
       instance = new Singleton();

     return instance;
   }
}*/
