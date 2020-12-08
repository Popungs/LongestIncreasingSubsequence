package LIS;

import java.util.ArrayList;
import java.util.Random;

public class LIS {
	static final int arrSize = 100;
	public static void main(String[] args) {
		
		/*
		 * Input random 100 numbers range 0 to 99
		 * 
		 * Thought process of the LIS solution 
		 * 
		 * Allocate tabulation / memorization array full of 1 same size as the input array.
		 * 
		 * for example :
		 * 
		 * given array of input : call it arr
		 * 
		 * {1,4,10,21,22,8,6,3}; size : 8
		 * 
		 * memorization array : call it mem
		 * {1, 1,1 ,1 ,1 ,1 ,1, 1}; size : 8
		 * 
		 * 
		 * iterate through input array 
		 *  j  i
		 * {1,4,10,21,22,8,6,3} 
		 * 
		 * mem:
		 * {1, 1,1 ,1 ,1 ,1 ,1, 1};
		 * 
		 * i as outer loop starting from position 1. Because if array size is 1 then LIS is always will be 1.
		 * j as inner loop starting from position 0.
		 * If i = j then j increments and i increments
		 * 
		 * if arr[i] > arr[j] == true and mem[i] < mem[j] + 1 == true
		 * condition satifies so 
		 * mem[i]++;
		 * updated mem:
		 *  j i
		 * {1,2 ,1 ,1 ,1 ,1 ,1, 1}; 
		 *
		 * next iteration : i == j so i increments and j goes to 0
		 * j    i
		 * {1,4,10,21,22,8,6,3}
		 * 
		 * {1,2,1,1,1,1,1,1}; 
		 * 
		 * condition satisfies
		 * 
		 * update mem :
		 * {1,2,2,1,1,1,1,1};
		 * 
		 * next iteration:
		 *    j  i
		 * {1,4,10,21,22,8,6,3}
		 * 
		 * {1,2,2,1,1,1,1,1};
		 * condition satisfies
		 * 
		 * update mem:
		 * {1,2,3,1,1,1,1,1};
		 * 
		 * next ieration:
		 * 
		 * j       i 
		 * {1,4,10,21,22,8,6,3}
		 * {1,2,3,1,1,1,1,1};
		 * condition satisfies
		 * 
		 * update mem:
		 * {1,2,3,2,1,1,1,1};
		 * 
		 * next iteration :
		 *    j     i   
		 * {1,4,10,21,22,8,6,3}
		 * {1,2,3,  2,1,1,1,1};
		 * 
		 * condition satisfies 
		 * update mem:
		 * {1,2,3,3,1,1,1,1};
		 * 
		 *  next iteration :
		 *       j  i   
		 * {1,4,10,21,22,8,6,3}
		 * {1,2,3,  3,1,1,1,1};
		 * 
		 * condition satisfies 
		 * update mem:
		 * {1,2,3,4,1,1,1,1};
		 * 
		 * 
		 *  next iteration :
		 *  j         i
		 * {1,4,10,21,22,8,6,3}
		 * {1,2,3,4,1,1,1,1};
		 * 
		 * skip ahead couple iterations 
		 *          j i
		 * {1,4,10,21,22,8,6,3}
		 * condition satisfies 
		 * mem:
		 * {1,2,3,4,5,1,1,1};
		 * 
		 * skip ahead couple iterations 
		 *       j       i 
		 * {1,4,10,21,22,8,6,3}
		 * mem:
		 * {1, 2, 3, 4,  5, 3,1,1};
		 * 
		 * arr[i] > arr[j] == false
		 * so no change in memory
		 *
		 * There are some steps left to iterate but in this sample array 5 is the max length of LIS
		 * So we return LIS of 5 for this input array
		 * 
		 *
		 * 
		 */
		
		Random rand = new Random();
		System.out.println("printing example array");
		int fixed[] = new int[] {1,4,10,21,22,8,6,3};
		
		for (int i = 0; i < fixed.length; i++) {
			System.out.print(fixed[i]+ " ");
		}
		System.out.println();
		
		int resFixed = LISimp(fixed);
		System.out.println("output of example array : " + resFixed);
		
		int base[] = new int[arrSize];
		for (int i = 0; i < arrSize; i++) {
			int rand_int = rand.nextInt(100); // 0-99
			base[i] = rand_int;
		}
		
		
		
		System.out.println("printing input array");
		for (int i : base)
			System.out.print(i + " ");
		
		System.out.println();
		
	
		
		int res = LISimp(base);
		System.out.println("Longest Increasing Subsequence is : ");
		System.out.println("dynamic programming : " +res);
		
	
		
		
	}
	
	public static int LISimp(int arr[]) {
		int res = 0;
		if (arr.length <= 1) {
			return 1;
		}
		
		int LIS[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) 
			LIS[i] = 1; // populate with 1
 		
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (res < LIS[i]) {
				res = LIS[i];
			}
		}
		
		
		return res;
	}
	
}
