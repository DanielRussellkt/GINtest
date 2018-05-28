package stepdefinitions.websteps

import cucumber.api.java8.En
import kotlin.test.fail
import stepglue.webglue.ElementLocation.isElementFound


class ElementLocation: En {

    init {
        Given("^I see \"([^\"]*)\"(?: where \"([^\"]*)\" [is|are] \"([^\"]*)\")?") {element: String, properties: String?, values: String? ->
            Thread.sleep(5_000)
            if (!isElementFound(element, properties, values)) fail("Element $element not found on page")
        }
    }
}