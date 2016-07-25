package com.business.data;

import com.business.model.Consultation;
import com.utilities.ExceptionHandler;

import java.util.List;

/**
 * Created by zakaria on 25/07/2016.
 */
public abstract class ConsultationDAO {

    public synchronized static String insertConsultation(Consultation cons){
        try{
            DAO.getEntityManager().getTransaction().begin();
            DAO.getEntityManager().persist(cons);
            DAO.getEntityManager().getTransaction().commit();
            return cons.getConsId()+"";
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while inserting User",e);
            return null;
        }
    }

    public static String updateUser (Consultation cons){
        try {
            DAO.getEntityManager().getTransaction().begin();
            Consultation consU = DAO.getEntityManager().find(Consultation.class,cons.getConsId());
            consU.setProList(cons.getProList());
            DAO.getEntityManager().persist(consU);
            DAO.getEntityManager().getTransaction().commit();
            return consU.getConsId()+"";
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while updating CaracteristiqueProduit",e);
            return null;
        }
    }

    public synchronized static boolean deleteConsultation(double id){
        try{
            DAO.getEntityManager().getTransaction().begin();
            Consultation cons = DAO.getEntityManager().find(Consultation.class, id);
            if(cons!=null){
                DAO.getEntityManager().remove(DAO.getEntityManager().contains(cons)?cons:DAO.getEntityManager().merge(cons));
            }
            DAO.getEntityManager().getTransaction().commit();
            return true;
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while deleting User",e);
            return false;
        }
    }

    public synchronized static Consultation getConsultation(double id){
        try {
            return DAO.getEntityManager().find(Consultation.class,id);
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching Auction by id",e);
            return null;
        }
    }

    public synchronized static List<Consultation> getAll(){
        try {
            return DAO.getEntityManager().createQuery("select Consultation from Consultation cons").getResultList();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching all Auction",e);
            return null;
        }
    }
}
