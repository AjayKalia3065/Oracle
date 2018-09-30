package com.interview;

public class MethodOverLoadingParent {

	public MethodOverLoadingParent(int x){
		System.out.println("x Parent called");
	}
	public MethodOverLoadingParent(){
		System.out.println("Parent called");
	}
	public int addd(int i ,int j)
	{
		return i+j;
	}
	public long add(long i ,long j)
	{
		return i+j+1;
	}
}
