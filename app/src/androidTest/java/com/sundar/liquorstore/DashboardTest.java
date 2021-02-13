package com.sundar.liquorstore;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class DashboardTest {

        @Rule
        public ActivityTestRule<Dashboard_activity> testRule = new ActivityTestRule<>(Dashboard_activity.class);
        private Dashboard_activity dashboardActivity=null;


        @Before
        public void setUp() throws Exception {
            dashboardActivity=testRule.getActivity();
        }
        @Test
        public void testLaunch(){
            View view=dashboardActivity.findViewById(R.id.recycleritemlists);
            assertNotNull(view);

        }

        @After
        public void tearDown() throws Exception {
            dashboardActivity=null;
        }
}
