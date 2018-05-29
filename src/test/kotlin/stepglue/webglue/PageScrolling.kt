package stepglue.webglue

import drivers.DriverManager.driver
import org.openqa.selenium.JavascriptExecutor


object PageScrolling {
    fun scroll(direction: String) {
        when(direction) {
            //TODO: Cannot find a horizontally scrolling site, so cannot test this quickly rn
            "down"  -> (driver() as JavascriptExecutor).executeScript("window.scrollBy(0,500)")
            "up"    -> (driver() as JavascriptExecutor).executeScript("window.scrollBy(0,-500)")
            "right" -> (driver() as JavascriptExecutor).executeScript("window.scrollBy(500,0)")
            "left"  -> (driver() as JavascriptExecutor).executeScript("window.scrollBy(-500,)")
        }
    }

    fun scrollUntilFound(direction: String, element: String, properties: String?, values: String?): Boolean {
        (1..10).forEach {
            if (ElementLocation.isElementFound(element, properties, values)) return true
            scroll(direction)
        }
        return false
    }
}