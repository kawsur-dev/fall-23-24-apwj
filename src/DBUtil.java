import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    public static List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "abc"));
        persons.add(new Person(2, "def"));
        return persons;
    }
}
