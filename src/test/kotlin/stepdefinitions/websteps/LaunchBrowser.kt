package stepdefinitions.websteps

import cucumber.api.java8.En
import drivers.DriverManager.openBrowser
import drivers.DriverManager.driver
import drivers.DriverManager.closeBrowser

class LaunchBrowser: En {
    init{
        Given("^I open \"(Firefox|Chrome)\"") { browser : String ->
            openBrowser(browser)
            driver().manage().window().maximize()
        }

        Given("^I close the browser(?: (session))?") { session: String? ->
            closeBrowser(session != null, true)
        }
    }
}