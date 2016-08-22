import com.business.data.AssoTransAuctionProdDAO;
import com.business.data.AuctionProductDAO;
import com.business.data.TransactionDAO;
import com.business.data.UserDAO;
import com.business.model.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zakaria on 15/08/2016.
 */
public class TestProduct {
    @Test
    public void test()
    {
        Transaction trans = new Transaction();
        trans.setLimiteDate("26/07/2016");
        trans.setTransAmount(20000);

        Contact con = new Contact();
        con.setAddress("address");
        con.setCompanyName("Marsa Maroc");
        con.setCin("10310251");

        Authentification auth = new Authentification();
        auth.setEmail("useremail");
        auth.setPassword("pwd");


        User user = new User();
        user.setUserFirstName("zakaria");
        user.setUserLastName("myls");
        user.setUserRole("admin");
        user.setAuth(auth);
        user.setContact(con);
        user.addTransaction(trans);

        String transId = TransactionDAO.insertTransaction(trans);
        Assert.assertNotNull(transId);


        String id = UserDAO.insertUser(user);
        System.out.println(id+" id user");
        Assert.assertNotNull(id);

        AuctionProduct auctProd =new AuctionProduct();
        auctProd.setProductminPrice(10000);
        auctProd.setProductInventory(100);
        auctProd.setProductName("MyAuctProd");

        AssociationTransactionAuctionProduct asso = new AssociationTransactionAuctionProduct();
        asso.setUser(user);
        asso.setHighestBid(15000);
        asso.setAuctProduct(auctProd);

        String prodid= AuctionProductDAO.insertProduit(auctProd);
        Assert.assertNotNull(prodid);

        Assert.assertNotNull(AssoTransAuctionProdDAO.insertAsso(asso));

        AssociationTransactionAuctionProduct asso1 = new AssociationTransactionAuctionProduct();
        asso1.setUser(user);
        asso1.setHighestBid(12000);
        asso1.setAuctProduct(auctProd);

        Assert.assertNotNull(AssoTransAuctionProdDAO.insertAsso(asso));
        Assert.assertNotNull(AssoTransAuctionProdDAO.insertAsso(asso1));


        asso.setHighestBid(166000);

        Assert.assertNotNull(AssoTransAuctionProdDAO.updateAsso(asso));
    }

}
