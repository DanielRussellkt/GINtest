package stepdefinitions.utilsteps

object Timer {
    fun waitForPeriod(seconds: Long) {
        val initTime = java.util.Calendar.getInstance().timeInMillis
        while (java.util.Calendar.getInstance().timeInMillis < (initTime + (seconds*1000))) {
        }
    }
}