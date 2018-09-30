package com.interview;

public class InnerClassOuterClass {

	static int x=10;
	private static int y = 20;
	int z=30;
	private int a = 40;
	
	class InnerClass{
		int b =2;
		private int c = 3;
		static final int d= 4;
		private int e =5;
		public int f=7; 
		void print(){
			System.out.println(x + y + z+a+b+c+d+e+f);
		}
	}
	 static class StaticInnerClass{
		int b =2;
		private int c = 3;
		static int d= 4;
		private int e =5;
		public int f=7; 
		void print(){
			System.out.println(x + y /*+ z+a*/+b+c+d+e+f);
		}
	}
	void print(){
		//there can be multiple inner classes and can have same name variable 
		//in different inner class.. so which one to access: problem
		System.out.println(x + y + z+a/*+b+c+d+e + f*/);
	}
}
