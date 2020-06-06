package microfocus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LongestSubArray {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int aCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		int result = maxLength(a, k);

		System.out.println(result);

	}
//find the longest sub array that summed up to be less or equals to k
	public static int maxLength(List<Integer> arr, int k) {
		
	//	System.out.println(k);

		int n=arr.size();
		int sum = 0; 
        int cnt = 0, maxcnt = 0; 
      
        for (int i = 0; i < n; i++) { 
              
            // If adding current element doesn't 
            // cross limit add it to current window 
            if ((sum + arr.get(i)) <= k) { 
                sum += arr.get(i);  
                cnt++; 
            }  
      
            // Else, remove first element of current 
            // window. 
            else if(sum!=0) 
           { 
            sum = sum - arr.get(i-cnt) +arr.get(i);
           } 
      
            // keep track of max length. 
            maxcnt = Math.max(cnt, maxcnt);  
        } 
        return maxcnt; 
	}

}
