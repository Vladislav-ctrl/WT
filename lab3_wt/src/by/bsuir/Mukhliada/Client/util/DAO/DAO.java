package by.bsuir.Mukhliada.Client.util.DAO;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Users.User;

import java.util.List;

public abstract class DAO<E> {
    public abstract List<E> getAll();

    public abstract E getEntityById(Integer id);

    public abstract E update(E entity, User user);

    public abstract boolean delete(Integer id, User user);

    public abstract boolean create(E entity, User user);

    public abstract void close();
}
