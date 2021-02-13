package com.sundar.liquorstore;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class InvalidloginTesting {

    //test for wrong login
    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<>(MainActivity.class);
    private String username = "ysdsdd";
    private String password = "skjdfhds";

    @Test
    public void TestUI() throws Exception
    {
        onView(withId(R.id.etUsername)).perform(typeText(username));
        closeSoftKeyboard();
        onView(withId(R.id.etPassword)).perform(typeText(password));
        closeSoftKeyboard();

        onView(withId(R.id.btnLogin)).perform(click());
    }
}
