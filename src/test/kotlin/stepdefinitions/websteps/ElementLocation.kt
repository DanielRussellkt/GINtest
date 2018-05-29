package stepdefinitions.websteps

import cucumber.api.java8.En
import kotlin.test.fail
import stepglue.webglue.ElementLocation.isElementFound
import stepglue.webglue.ElementWaits.waitForElement
import stepglue.webglue.ElementWaits.waitForVanish
import stepglue.webglue.PageScrolling.scrollUntilFound


class ElementLocation: En {

    init {
        Given("^I see \"([^\"]*)\"(?: where \"([^\"]*)\" [is|are] \"([^\"]*)\")?") {element: String, properties: String?, values: String? ->
            if (!isElementFound(element, properties, values)) fail("Element $element not found on page")
        }

        Given("^I wait (?:(\\d+) seconds )?until \"([^\"]*)\"(?: where \"([^\"]*)\" [is|are] \"([^\"]*)\")? (appears|disappears)") { timeout: Long?, element: String, properties: String?, values: String?, appears: String ->
            when (appears) {
                "appears" -> if (!waitForElement(element, properties, values, (timeout ?: 20) * 1000)) fail("$element did not appear in ${timeout ?: 20} seconds")
                "disappears" -> if (!waitForVanish(element, properties, values, (timeout ?: 20) * 1000)) fail("$element did not disappear in ${timeout ?: 20} seconds")
            }
            Thread.sleep(4000)
        }

        Given("^I scroll (?:(up|down|left|right) )?until I see\"([^\"]*)\"(?: where \"([^\"]*)\" [is|are] \"([^\"]*)\")?") {direction: String, element: String, properties: String?, values: String? ->
            if (!scrollUntilFound(direction, element, properties, values)) fail("$element not found on page")
        }
    }
}