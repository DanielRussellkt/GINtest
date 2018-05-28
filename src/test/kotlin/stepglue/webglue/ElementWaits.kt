package stepglue.webglue

import stepglue.webglue.ElementLocation.isElementFound

object ElementWaits {
    fun waitForElement(element: String, properties: String?, values: String?, timeout: Long): Boolean {
        val initTime = java.util.Calendar.getInstance().timeInMillis
        while (java.util.Calendar.getInstance().timeInMillis < (initTime + timeout)) {
            if (isElementFound(element, properties, values)) return true
        }
        return false
    }

    fun waitForVanish(element: String, properties: String?, values: String?, timeout: Long): Boolean {
        val initTime = java.util.Calendar.getInstance().timeInMillis
        while (java.util.Calendar.getInstance().timeInMillis < (initTime + timeout)) {
            if (!isElementFound(element, properties, values)) return true
        }
        return false
    }
}