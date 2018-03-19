
import Models.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.put;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.when;
import io.restassured.path.json.JsonPath;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 *
 * @author Jorrit
 */
public class AccountIT {

    private String url = "http://localhost:8080/Kwetter/api/accounts";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void ServerOnline() {
        given().when().get("http://localhost:8080/Kwetter").then().statusCode(200);
    }

    @Test
    public void getTestAccount() {
        get(url + "/test").then().body("userName", equalTo("test"));
    }

    @Test
    public void getAccounts() {
        JsonPath jpe = get(url).jsonPath();
        List<Account> accs = jpe.getList("", Account.class);
        
    }

    @Test
    public void CreateAccount() {
        put(url + "?username=puttest&email=test@test.nl");
        get(url + "/puttest").then().body("userName", equalTo("puttest"));
    }

    @Test
    public void UpdateAccount() {
        post(url + "/test?email=updated@email.com&rights=1");
        get(url + "/test").then().body("rights", equalTo(1));
    }

    @Test
    public void DeleteAccount() {
        delete(url + "?username=puttest");
    }
}
