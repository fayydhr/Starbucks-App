// Corrected package name

import androidx.test.platform.app.InstrumentationRegistry // Added import
import androidx.test.ext.junit.runners.AndroidJUnit4 // Added import

import org.junit.Test // Added import
import org.junit.runner.RunWith // Added import

import org.junit.Assert.assertEquals // Corrected import to specific assertion

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class StkExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.stk", appContext.packageName)
    }
}