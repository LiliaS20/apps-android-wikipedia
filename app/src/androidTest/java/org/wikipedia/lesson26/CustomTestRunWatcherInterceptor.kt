package org.wikipedia.lesson26

import android.util.Log
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class CustomTestRunWatcherInterceptor : TestRunWatcherInterceptor {

    override fun onTestStarted(testInfo: TestInfo) {
        Log.d("KASPRESSO", "CHECK START: TEST STARTED")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        Log.d("KASPRESSO", "CHECK START: BEFORE SECTION STARTED")
    }

    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        Log.d("KASPRESSO", "CHECK START: BEFORE SECTION FINISHED SUCCESS")
    }

    override fun onMainSectionStarted(testInfo: TestInfo) {
        Log.d("KASPRESSO", "CHECK START: MAIN SECTION STARTED")
    }

    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        Log.d("KASPRESSO", "CHECK START: MAIN SECTION FINISHED SUCCESS")
    }

    override fun onAfterSectionStarted(testInfo: TestInfo) {
        Log.d("KASPRESSO", "CHECK START: AFTER SECTION STARTED")
    }

    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        Log.d("KASPRESSO", "CHECK START: AFTER SECTION FINISHED SUCCESS")
    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        Log.d("KASPRESSO", "CHECK START: TEST FINISHED")
    }
}