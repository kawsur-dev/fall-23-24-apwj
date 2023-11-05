import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBUtil {

    public static List<Person> getAll() throws SQLException, ClassNotFoundException {
        List<Person> persons = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        String sql = "SELECT id, name FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            persons.add(new Person(resultSet.getInt(1), resultSet.getString(2)));
        }
        return persons;
    }

    public static void create(Person p) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        String sql = "INSERT INTO users SET id = ?, name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, p.getId());
        preparedStatement.setString(2, p.getName());
        preparedStatement.execute();
    }

    public static void update(Person p) {

    }

    public static void delete(int id) {

    }
}
