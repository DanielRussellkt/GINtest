package stepglue.webglue

import stepglue.webglue.ElementLocator.findElementByXpath
import stepglue.xpathformatter.XpathFormatter.generateWebXpath

object ElementLocation {

    fun isElementFound(element: String, properties: String?, values: String?): Boolean {
        return !findElementByXpath(generateWebXpath(element, properties?.split(","), values?.split(","))).isNullOrBlank()
    }
}