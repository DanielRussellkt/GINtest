package stepglue.webglue

import drivers.DriverManager.driver
import org.openqa.selenium.By
import stepglue.xpathformatter.XpathProperties

object ElementLocator {
    fun findElementByXpath(xpathWrapper: Array<String>):  String? {
        XpathProperties.values().forEach {
            val toSearch = xpathWrapper.joinToString(separator = it.xpathTag)
            if (!driver().findElements( By.xpath(toSearch) ).isEmpty()) {
                return toSearch
            }
        }
        return null
    }
}