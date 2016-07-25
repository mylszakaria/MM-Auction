package com.business.data;

import com.business.model.Transaction;
import com.utilities.ExceptionHandler;

import java.util.List;

/**
 * Created by zakaria on 25/07/2016.
 */
public abstract class TransactionDAO {

    public synchronized static String insertTransaction(Transaction trans){
        try{
            DAO.getEntityManager().getTransaction().begin();
            DAO.getEntityManager().persist(trans);
            DAO.getEntityManager().getTransaction().commit();
            return trans.getTransId()+"";
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while inserting User",e);
            return null;
        }
    }

    public static String updateTrans (Transaction trans){
        try {
            DAO.getEntityManager().getTransaction().begin();
            Transaction transU = DAO.getEntityManager().find(Transaction.class,trans.getTransId());
            transU.setTransAmount(trans.getTransAmount());
            transU.setAuction(trans.getAuction());
            transU.setUser(trans.getUser());
            transU.setLimiteDate(trans.getLimiteDate());
            DAO.getEntityManager().persist(transU);
            DAO.getEntityManager().getTransaction().commit();
            return transU.getTransId()+"";
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while updating CaracteristiqueProduit",e);
            return null;
        }
    }

    public synchronized static boolean deleteTrans(double id){
        try{
            DAO.getEntityManager().getTransaction().begin();
            Transaction trans = DAO.getEntityManager().find(Transaction.class, id);
            if(trans!=null){
                DAO.getEntityManager().remove(DAO.getEntityManager().contains(trans)?trans:DAO.getEntityManager().merge(trans));
            }
            DAO.getEntityManager().getTransaction().commit();
            return true;
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while deleting User",e);
            return false;
        }
    }

    public synchronized static Transaction getTransaction(double id){
        try {
            return DAO.getEntityManager().find(Transaction.class,id);
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching Auction by id",e);
            return null;
        }
    }

    public synchronized static List<Transaction> getAll(){
        try {
            return DAO.getEntityManager().createQuery("select Transaction from Transaction trans").getResultList();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching all Auction",e);
            return null;
        }
    }
}
