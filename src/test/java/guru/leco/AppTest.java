package guru.leco;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void changeNumberInStream() throws InterruptedException {

        List<Integer> numbers = Arrays.asList(2, 3, 4, 6, 7);

        final Integer[] multiples = {2};

        Stream<Integer> numberStreams = numbers
                .stream()
                .map(integer -> integer * multiples[0]);

        Thread.sleep(10000);

        multiples[0] = 3;

        numberStreams.forEach(System.out::println);
    }

}
