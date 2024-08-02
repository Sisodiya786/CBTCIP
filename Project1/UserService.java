package Project1;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean register(String username, String password, String email) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password, email));
        return true;
    }

    public boolean updateProfile(String username, String newEmail) {
        User user = users.get(username);
        if (user != null) {
            user.setEmail(newEmail);
            return true;
        }
        return false;
    }

    public boolean changePassword(String username, String currentPassword, String newPassword) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(currentPassword)) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }
}
