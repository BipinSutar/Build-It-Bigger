package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.text.TextUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends InstrumentationTestCase {
    EndpointsAsyncTask task;
    Context context;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        context = getInstrumentation().getTargetContext();
        task = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String joke) {
            /* All-clear! */
            }
        };
    }

    public void testAsynkTaskResponse() throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                String result = null;
                try {
                    result = task.execute(context).get(30, TimeUnit.SECONDS);
                } catch (InterruptedException | ExecutionException | TimeoutException e) {
                    e.printStackTrace();
                }
                assertFalse(TextUtils.isEmpty(result));
            }
        });

    }
}