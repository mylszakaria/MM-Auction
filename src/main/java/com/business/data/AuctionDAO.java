package com.business.data;

import com.business.model.Auction;
import com.utilities.ExceptionHandler;

import java.util.List;

/**
 * Created by zakaria on 25/07/2016.
 */
public abstract class AuctionDAO {

    public synchronized static String insertAuction(Auction auct){
        try{
            DAO.getEntityManager().getTransaction().begin();
            DAO.getEntityManager().persist(auct);
            DAO.getEntityManager().getTransaction().commit();
            return auct.getAuctionId()+"";
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while inserting User",e);
            return null;
        }
    }

    public static String updateAuction (Auction auct){
        try {
            DAO.getEntityManager().getTransaction().begin();
            Auction auctU = DAO.getEntityManager().find(Auction.class,auct.getAuctionId());
            auctU.setComp(auct.getComp());
            auctU.setEndingDate(auct.getEndingDate());
            auctU.setStartingDate(auct.getStartingDate());
            auctU.setProdList(auct.getProdList());
            auctU.setUsers(auct.getUsers());
            DAO.getEntityManager().persist(auctU);
            DAO.getEntityManager().getTransaction().commit();
            return auctU.getAuctionId()+"";
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while updating CaracteristiqueProduit",e);
            return null;
        }
    }

    public synchronized static boolean deleteAuct(double id){
        try{
            DAO.getEntityManager().getTransaction().begin();
            Auction auct = DAO.getEntityManager().find(Auction.class, id);
            if(auct!=null){
                DAO.getEntityManager().remove(DAO.getEntityManager().contains(auct)?auct:DAO.getEntityManager().merge(auct));
            }
            DAO.getEntityManager().getTransaction().commit();
            return true;
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while deleting User",e);
            return false;
        }
    }

    public synchronized static Auction getAuction(double id){
        try {
            return DAO.getEntityManager().find(Auction.class,id);
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching Auction by id",e);
            return null;
        }
    }

    public synchronized static List<Auction> getAll(){
        try {
            return DAO.getEntityManager().createQuery("select Auction from Auction auct").getResultList();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching all Auction",e);
            return null;
        }
    }
}
