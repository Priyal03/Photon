package microfocus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BalancedParenthesis {

	public static List<Integer> balancedOrNot(List<String> expressions, List<Integer> maxReplacements) {
		// Write your code here
		List<Integer> res = new ArrayList<Integer>();
		int nLeft = 0, nRight = 0, j = 0;

		List<Character> freq = null;

		Iterator<String> it = expressions.listIterator();
		while (it.hasNext()) {

			String exp = it.next();
			freq = new ArrayList<Character>();
			char arr[] = exp.toCharArray();

			for (int i = 0; i < arr.length; i++) {

				if (arr[i] == '<') {
					freq.add('<');
					nLeft++;
				} else if (arr[i] == '>') {

					if (freq.contains('<')) {
						freq.remove(Character.valueOf('<'));
						nLeft--;
					} else {
						freq.add('>');
						nRight++;
					}
				}
			}

			int size = freq.size();

			int rep = maxReplacements.get(j);

			System.out.println(size + " " + rep + " " + j + " " + exp + " " + nLeft + " " + nRight);

            if(nLeft>0 && nRight==0){
                res.add(0);
            }else if(size>rep) {
                res.add(0);
            }else if(size<=rep) {
            	
            	
                res.add(1);
            }

			j++;
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int expressionsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> expressions = IntStream.range(0, expressionsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(Collectors.toList());

		int maxReplacementsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> maxReplacements = IntStream.range(0, maxReplacementsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> result = balancedOrNot(expressions, maxReplacements);
		System.out.println("------------- answes ----------");

		for (int res : result) {
			System.out.print(res + " ");
		}
	}
}