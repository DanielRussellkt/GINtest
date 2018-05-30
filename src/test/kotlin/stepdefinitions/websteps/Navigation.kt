package stepdefinitions.websteps

import cucumber.api.java8.En
import drivers.DriverManager.driver
import stepglue.webglue.PageScrolling.scroll

class Navigation: En {
    init {
        Given("^I navigate to \"([^\"&^ ]*)\"$") { page: String ->
            driver().navigate().to(page)
        }

         Given("^I navigate (back|forward) a page$") {direction: String ->
             if(direction == "back") driver().navigate().back() else driver().navigate().forward()
         }

        Given("I refresh the page$") {
            driver().navigate().refresh()
        }

        Given("I scroll (up|down|left|right)$") { direction: String ->
            scroll(direction)
        }
    }
}