package by.bsuir.Mukhliada.util.DAO;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public abstract class DAO<E> {

    public HashMap<Integer, E> loadDB(String filename, Type type) {
        Gson gson = new Gson();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)))
        {
            return gson.fromJson(bufferedReader, type);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return new HashMap<Integer, E>();
        }
    }

    public boolean saveDB(String filename, HashMap<Integer, E> map){
        Gson gson = new Gson();
        String JSON = gson.toJson(map);
        boolean operationSuccessful;

        try(FileWriter writer = new FileWriter(filename, false))
        {
            writer.write(JSON);
            operationSuccessful = true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            operationSuccessful = false;
        }

        return operationSuccessful;
    }

    public abstract List<E> getAll();

    public abstract E getEntityById(Integer id);

    public abstract E update(E entity);

    public abstract boolean delete(Integer id);

    public abstract boolean create(E entity);

    public abstract void close();
}
