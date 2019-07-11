package com.mrntlu.espressouitest;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkLoginSuccess(){
        onView(withId(R.id.edt_email)).perform(typeText(MainActivity.email), closeSoftKeyboard());

        onView(withId(R.id.edt_pass)).perform(typeText(MainActivity.password), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

        onView(withId(R.id.tv_result)).check(matches(withText(MainActivity.loginSuccess)));
    }

    @Test
    public void checkLoginFailed(){
        onView(withId(R.id.edt_email)).perform(typeText("wrong@email.com"), closeSoftKeyboard());

        onView(withId(R.id.edt_pass)).perform(typeText("wrongpass"), closeSoftKeyboard());

        onView(withId(R.id.btn_login)).perform(click());

        onView(withId(R.id.tv_result)).check(matches(withText(MainActivity.loginFailed)));
    }
}