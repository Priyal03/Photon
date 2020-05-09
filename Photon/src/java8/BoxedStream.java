package java8;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxedStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> intStream = IntStream.of(1,2,3,4,5,6).boxed().collect(Collectors.toList());
		System.out.println(intStream);
		
		Optional<Integer> max = IntStream.of(1,2,3,4,5,6).boxed().max(Integer::compareTo);
		
		max.ifPresent(System.out::println);
		
	}

}
