package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import java.util.*;

public class CacheHolder extends ArrayList<Cache> {

    /**
     * Récupère le cache à partir de son id
     * @param idCache
     * @return cache si id trouvé, sinon null
     */
    public Cache getCacheById(int idCache){
        for(Cache cache : this){
            if(cache.getId() == idCache)
                return cache;
        }
        return null;
    }

    /**
     * Ajoute le cache à l'arraylist CacheHolder
     * @param cache
     * @return boolean true si ajouté, faux si déjà dans l'arraylist
     */
    public boolean addCache(Cache cache){
        if(this.contains(cache))
            return false;
        else{
            return this.add(cache);
        }
    }
}
