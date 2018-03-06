///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import Dao.AccountDao;
//import Models.Account;
//import javax.inject.Inject;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import service.AccountService;
//
///**
// *
// * @author Jorrit
// */
//public class AccountTest {
//
//    @Mock
//    AccountDao ad;
//
//    @InjectMocks
//    private AccountService as;
//
//    public AccountTest() {
//    }
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void getTestAccount() {
//        Account testaccount = as.findByName("test");
//        assertSame("test", testaccount.getUserName());
//    }
//}
