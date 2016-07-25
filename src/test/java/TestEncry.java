import com.utilities.Encryptor;
import junit.framework.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

/**
 * Created by hk on 18/07/2016.
 */
public class TestEncry {

    @Test
    public void test() throws NoSuchAlgorithmException {
        System.out.println(Encryptor.encrypte("hello world"));
        Assert.assertTrue(Encryptor.testPassword("hello world","5eb63bbbe01eeed093cb2bb8f5acdc3"));
    }
}
