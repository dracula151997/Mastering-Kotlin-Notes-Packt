package packt.masteringkotlinbook.ch4

interface SettingsProvider {
    fun getSetting(key: String): String
}

object SettingsManager : SettingsProvider {
    private val map = HashMap<String, String>()
    override fun getSetting(key: String): String {
        return map.getOrDefault(key, "")
    }

    fun printSettings() = map.forEach { println(it) }

}

class UserManager : SettingsProvider by SettingsManager

fun main() {

    val settingsProvider: SettingsProvider = SettingsManager
    (settingsProvider as SettingsManager).printSettings()
}