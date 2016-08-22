package com.business.data;

import com.business.model.AuctionProduct;
import com.utilities.ExceptionHandler;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by zakaria on 25/07/2016.
 */
public abstract class AuctionProductDAO {

    /**
     * Cette méthode permet d'inserer un objet Produit dans la base de données.
     * @param P business.model.Produit l'objet à insérer
     * @return   l'ID de l'objet inséré en cas de succès, null en cas d'erreur.
     * @see String
     */
    public synchronized static String insertProduit(AuctionProduct P){
        try{
            DAO.getEntityManager().getTransaction().begin();
            DAO.getEntityManager().persist(P);
            DAO.getEntityManager().getTransaction().commit();
            return P.getProductId()+"";
        }catch(Exception e){
            //if(DAO.getEntityManager().getTransaction().isActive())
            //{
                DAO.getEntityManager().getTransaction().rollback();
                ExceptionHandler.handleException("Exception while inserting AuctionProduct", e);
            //}
            return null;
        }
    }

    /**
     * Cette méthode permet de modifier un objet Produit dans la base de données.
     * @param P business.model.Produit l'objet à modifier
     * @return   l'ID de l'objet mis à jour en cas de succès, null en cas d'erreur.
     * @see String
     */
    public synchronized static String updateProduit (AuctionProduct P){
        try {
            DAO.getEntityManager().getTransaction().begin();
            AuctionProduct PU = DAO.getEntityManager().find(AuctionProduct.class,P.getProductId());
            PU.setProductName(P.getProductName());
            PU.setProductInventory(P.getProductInventory());
            PU.setProductminPrice(P.getProductminPrice());
            PU.setProductImg(P.getProductImg());
            PU.setProductminPrice(P.getProductminPrice());
            DAO.getEntityManager().persist(PU);
            DAO.getEntityManager().getTransaction().commit();
            return PU.getProductId()+"";
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while updating Produit",e);
            return null;		}
    }

    /**
     * Cette méthode permet de supprimer un objet Produit de la base de données.
     * @param id long l'ID de l'objet à supprimer
     * @return   true en cas de succès, false en cas d'erreur
     * @see boolean
     */
    public synchronized static boolean deleteProduit(double id){
        try{
            DAO.getEntityManager().getTransaction().begin();
            AuctionProduct P = DAO.getEntityManager().find(AuctionProduct.class, id);
            if(P!=null){
                DAO.getEntityManager().remove(DAO.getEntityManager().contains(P)?P:DAO.getEntityManager().merge(P));
            }
            DAO.getEntityManager().getTransaction().commit();
            return true;
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while deleting Produit",e);
            return false;
        }

    }

    /**
     * Cette méthode permet de récupérer un objet Produit de la base de données par son ID.
     * @param id long l'ID de l'objet à récupérer
     * @return   l'objet à récupérer, null en cas d'erreur
     */
    public synchronized static AuctionProduct getProduit(double id){
        try {
            return DAO.getEntityManager().find(AuctionProduct.class,id);
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching Produit By id",e);
            return null;
        }
    }

    /**
     * Cette méthode permet de récupérer tous les objets Produit de la base de données.
     * @return   List des tous les objets, null en cas d'erreur.
     * @see List
     */
    public synchronized static List<AuctionProduct> getAll(){
        try {
            return DAO.getEntityManager().createQuery("select P from AuctionProduct P").getResultList();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching all Produit",e);
            return null;
        }
    }


    /**
     * Cette méthode permet de récupérer les objets Produit de la base de données par nom.
     * @return   List des objets par nom, null en cas d'erreur.
     * @see List
     */
    public synchronized static List<AuctionProduct> find(String prodName){

        try {
            String x = prodName.toLowerCase();
            Query query =DAO.getEntityManager().createQuery("select P from AuctionProduct P where lower(P.productName) lIKE :x",AuctionProduct.class);
            query.setParameter("x", "%"+x+"%");
            return query.getResultList();
        }catch(NoResultException e){
            return null;
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching list of Produit by name",e);
            return null;
        }
    }
}
