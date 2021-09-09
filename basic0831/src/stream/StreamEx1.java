package stream;

import java.util.stream.Stream;

public class StreamEx1 {
	
	public static void main(String[] args) {
		Stream<Green> greenStream = Stream.of(
				new Green(34,24,26,17),
				new Green(13,224,216,217),
				new Green(364,254,226,173),
				new Green(374,284,926,217),
				new Green(314,243,216,117)
				);
	}
}
