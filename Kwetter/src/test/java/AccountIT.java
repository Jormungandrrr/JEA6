import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.put;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 *
 * @author Jorrit
 */
public class AccountIT {

    private String url = "http://localhost:8080/Kwetter";
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ServerOnline(){
       given().when().get(url).then().statusCode(200);
    }
    
    @Test
    public void getTestAccount() {
       get(url + "/api/accounts/test").then().body("userName", equalTo("test"));
    }
    
    @Test
    public void CreateAccount() { 
       put(url + "/api/accounts?username=puttest&email=test@test.nl");
       get(url + "/api/accounts/puttest").then().body("userName", equalTo("puttest"));
    }
    
    @Test
    public void UpdateAccount() { 
       post(url + "/api/accounts/test?email=updated@email.com&rights=1");
    }
    
    @Test
    public void DeleteAccount() { 
       delete(url + "/api/accounts?username=puttest&email=test@test.nl");
    }
}
