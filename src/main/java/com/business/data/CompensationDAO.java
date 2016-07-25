package com.business.data;

import com.business.model.Compensation;
import com.utilities.ExceptionHandler;

import java.util.List;

/**
 * Created by zakaria on 25/07/2016.
 */
public abstract class CompensationDAO {

    public synchronized static String insertCompensation(Compensation comp){
        try{
            DAO.getEntityManager().getTransaction().begin();
            DAO.getEntityManager().persist(comp);
            DAO.getEntityManager().getTransaction().commit();
            return comp.getCompId()+"";
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while inserting User",e);
            return null;
        }
    }

    public static String updateCompensation(Compensation comp){
        try {
            DAO.getEntityManager().getTransaction().begin();
            Compensation compU = DAO.getEntityManager().find(Compensation.class,comp.getCompId());
            compU.setMinPrice(comp.getMinPrice());
            DAO.getEntityManager().persist(compU);
            DAO.getEntityManager().getTransaction().commit();
            return compU.getCompId()+"";
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while updating CaracteristiqueProduit",e);
            return null;
        }
    }

    public synchronized static boolean deleteComp(double id){
        try{
            DAO.getEntityManager().getTransaction().begin();
            Compensation comp = DAO.getEntityManager().find(Compensation.class, id);
            if(comp!=null){
                DAO.getEntityManager().remove(DAO.getEntityManager().contains(comp)?comp:DAO.getEntityManager().merge(comp));
            }
            DAO.getEntityManager().getTransaction().commit();
            return true;
        }catch(Exception e){
            ExceptionHandler.handleException("Exception while deleting User",e);
            DAO.getEntityManager().getTransaction().rollback();
            return false;
        }
    }

    public synchronized static Compensation getComp(double id){
        try {
            return DAO.getEntityManager().find(Compensation.class,id);
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching Auction by id",e);
            return null;
        }
    }

    public synchronized static List<Compensation> getAll(){
        try {
            return DAO.getEntityManager().createQuery("select Compensation from Compensation comp").getResultList();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching all Auction",e);
            return null;
        }
    }
}
