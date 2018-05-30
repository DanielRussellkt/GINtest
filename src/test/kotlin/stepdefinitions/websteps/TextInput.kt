package stepdefinitions.websteps

import cucumber.api.java8.En
import drivers.DriverManager
import org.openqa.selenium.By
import stepglue.webglue.ElementLocator
import stepglue.xpathformatter.XpathFormatter
import kotlin.test.fail

class TextInput: En {
    init {
        Given("^I type \"([^\"]*)\" in \"([^\"]*)\"(?: where \"([^\"]*)\" [is|are] \"([^\"]*)\")?$") {text: String, element: String, properties: String?, values: String? ->
            DriverManager.driver().findElement(By.xpath(
                    ElementLocator.findElementByXpath(
                            XpathFormatter.generateWebXpath(element, properties?.split(","), values?.split(","))
                    )
                            ?: fail("Element $element not found on page")
            )).sendKeys(text)
        }
    }
}