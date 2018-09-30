package com.interview;

public class MethodOverloadingChild extends MethodOverLoadingParent {

	public MethodOverloadingChild(){
		System.out.println("child called");
	}
	public MethodOverloadingChild(int x){
		super(x);
		System.out.println("x child called");
	
	}
	public long add(int x, int y)
	{
		super.add(x, y);
		System.out.println("int int ");
		return (long)(x+y);
	}
	private static int addS(int x,int y)
	{
		System.out.println("Static parent");
		return x+y;
	}
	/*public long add(long x, long y)
	{
		System.out.println("long long ");
		return (long)(x+y);
	}*/
	public long add(Long x, Long y)
	{
		System.out.println("LONG LONG ");
		return (long)(x+y);
	}
}
