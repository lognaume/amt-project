package ch.heigvd.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import ch.heigvd.model.entities.KebabShop;

/**
 * 
 * @author Guillaume Milani & Maxime Guillod
 */
@Singleton
public class InMemoryDataStore implements InMemoryDataStoreLocal {

    private final HashMap<Integer, KebabShop> dataStore = new HashMap();
    private int kebabShopsCounter = 0;

    public InMemoryDataStore() {
        insertKebabShop(new KebabShop("Dylan", "Grand-Rue 1", "Yverdon", "Switzerland", "0", "today", 9.85f));
        insertKebabShop(new KebabShop("Galaxi", "Temple 10", "Renens", "Switzerland", "0", "today", 9.90f));
        insertKebabShop(new KebabShop("Olivier d'Orient", "Grand-Rue 5", "Yverdon", "Switzerland", "0", "today", 12f));
        insertKebabShop(new KebabShop("Star Kebab", "Av. de la Gare", "Moudon", "Switzerland", "0", "today", 8.65f));
    }

    @Override
    public int insertKebabShop(KebabShop kebabShop) {
        dataStore.put(kebabShopsCounter++, kebabShop);
        return kebabShopsCounter - 1;
    }

    @Override
    public KebabShop findKebabShop(int id) throws IndexOutOfBoundsException {
        if (!dataStore.containsKey(id)) {
            throw new IndexOutOfBoundsException();
        } else {
            return dataStore.get(id);
        }
    }

    @Override
    public List<KebabShop> findAllKebabShops() {
        return new ArrayList(dataStore.values());
    }

}
