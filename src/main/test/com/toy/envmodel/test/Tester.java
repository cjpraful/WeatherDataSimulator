package com.toy.envmodel.test;

import java.util.Random;

public class Tester {

public static void main(String[] args) {
	System.out.println("Test!");
	Random random = new Random();
	double avgval= 17.0;
	double sum = 0.0;
	for(int i=0;i<31;i++){
		//random.setSeed((long)avgval);
		//mean of avgval and sd of 0.5
		avgval= 17.0;
		avgval = avgval+random.nextGaussian()*2;
		sum = sum + avgval;
	System.out.println(String.format("%.2f", avgval));
	}
	System.out.println("Avg::" + sum/31);
}
	
}
