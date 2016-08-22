package com.business.data;

import com.business.model.AssociationTransactionAuctionProduct;
import com.business.model.AuctionProduct;
import com.utilities.ExceptionHandler;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by zakaria on 15/08/2016.
 */
public abstract class AssoTransAuctionProdDAO {

    public synchronized static String insertAsso(AssociationTransactionAuctionProduct asso) {
        try {
            DAO.getEntityManager().getTransaction().begin();
            DAO.getEntityManager().persist(asso);
            DAO.getEntityManager().getTransaction().commit();
            return asso.getId() + "";
        } catch (Exception e) {
            if (DAO.getEntityManager().getTransaction().isActive()) {
                DAO.getEntityManager().getTransaction().rollback();
                ExceptionHandler.handleException("Exception while inserting User", e);
            }
            return null;
        }
    }

    public static String updateAsso(AssociationTransactionAuctionProduct asso) {
        try {
            DAO.getEntityManager().getTransaction().begin();
            AssociationTransactionAuctionProduct assoU = DAO.getEntityManager().find(AssociationTransactionAuctionProduct.class, asso.getId());
            assoU.setTrans(asso.getTrans());
            assoU.setAuctProduct(asso.getAuctProduct());
            assoU.setHighestBid(asso.getHighestBid());
            assoU.setUser(asso.getUser());
            DAO.getEntityManager().persist(assoU);
            DAO.getEntityManager().getTransaction().commit();
            return assoU.getId() + "";
        } catch (Exception e) {
            if (DAO.getEntityManager().getTransaction().isActive()) {
                DAO.getEntityManager().getTransaction().rollback();
                ExceptionHandler.handleException("Exception while updating CaracteristiqueProduit", e);
            }
            return null;
        }
    }

    public synchronized static boolean deleteAsso(long id) {
        try {
            DAO.getEntityManager().getTransaction().begin();
            AssociationTransactionAuctionProduct asso = DAO.getEntityManager().find(AssociationTransactionAuctionProduct.class, id);
            if (asso != null) {
                DAO.getEntityManager().remove(DAO.getEntityManager().contains(asso) ? asso : DAO.getEntityManager().merge(asso));
            }
            DAO.getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (DAO.getEntityManager().getTransaction().isActive()) {
                DAO.getEntityManager().getTransaction().rollback();
                ExceptionHandler.handleException("Exception while deleting User", e);
            }
            return false;
        }
    }

    public synchronized static AssociationTransactionAuctionProduct getAsso(long id) {
        try {
            return DAO.getEntityManager().find(AssociationTransactionAuctionProduct.class, id);
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching Auction by id", e);
            return null;
        }
    }

    public synchronized static List<AssociationTransactionAuctionProduct> getAll() {
        try {
            return DAO.getEntityManager().createQuery("select AssociationTransactionAuctionProduct from AssociationTransactionAuctionProduct asso").getResultList();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching all Auction", e);
            return null;
        }
    }


    public synchronized static List<AssociationTransactionAuctionProduct> findUsingProdId(long prodid) {
        try {
            AuctionProduct x = AuctionProductDAO.getProduit(prodid);
            Query query = DAO.getEntityManager().createQuery("select AssociationTransactionAuctionProduct from AssociationTransactionAuctionProduct P where lower(P.auctProduct) lIKE :x", AssociationTransactionAuctionProduct.class);
            query.setParameter("x", "%" + x + "%");
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching list of Produit by name", e);
            return null;
        }
    }
}
