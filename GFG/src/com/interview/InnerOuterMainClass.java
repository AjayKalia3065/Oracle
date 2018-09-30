package com.interview;

import java.util.HashSet;

public class InnerOuterMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InnerClassOuterClass OBJ = new InnerClassOuterClass();
		OBJ.new InnerClass();
		new InnerClassOuterClass.StaticInnerClass();
		HashSet set = new HashSet();
	}

}
