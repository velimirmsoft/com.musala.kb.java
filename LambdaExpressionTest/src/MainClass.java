public class MainClass {

	public static void main(String[] args) {
		
		// without lambda expression
		// so here, we create a annonymous class and method in it
		
		MathOperation addition = new MathOperation() {
			public int operation(int a, int b) {
				return a + b;	
			}
		};
		System.out.println("" + addition.operation(1, 1));
		
		// with lambda expression
		// in java 8 previous code can be reduced by a lot ...
		
		MathOperation addition_ = (int a, int b) -> a + b;
		System.out.println("" + addition_.operation(1, 1));

	}

}
