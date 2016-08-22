package com.business.data;

import com.business.model.AssociationTransactionConsultationProduct;
import com.utilities.ExceptionHandler;

import java.util.List;

/**
 * Created by zakaria on 15/08/2016.
 */
public abstract class AssoTransConsProdDAO {

        public synchronized static String insertAsso(AssociationTransactionConsultationProduct asso){
            try{
                DAO.getEntityManager().getTransaction().begin();
                DAO.getEntityManager().persist(asso);
                DAO.getEntityManager().getTransaction().commit();
                return asso.getId()+"";
            }catch(Exception e){
                if(DAO.getEntityManager().getTransaction().isActive())
                {
                    DAO.getEntityManager().getTransaction().rollback();
                    ExceptionHandler.handleException("Exception while inserting AssoConsProdTrans", e);
                }
                return null;
            }
        }

        public static String updateAsso (AssociationTransactionConsultationProduct asso){
            try {
                DAO.getEntityManager().getTransaction().begin();
                AssociationTransactionConsultationProduct assoU = DAO.getEntityManager().find(AssociationTransactionConsultationProduct.class,asso.getId());
                assoU.setTrans(asso.getTrans());
                assoU.setTrans(asso.getTrans());
                assoU.setProduit(asso.getProduit());
                assoU.setProdQtity(asso.getProdQtity());
                DAO.getEntityManager().persist(assoU);
                DAO.getEntityManager().getTransaction().commit();
                return assoU.getId()+"";
            } catch (Exception e) {
                if(DAO.getEntityManager().getTransaction().isActive())
                {
                    DAO.getEntityManager().getTransaction().rollback();
                    ExceptionHandler.handleException("Exception while updating CaracteristiqueProduit", e);
                }
                return null;
            }
        }

        public synchronized static boolean deleteAsso(long id){
            try{
                DAO.getEntityManager().getTransaction().begin();
                AssociationTransactionConsultationProduct asso = DAO.getEntityManager().find(AssociationTransactionConsultationProduct.class, id);
                if(asso!=null){
                    DAO.getEntityManager().remove(DAO.getEntityManager().contains(asso)?asso:DAO.getEntityManager().merge(asso));
                }
                DAO.getEntityManager().getTransaction().commit();
                return true;
            }catch(Exception e){
                if(DAO.getEntityManager().getTransaction().isActive())
                {
                    DAO.getEntityManager().getTransaction().rollback();
                    ExceptionHandler.handleException("Exception while deleting AssoConsProdTrans", e);
                }
                return false;
            }
        }

        public synchronized static AssociationTransactionConsultationProduct getAsso(long id){
            try {
                return DAO.getEntityManager().find(AssociationTransactionConsultationProduct.class,id);
            } catch (Exception e) {
                ExceptionHandler.handleException("Exception while fetching Auction by id",e);
                return null;
            }
        }

        public synchronized static List<AssociationTransactionConsultationProduct> getAll(){
            try {
                return DAO.getEntityManager().createQuery("select AssociationTransactionConsultationProduct from AssociationTransactionConsultationProduct asso").getResultList();
            } catch (Exception e) {
                ExceptionHandler.handleException("Exception while fetching all AssociationsTransConsProd",e);
                return null;
            }
        }
}
