package stepdefinitions.utilsteps

import cucumber.api.Scenario
import cucumber.api.java8.En
import drivers.DriverManager.closeBrowser

class Teardown: En {
    init {
        After { _: Scenario ->
        closeBrowser(true, false)
        }
    }
}