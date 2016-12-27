package com.gosuncn.sample;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.gosuncn.core.util.storage.CleanCacheUtils;
import com.gosuncn.core.util.storage.PreferencesHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.gosuncn.sample", appContext.getPackageName());

    }

    @Test
    public void testUtils() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        //assertTrue(AppUtils.isInstallByread(appContext.getPackageName()));
        new PreferencesHelper(appContext,"sp_name").saveOrUpdate("123","123");
        assertTrue(CleanCacheUtils.cleanInternalSP(appContext));
    }

}
