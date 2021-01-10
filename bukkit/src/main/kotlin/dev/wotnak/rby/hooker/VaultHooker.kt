package dev.wotnak.rby.hooker

import net.milkbowl.vault.economy.Economy

class VaultHooker : PluginHooker {

    override val pluginName = "Vault"
    override var hasHooked = false
    lateinit var economy: Economy

    override fun hook(plugin: dev.wotnak.rby.Rby) {
        PluginHooker.checkEnabled(this, plugin.server.pluginManager)

        val registration = plugin.server.servicesManager.getRegistration(Economy::class.java) ?: null
        if (registration != null) {
            economy = registration.provider
        }
        hasHooked = true
    }

    fun hasEconomy(): Boolean {
        return ::economy.isInitialized
    }

}