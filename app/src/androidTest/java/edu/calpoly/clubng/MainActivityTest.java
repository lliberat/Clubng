package edu.calpoly.clubng;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;


import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction button = onView(
                allOf(withId(R.id.button2),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.frag_container),
                                        0),
                                0),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.button3),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.frag_container),
                                        0),
                                1),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.button4),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.frag_container),
                                        0),
                                2),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withText("Clubng"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Clubng")));

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.nav_profile), withContentDescription("Profile"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.footer_nav),
                                        0),
                                0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.largeLabel), withText("Profile"),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(R.id.nav_profile), withContentDescription("Profile")),
                                        1),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("Profile")));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.icon),
                        childAtPosition(
                                allOf(withId(R.id.nav_profile), withContentDescription("Profile"),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                0)),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction frameLayout2 = onView(
                allOf(withId(R.id.nav_location), withContentDescription("Location"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.footer_nav),
                                        0),
                                1),
                        isDisplayed()));
        frameLayout2.check(matches(isDisplayed()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.smallLabel), withText("Location"),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(R.id.nav_location), withContentDescription("Location")),
                                        0),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("Location")));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.icon),
                        childAtPosition(
                                allOf(withId(R.id.nav_location), withContentDescription("Location"),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                1)),
                                1),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction frameLayout3 = onView(
                allOf(withId(R.id.nav_confirmation), withContentDescription("Confimation"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.footer_nav),
                                        0),
                                2),
                        isDisplayed()));
        frameLayout3.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.smallLabel), withText("Confimation"),
                        childAtPosition(
                                childAtPosition(
                                        allOf(withId(R.id.nav_confirmation), withContentDescription("Confimation")),
                                        0),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("Confimation")));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.icon),
                        childAtPosition(
                                allOf(withId(R.id.nav_confirmation), withContentDescription("Confimation"),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                2)),
                                1),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
