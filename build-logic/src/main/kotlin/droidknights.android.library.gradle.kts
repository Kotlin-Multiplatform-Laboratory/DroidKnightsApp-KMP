import com.droidknights.app.configureCoroutineAndroid
import com.droidknights.app.configureKoinKotlin
import com.droidknights.app.configureKotest
import com.droidknights.app.configureKotlinAndroid

plugins {
    id("com.android.library")
    id("droidknights.verify.detekt")
}

configureKotlinAndroid()
configureKotest()
configureCoroutineAndroid()
configureKoinKotlin()
