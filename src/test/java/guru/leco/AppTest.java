package guru.leco;

import guru.leco.domain.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

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

    @Test
    public void streamsGroupBy() {

        List<User> users = Arrays.asList(new User("Leandro", 26), new User("Marcos", 19), new User("Juliana", 26));

        users.stream().collect(groupingBy(User::getAge)).forEach((integer, items) -> {
            StringBuilder builder = new StringBuilder();
            builder.append("Quantidade : ");
            builder.append(items.size());
            builder.append(" Age: ");
            builder.append(integer);
            System.out.println(builder.toString());
        });
    }

    @Test
    public void streamFilter() {
        List<User> users = Arrays.asList(new User("Leandro", 26), new User("Marcos", 19), new User("Juliana", 26));
        users.stream()
                .filter(user -> user.getAge() > 20)
                .forEach(user -> {
                    System.out.println(user.getName());
                });
    }

    @Test
    public void streamParallelStream() {
        List<User> users = Arrays.asList(new User("Leandro", 26), new User("Marcos", 19), new User("Juliana", 26));
        users.stream()
                .filter(user -> user.getAge() > 20)
                .parallel()
                .forEach(user -> System.out.println(user.getName()));
    }



}
