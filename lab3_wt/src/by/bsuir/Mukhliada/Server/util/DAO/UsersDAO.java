package by.bsuir.Mukhliada.Server.util.DAO;


import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;
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
            Integer[] keys = new Integer[users.size()];
            users.keySet().toArray(keys);
            User.setCount(keys[keys.length - 1] + 1);
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
        return users.remove(id) != null;
    }

    @Override
    public boolean create(User entity) {

        users.put(entity.getId(), entity);

        return entity.equals(getEntityById(entity.getId()));
    }
}
