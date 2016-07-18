package com.business.data;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by zakaria on 18/07/2016.
 */
public abstract class DAO {

    /**
     * Constante representant le nom d'unité de persistence à utiliser (déclarée dans le fichier persistence.xml)
     **/
    private static final String _PERSISTENCE_UNIT = "MarsaMaroc";

    /**
     * Instance unique de type EntityManager
     **/
    private static EntityManager _EM = null;

    /**
     * Cette méthode permet d'initialiser et récupérer l'instance unique de type EntityManager.
     * @return   instance EntityManager
     * @see EntityManager
     */
    public synchronized static EntityManager getEntityManager(){
        if(_EM!=null) return _EM;
        _EM = Persistence.createEntityManagerFactory(_PERSISTENCE_UNIT).createEntityManager();
        return _EM;
    }
}
