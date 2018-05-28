package stepglue.xpathformatter

enum class XpathProperties(val xpathTag: String) {
    TEXT("text()"),
    ID("@id"),
    NAME("@name"),
    CLASS("@class"),
    PLACEHOLDER("@placeholder"),
}
