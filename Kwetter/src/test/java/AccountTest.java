/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 *
 * @author Jorrit
 */
public class AccountTest {

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
}
