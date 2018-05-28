package stepdefinitions.websteps

import cucumber.api.java8.En
import drivers.DriverManager.driver
import org.openqa.selenium.By
import stepglue.webglue.ElementLocator.findElementByXpath
import kotlin.test.fail
import stepglue.webglue.ElementLocation.isElementFound
import stepglue.xpathformatter.XpathFormatter


class ElementLocation: En {

    init {
        Given("^I see \"([^\"]*)\"(?: where \"([^\"]*)\" [is|are] \"([^\"]*)\")?") {element: String, properties: String?, values: String? ->
            Thread.sleep(5_000)
            println("\n\n\n Element found: ${isElementFound(element, properties, values)} ")
            if (!isElementFound(element, properties, values)) fail("Element $element not found on page")
        }
    }
}