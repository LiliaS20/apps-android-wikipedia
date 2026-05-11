package org.wikipedia.lesson26.hw

import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.logger.UiTestLogger
import com.kaspersky.kaspresso.testcases.models.info.TestInfo

class CustomTestRunWatcherInterceptor(
    private val logger: UiTestLogger
) : TestRunWatcherInterceptor {

    override fun onTestStarted(testInfo: TestInfo) {
        logger.d("KASPRESSO", "TEST STARTED")
    }

    override fun onBeforeSectionStarted(testInfo: TestInfo) {
        logger.d("KASPRESSO", "BEFORE SECTION STARTED")
    }

    override fun onBeforeSectionFinishedSuccess(testInfo: TestInfo) {
        logger.d("KASPRESSO", "BEFORE SECTION FINISHED SUCCESS")
    }

    override fun onMainSectionStarted(testInfo: TestInfo) {
        logger.d("KASPRESSO", "MAIN SECTION STARTED")
    }

    override fun onMainSectionFinishedSuccess(testInfo: TestInfo) {
        logger.d("KASPRESSO", "MAIN SECTION FINISHED SUCCESS")
    }

    override fun onAfterSectionStarted(testInfo: TestInfo) {
        logger.d("KASPRESSO", "AFTER SECTION STARTED")
    }

    override fun onAfterSectionFinishedSuccess(testInfo: TestInfo) {
        logger.d("KASPRESSO", "AFTER SECTION FINISHED SUCCESS")
    }

    override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
        logger.d("KASPRESSO", "TEST FINISHED")
    }
}