package com.business.data;

import com.business.model.Consultation;
import com.business.model.ConsultationProduct;
import com.utilities.ExceptionHandler;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by zakaria on 25/07/2016.
 */

public abstract class ConsultationProductDAO {

    /**
     * Cette méthode permet d'inserer un objet Produit dans la base de données.
     *
     * @param P business.model.Produit l'objet à insérer
     * @return l'ID de l'objet inséré en cas de succès, null en cas d'erreur.
     * @see String
     */
    public synchronized static String insertProduit(ConsultationProduct P) {
        try {
            DAO.getEntityManager().getTransaction().begin();
            DAO.getEntityManager().persist(P);
            DAO.getEntityManager().getTransaction().commit();
            return P.getProductId() + "";
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while inserting AuctionProduct", e);
            return null;
        }
    }


    /**
     * Cette méthode permet de modifier un objet Produit dans la base de données.
     *
     * @param P business.model.Produit l'objet à modifier
     * @return l'ID de l'objet mis à jour en cas de succès, null en cas d'erreur.
     * @see String
     */
    public synchronized static String updateProduit(ConsultationProduct P) {
        try {
            DAO.getEntityManager().getTransaction().begin();
            ConsultationProduct PU = DAO.getEntityManager().find(ConsultationProduct.class, P.getProductId());
            PU.setProductName(P.getProductName());
            PU.setProductInventory(P.getProductInventory());
            PU.setProductPrice(P.getProductPrice());
            PU.setProductImg(P.getProductImg());
            DAO.getEntityManager().persist(PU);
            DAO.getEntityManager().getTransaction().commit();
            return PU.getProductId() + "";
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while updating Produit", e);
            return null;
        }
    }

    /**
     * Cette méthode permet de supprimer un objet Produit de la base de données.
     *
     * @param id long l'ID de l'objet à supprimer
     * @return true en cas de succès, false en cas d'erreur
     * @see boolean
     */
    public synchronized static boolean deleteProduit(double id) {
        try {
            DAO.getEntityManager().getTransaction().begin();
            ConsultationProduct P = DAO.getEntityManager().find(ConsultationProduct.class, id);
            if (P != null) {
                DAO.getEntityManager().remove(DAO.getEntityManager().contains(P) ? P : DAO.getEntityManager().merge(P));
            }
            DAO.getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while deleting Produit", e);
            return false;
        }

    }

    /**
     * Cette méthode permet de récupérer un objet Produit de la base de données par son ID.
     *
     * @param id long l'ID de l'objet à récupérer
     * @return l'objet à récupérer, null en cas d'erreur
     */
    public synchronized static ConsultationProduct getProduit(double id) {
        try {
            return DAO.getEntityManager().find(ConsultationProduct.class, id);
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching Produit By id", e);
            return null;
        }
    }

    /**
     * Cette méthode permet de récupérer tous les objets Produit de la base de données.
     *
     * @return List des tous les objets, null en cas d'erreur.
     * @see List
     */
    public synchronized static List<ConsultationProduct> getAll() {
        try {
            return DAO.getEntityManager().createQuery("select P from ConsultationProduct P").getResultList();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching all Produit", e);
            return null;
        }
    }


    /**
     * Cette méthode permet de récupérer les objets Produit de la base de données par nom.
     *
     * @return List des objets par nom, null en cas d'erreur.
     * @see List
     */
    public synchronized static List<ConsultationProduct> find(String prodName) {

        try {
            String x = prodName.toLowerCase();
            Query query = DAO.getEntityManager().createQuery("select P from ConsultationProduct P where lower(P.productName) lIKE :x", ConsultationProduct.class);
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

