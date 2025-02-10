import androidx.compose.ui.window.ComposeUIViewController
import com.droidknights.app.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
