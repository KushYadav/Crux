package com.example.hp.crux.functions;

public class Functions {

	private static int GLOBAL = 20;

	public static void main(String[] args) {
		//Part_1 - Normal Function
		System.out.println("Hello World");
		helloFun();
		
		//Part_2 - Multiple Calls	
		System.out.println("Hello World");
		helloFun();
		System.out.println("Hello World");
		helloFun();
		
		//Part_3 - Multiple Functions
		System.out.println("Hello World");
		helloFun();
		helloGun();
		
		//Part_4 - Function making call to Another Function
		System.out.println("Hello World");
		helloNestedFun();
		System.out.println("Hello World");
		helloNestedFun();

		
		//Part_5 - Functions with Parameters
		System.out.println("Hello World");
		helloFunWithParams("Hello from Main");
		
		//Part_6 - Function with return value
		System.out.println("Hello World");
		String get=helloFunWithReturns("Hello from Main");
		System.out.println(get);
				
		//Part_7 - Function to demo Scope of Variables
		System.out.println("Hello World");
		int one = 10, two = 20;
		System.out.println(GLOBAL);
		int GLOBAL=200;
		System.out.println(GLOBAL);
		System.out.println(Functions.GLOBAL);
		System.out.println(globalScope(one));
		
		//Part_8 - Scope in Blocks
		System.out.println("Hello World");
		if(one< two) {
//			int one=20;
			int three=30;
		}
//		System.out.println(three);
		
		//Part_9 - Pass by Value
		System.out.println("Hello World");
		System.out.println(one+","+two);
		swap(one, two);
		System.out.println(one+","+two);
	}

	private static void swap(int one, int two) {
		System.out.println(one + "," + two);
		int temp = one;
		one = two;
		two = temp;
		System.out.println(one + "," + two);
	}

	private static int globalScope(int one) {
		int sum = one + GLOBAL;
		return sum;
	}

	private static int scope(int one, int another) {
//		int one=10;
//		int sum=one+two;
		int sum = one + another;
		return sum;
	}
	
	private static String helloFunWithReturns(String msg) {
		String sendBack="I did your work";
		helloFunWithParams(msg);
		return sendBack;
	}
	
	private static void helloFunWithParams(String msg) {
		System.out.println("Your msg is: "+msg);
	}
	
	private static void helloNestedFun() {
		System.out.println("Hello Nested Fun");
		helloFun();
		System.out.println("Hello Nested Fun");
		helloGun();
	}
	
	private static void helloFun(){
		System.out.println("Hello Fun");
	}
	
	private static void helloGun(){
		System.out.println("Hello Gun");
	}

}
