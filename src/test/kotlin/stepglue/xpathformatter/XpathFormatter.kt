package stepglue.xpathformatter

import kotlin.test.assertEquals

object XpathFormatter {
        fun generateWebXpath (element: String, additionalProperties: List<String>?, additionalValues: List<String>?): Array<String> {
            println("\n\n\nXpathHead = .//*[@\nXpath tail = ${generateXpathTail(element, additionalProperties, additionalValues)}")
            return arrayOf(".//*[@", generateXpathTail(element, additionalProperties, additionalValues))
        }

        private fun generateXpathTail (element: String, additionalProperties: List<String>?, additionalValues: List<String>?): String {
            return "='$element'${if (additionalProperties != null && additionalValues != null) {
                assertEquals(additionalProperties.size, additionalValues.size, "Additional properties and values are not of equal size")
                additionalProperties.mapIndexed {index: Int, property: String ->
                    " and @$property='${additionalValues[index]}'"
                }.joinToString(separator = "")
            } else ""}]"
        }
    }