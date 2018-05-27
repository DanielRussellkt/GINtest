package drivers

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import kotlin.test.fail

enum class Drivers {
    FIREFOX {
        override fun driver(): WebDriver {
            WebDriverManager.getInstance(FirefoxDriver::class.java).setup()
            return FirefoxDriver(FirefoxProfile())
        }
    }, CHROME {
        override fun driver(): WebDriver {
            WebDriverManager.getInstance(ChromeDriver::class.java).setup()
            return ChromeDriver()
        }
    };

    abstract fun driver(): WebDriver

    companion object {
        fun getDriver(name: String): Drivers {
            return Drivers.valueOf(name.toUpperCase())
        }
    }
}

object DriverManager {
    private var driver : WebDriver? = null

    fun openBrowser(browser: String) : WebDriver {
        driver = Drivers.getDriver(browser).driver()
        return driver!!
    }

    fun closeBrowser(terminate: Boolean, withFail: Boolean) {
        when {
            driver == null && withFail   -> fail("Browser not opened")
            driver == null && !withFail  -> println("Browser not opened")
            driver != null && terminate  -> driver().quit()
            driver != null && !terminate -> driver().close()
        }
    }

    fun driver(): WebDriver {
        if (driver == null){
            fail("Please open the browser first")
        } else {
            return driver!!
        }
    }
}