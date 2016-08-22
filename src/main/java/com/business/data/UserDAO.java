package com.business.data;

import com.business.model.User;
import com.utilities.ExceptionHandler;
import java.util.List;

/**
 * Created by zakaria on 25/07/2016.
 */

public abstract class UserDAO {

    public synchronized static String insertUser(User user){
        try{
            DAO.getEntityManager().getTransaction().begin();
            DAO.getEntityManager().persist(user);
            DAO.getEntityManager().getTransaction().commit();
            return user.getUserId()+"";
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while inserting User",e);
            return null;
        }
    }

    public static String updateUser (User user){
        try {
            DAO.getEntityManager().getTransaction().begin();
            User userU = DAO.getEntityManager().find(User.class,user.getUserId());
            userU.setUserFirstName(user.getUserFirstName());
            userU.setUserLastName(user.getUserLastName());
            userU.setUserRole(user.getUserRole());
            userU.setAuth(user.getAuth());
            userU.setContact(user.getContact());
            userU.setTransHistory(user.getTransHistory());
            userU.setAuctHistory(user.getAuctHistory());
            userU.setCart(user.getCart());
            DAO.getEntityManager().persist(userU);
            DAO.getEntityManager().getTransaction().commit();
            return userU.getUserId()+"";
        } catch (Exception e) {
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while updating User",e);
            return null;
        }
    }

    public synchronized static boolean deleteUser(long id){
        try{
            DAO.getEntityManager().getTransaction().begin();
            User user = DAO.getEntityManager().find(User.class, id);
            if(user!=null){
                DAO.getEntityManager().remove(DAO.getEntityManager().contains(user)?user:DAO.getEntityManager().merge(user));
            }
            DAO.getEntityManager().getTransaction().commit();
            return true;
        }catch(Exception e){
            DAO.getEntityManager().getTransaction().rollback();
            ExceptionHandler.handleException("Exception while deleting User",e);
            return false;
        }
    }

    public synchronized static User getUser(long id){
        try {
            return DAO.getEntityManager().find(User.class,id);
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching User by id",e);
            return null;
        }
    }

    public synchronized static List<User> getAll(){
        try {
            return DAO.getEntityManager().createQuery("select user from User user").getResultList();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching all User",e);
            return null;
        }
    }

    public synchronized static User getUser(String email){
        try {
            return DAO.getEntityManager().createQuery("select U from User U where lower(U.contact.address) LIKE :x",User.class).getSingleResult();
        } catch (Exception e) {
            ExceptionHandler.handleException("Exception while fetching User by id",e);
            return null;
        }
    }

}
