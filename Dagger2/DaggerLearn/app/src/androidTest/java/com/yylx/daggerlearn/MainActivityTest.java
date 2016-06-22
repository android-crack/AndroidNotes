package com.yylx.daggerlearn;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.yylx.daggerlearn.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by zqj on 2016/6/2 11:15.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    private static final String STRING_TO_BE_TYPED = "peter";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void sayHello() {
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED));
        closeSoftKeyboard();
        onView(withText("Say hello!")).perform(click());
        String expectedText = "hello, " + STRING_TO_BE_TYPED;
        onView(withId(R.id.textView)).check(matches(withText(expectedText)));
    }
}
