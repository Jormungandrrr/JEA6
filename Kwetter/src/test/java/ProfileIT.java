
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.put;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorrit
 */
public class ProfileIT {
    
    private String url = "http://localhost:8080/Kwetter/api/profiles";
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void getTestprofile() {
       get(url + "/2").then().body("name", equalTo("testprofile"));
    }
    
    @Test
    public void Createprofile() { 
       put(url + "?name=unittestprofile&biography=this is for unit testing&location=somewhere");
       get(url + "/5").then().body("name", equalTo("unittestprofile"));
    }
    
    @Test
    public void UpdateProfile() { 
       post(url + "/5?biography=updated&location=updated&photo=updated&website=updated");
       get(url + "/5").then().body("photo", equalTo("updated"));
    }
    
    @Test
    public void AddFollower() { 
       post(url + "/5/follower?followerid=2");
    }
    
     @Test
    public void RemoveFollower() { 
       delete(url + "/5/follower?followerid=2");
    }
    
    @Test
    public void AddMessage() { 
       post(url + "/5/message?id=6&content=wazaa");
    }
    
     @Test
    public void RemoveMessage() { 
       delete(url + "/5/message?id=6");
    }
    
//    @Test
//    public void DeleteProfile() { 
//       delete(url + "/5");
//    }
}
