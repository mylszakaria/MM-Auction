package com.business.data;

import com.business.model.AuctionWinner;
import com.utilities.ExceptionHandler;

import java.util.List;

/**
 * Created by zakaria on 29/08/2016.
 */
public class AuctionWinnerDAO {
    public synchronized static String insertAuctionWinner(AuctionWinner auctwinner){
        try{
            DAO.getEntityManager().getTransaction().begin();
            DAO.getEntityManager().persist(auctwinner);
            DAO.getEntityManager().getTransaction().commit();
            return auctwinner.getId()+"";
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while inserting auctionwinner",e);
            return null;
        }
    }

    public static String updateAuction (AuctionWinner auctwinner){
        try {
            DAO.getEntityManager().getTransaction().begin();
            AuctionWinner auctU = DAO.getEntityManager().find(AuctionWinner.class,auctwinner.getId());
            auctU.setProd(auctwinner.getProd());
            auctU.setBid(auctwinner.getBid());
            auctU.setUser(auctwinner.getUser());
            DAO.getEntityManager().persist(auctU);
            DAO.getEntityManager().getTransaction().commit();
            return auctU.getId()+"";
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while updating CaracteristiqueProduit",e);
            return null;
        }
    }

    public synchronized static boolean deleteAuctwinner(double id){
        try{
            DAO.getEntityManager().getTransaction().begin();
            AuctionWinner auct = DAO.getEntityManager().find(AuctionWinner.class, id);
            if(auct!=null){
                DAO.getEntityManager().remove(DAO.getEntityManager().contains(auct)?auct:DAO.getEntityManager().merge(auct));
            }
            DAO.getEntityManager().getTransaction().commit();
            return true;
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while deleting auctionwinner",e);
            return false;
        }
    }

    public synchronized static AuctionWinner getAuctionwinner(double id){
        try {
            return DAO.getEntityManager().find(AuctionWinner.class,id);
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching AuctionWinner by id",e);
            return null;
        }
    }

    public synchronized static List<AuctionWinner> getAll(){
        try {
            return DAO.getEntityManager().createQuery("select AuctionWinner from AuctionWinner auct").getResultList();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching all Auction",e);
            return null;
        }
    }
}
