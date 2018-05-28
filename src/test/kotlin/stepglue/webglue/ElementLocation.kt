package stepglue.webglue

import stepglue.webglue.ElementLocator.findElementByXpath
import stepglue.xpathformatter.XpathFormatter.generateWebXpath

object ElementLocation {

    fun isElementFound(element: String, properties: String?, values: String?): Boolean {
        println("\n\n\nFound element by xpath: ${findElementByXpath(generateWebXpath(element, properties?.split(","), values?.split(",")))}\n\n\n")
        return !findElementByXpath(generateWebXpath(element, properties?.split(","), values?.split(","))).isNullOrBlank()
    }
}