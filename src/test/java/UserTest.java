import com.business.model.*;
import com.business.data.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by zakaria on 26/07/2016.
 */

public class UserTest {
    @Test
    public void test()
    {
        /**SETTING UP**/
        Transaction trans = new Transaction();
        trans.setLimiteDate("26/07/2016");
        trans.setTransAmount(20000);

        Contact con = new Contact();
        con.setAddress("address");
        con.setCompanyName("Marsa Maroc");

        Authentification auth = new Authentification();
        auth.setEmail("email2");
        auth.setPassword("pwd");


        User user = new User();
        user.setUserFirstName("zakaria");
        user.setUserLastName("myls");
        user.setUserRole("admin");
        user.setAuth(auth);
        user.setContact(con);
        user.addTransaction(trans);


        Transaction trans1 = new Transaction();
        trans1.setLimiteDate("30/07/2016");
        trans1.setTransAmount(40000);

        Contact con1 = new Contact();
        con1.setAddress("address1");
        con1.setCompanyName("Marsa Maroc1");


        Authentification auth1 = new Authentification();
        auth1.setEmail("email");
        auth1.setPassword("pwd1");

        User user1 = new User();
        user1.setUserFirstName("zack");
        user1.setUserLastName("rengar");
        user1.setUserRole("client");
        user1.setContact(con1);
        user1.setAuth(auth1);
        user1.addTransaction(trans1);


        /**TEST INSERTING**/
        System.out.println("TEST INSERTING");
        String transId = TransactionDAO.insertTransaction(trans);
        Assert.assertNotNull(transId);

        String transId1 = TransactionDAO.insertTransaction(trans1);
        Assert.assertNotNull(transId1);

        String id = UserDAO.insertUser(user);
        System.out.println(id+" id user");
        Assert.assertNotNull(id);

        String id1 =UserDAO.insertUser(user1);
        System.out.println(id1+" id user1");
        Assert.assertNotNull(id1);
        System.out.println("INSERTING FINISH SUCCESS");


        /**TEST UPDATE**/
        trans.setLimiteDate("my limit date updated");
        id = TransactionDAO.updateTrans(trans);
        Assert.assertNotNull(id);

        con.setAddress("address updated");
        auth.setPassword("numberOne updated");
        user.setUserFirstName("my first name updated ");
        user.setContact(con);
        user.setAuth(auth);

        Assert.assertNotNull(UserDAO.updateUser(user));
        System.out.println("User updated success");



        System.out.println("User 1 update start ");
        user1.setUserFirstName("ana");
        trans1.setTransAmount(50000);
        Assert.assertNotNull(TransactionDAO.updateTrans(trans1));
        Assert.assertNotNull(UserDAO.updateUser(user1));
        System.out.println("user1 updated");

        /**TEST FETCHING**/
        System.out.println("TEST FETCHING");

        user1 = UserDAO.getUser(user.getUserId());
        Assert.assertNotNull(user1);

        Assert.assertTrue(UserDAO.getAll().size()>0);

        /**TEST DELETING**/
        System.out.println("TEST DELETING");
        Assert.assertTrue(UserDAO.deleteUser(user.getUserId()));





    }

}
