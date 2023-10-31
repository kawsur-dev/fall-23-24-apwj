import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBUtil {

    static List<Person> persons = new ArrayList<>();

    public static List<Person> getAll() {
        return persons;
    }

    public static void create(Person p) {
        persons.add(new Person(p.getId(), p.getName()));
    }

    public static void update(Person p) {
        persons.stream()
                .filter(person -> p.getId() == person.getId())
                .findFirst()
                .ifPresent(person -> person.setName(p.getName()));
    }

    public static void delete(int id) {
        persons = persons.stream()
                .filter(person -> id != person.getId())
                .collect(Collectors.toList());
    }
}
