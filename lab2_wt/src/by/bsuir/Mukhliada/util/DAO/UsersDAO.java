package by.bsuir.Mukhliada.util.DAO;

import by.bsuir.Mukhliada.util.BaseClasses.Users.User;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsersDAO extends DAO<User> {

    private static final String USERSFILE = "UsersDB.json";
    private static HashMap<Integer, User> users = new HashMap<>();

    @Override
    public void close() {
        saveDB(USERSFILE, users);
    }

    public UsersDAO() {
        users = loadDB(USERSFILE, new TypeToken<HashMap<Integer, User>>(){}.getType());
        if (users.size() == 0){
            User.setCount(0);
        } else {
            User.setCount(users.get(users.size() - 1).getId() + 1);
        }
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<User>(users.values());
    }

    @Override
    public User getEntityById(Integer id) {
        return users.get(id);
    }


    @Override
    public User update(User entity) {
        return users.replace(entity.getId(), entity);
    }

    @Override
    public boolean delete(Integer id) {
        if (users.remove(id) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean create(User entity) {

        users.put(entity.getId(), entity);

        if (entity.equals(getEntityById(entity.getId()))){
            return true;
        }

        return false;
    }
}
