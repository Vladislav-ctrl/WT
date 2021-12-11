package by.bsuir.Mukhliada.Server.util.DAO;

import by.bsuir.Mukhliada.Client.util.BaseClasses.Dossiers.Dossier;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DossiersDAO extends DAO<Dossier> {
    private static final String DOSSIERSDB = "DossiersDB.json";
    private static HashMap<Integer, Dossier> dossierHashMap = new HashMap<>();

    @Override
    public void close() {
        saveDB(DOSSIERSDB, dossierHashMap);
    }

    public DossiersDAO() {
        dossierHashMap = loadDB(DOSSIERSDB, new TypeToken<HashMap<Integer, Dossier>>(){}.getType());
        if (dossierHashMap.size() == 0){
            Dossier.setCount(0);
        } else {

            Integer[] keys = new Integer[dossierHashMap.size()];
            dossierHashMap.keySet().toArray(keys);
            Dossier.setCount(keys[keys.length - 1] + 1);
        }
    }

    @Override
    public List<Dossier> getAll() {
        return new ArrayList<Dossier>(dossierHashMap.values());
    }

    @Override
    public Dossier getEntityById(Integer id) {
        return dossierHashMap.get(id);
    }

    @Override
    public Dossier update(Dossier entity) {
        return dossierHashMap.replace(entity.getDossierID(), entity);
    }

    @Override
    public boolean delete(Integer id) {
        if (dossierHashMap.remove(id) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean create(Dossier entity) {
        dossierHashMap.put(entity.getDossierID(), entity);

        if (entity.equals(getEntityById(entity.getDossierID()))){
            return true;
        }

        return false;
    }
}
