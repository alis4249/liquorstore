package com.sundar.liquorstore;

import com.sundar.liquorstore.Bll.LoginBll;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoginTest {

    @Test
    public void testLogin()
    {
        LoginBll loginBLL = new LoginBll();
        boolean result =  loginBLL.checkUser("bharat123", "bharat");
        assertEquals(true, result);
    }
}
