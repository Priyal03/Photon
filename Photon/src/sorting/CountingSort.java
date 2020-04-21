package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		int max = Arrays.stream(arr).max().getAsInt();
		int freq[] = new int[max + 1]; //adding 1 for 0th index

		for(int value : arr) 
			++freq[value]; // this is what they call is filling buckets.
		
		for(int i=0;i<=max;i++) {
			while(freq[i]-->0) {
				System.out.print(i+" ");
			}
		}
		scanner.close();
	}
}
