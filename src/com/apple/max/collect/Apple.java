package com.apple.max.collect;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Apple {
public static void main(String[] args) {

	/** JDK 1.8 */
	
	/**
	 * Problem Description: 
	 * 
	 * collect max apples in a garden with 'N' number of trees where two kids where they choose 'K' trees, 
	 * 'L' trees consecutively without colloid each other and collect maximum possible apple collection.
	 * 
	 * return -1/ (no apples) collected when no enough trees are available in garden to collect for each kid's allocated trees
	 * . 
	 */
	Apple apple = new Apple();
	int[] A= {5,2,7,9,1,6};
	
	int maxApples = apple.garden(A, 2, 2);
	/** OUT COME/RESULT */
	System.out.println("max apple collected:: "+maxApples);
}
/**
 * 
 * @param A - presened 'N' number of trees having apples.
 * @param K - kid name is K, how can walk through tree and collect apples
 * @param L - kid name is L, how can walk through tree and collect apples
 * @return
 */
public int garden(int[] A, int K, int L) {
	int maxApp = 0;
	int maxKApp = 0;
	int maxLApp = 0;
	
    if(A.length< (K+L)){
        return -1;
    }else{
    	
    	for (int i = 0; i <= A.length - (K+L); i++) {
    		int[] mrcK = Arrays.copyOfRange(A, i, (i+K));
    		maxKApp = IntStream.of(mrcK).sum();
			for (int j = (i+K); j <= A.length -L; j++) {
				int[] mrcL = Arrays.copyOfRange(A, j, (j+L));
				maxLApp = IntStream.of(mrcL).sum();
				if(maxApp<=(maxKApp+maxLApp)){
					maxApp = maxKApp+maxLApp;
				}
					
			}
		}//for
    	
       	for (int i = A.length; i >= K; i--) {
    		int[] mrcK = Arrays.copyOfRange(A,  (i-K), i);
    		maxKApp = IntStream.of(mrcK).sum();
			for (int j = i-K; j >= L; j--) {
				int[] mrcL = Arrays.copyOfRange(A, (j-L),(j));
				maxLApp = IntStream.of(mrcL).sum();
				if(maxApp<=(maxKApp+maxLApp)){
					maxApp = maxKApp+maxLApp;
				}
			}
		}//for
    }
    
    return maxApp;
}
}


