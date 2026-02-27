package stazhirovka;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final String url = "jdbc:postgresql://localhost:5432/Users";
    private final String user = "postgres";
    private final String password = "414141";

    public List<User> findAll() {
        List<User> usersList = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(url, user, password)) {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT id, name, programming_language, stack FROM users");
            while (rs.next()) {
                usersList.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("programming_language"),
                        rs.getString("stack")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public void save(User u) {
        try (Connection c = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO users (name, programming_language, stack) VALUES (?, ?, ?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getProgrammingLanguage());
            ps.setString(3, u.getStack());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try (Connection c = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps =
                    c.prepareStatement("DELETE FROM users WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateLanguage(int id, String language) {
        try (Connection c = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps =
                    c.prepareStatement("UPDATE users SET programming_language = ? WHERE id = ?");
            ps.setString(1, language);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStack(int id, String stack) {
        try (Connection c = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps =
                    c.prepareStatement("UPDATE users SET stack = ? WHERE id = ?");
            ps.setString(1, stack);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
