package array;

//Java implementation of the approach 
import java.util.Arrays; 

public class SumString { 

	// Function to return the lexicographically 
	// smallest string of length n that 
	// satisfies the given condition 
	public static char[] lexo_small(int n, int k) 
	{ 
		char arr[] = new char[n]; 

		Arrays.fill(arr, 'a'); 

		// Iteration from the last position 
		// in the array 
		for (int i = n - 1; i >= 0; i--) { 

			k -= i; 

			// If k is a positive integer 
			if (k >= 0) { 

				// 'z' needs to be inserted 
				if (k >= 26) { 
					arr[i] = 'z'; 
					k -= 26; 
				} 

				// Add the required character 
				else { 
					arr[i] = (char)(k + 97 - 1); 
					k -= arr[i] - 'a' + 1; 
				} 
			} 

			else
				break; 

			k += i; 
		} 

		return arr; 
	} 

	public static String lexo(int n, int k){ 
		
		char[] store="abcdefghijklmnopqrstuvwxyz".toCharArray();

    char[] arr=new char[n];
 //   Arrays.fill(arr,'a');
    for(int i=n-1;i>=0;i--){
        k-=i;
        if(k>=0){

            if(k>=26){
                arr[i]=store[25];
                k-=26;
            }else{
                arr[i]=store[k-1];
                k-=arr[i]-store[0]+1;
            }

        }else
            break;

        k+=i;

//       System.out.println(arr[i]+" at "+i);
    }
    return new String(arr);}
	// Driver code 
	public static void main(String[] args) 
	{ 
		int n = 5, k = 42; 

		char arr[];// = lexo_small(n, k); 
		
		String x=lexo(n,k);

		System.out.print(x); 
	} 
} 
