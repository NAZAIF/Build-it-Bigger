package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;


import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class EndpointsAsynctaskTest extends ApplicationTestCase<Application> {

    private String joke = null;

    public EndpointsAsynctaskTest() {
        super(Application.class);
    }


    @Test
    public void testAsyncTask() {
        try {
            EndpointsAsynctask task = new EndpointsAsynctask();
            task.execute();
            joke = task.get();
        } catch (Exception e) {
            e.printStackTrace();
            joke = null;
        }

        assertNotNull(joke);
    }
}