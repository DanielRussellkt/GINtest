package stepdefinitions.websteps

import cucumber.api.java8.En
import stepglue.xpathformatter.XpathFormatter.generateWebXpath
import drivers.DriverManager.driver
import org.openqa.selenium.By
import stepglue.webglue.ElementLocator
import kotlin.test.fail

class ElementInteraction: En {
    init {
        Given("^I click \"([^\"]*)\"(?: where \"([^\"]*)\" [is|are] \"([^\"]*)\")?") {element: String, properties: String?, values: String? ->
            Thread.sleep(5_000)
            driver().findElement(By.xpath(
                    ElementLocator.findElementByXpath(generateWebXpath(element, properties?.split(","), values?.split(","))) ?: fail("Element $element not found on page")
            )).click()
        }


    }
}