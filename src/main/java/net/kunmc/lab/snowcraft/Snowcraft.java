package net.kunmc.lab.snowcraft;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Snowcraft extends JavaPlugin {

    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();
        ConfigData configData = ConfigData.getInstance();
        int amount = Integer.parseInt(Objects.requireNonNull(config.getString(ConfigData.AMOUNT_STRING)));
        int range = Integer.parseInt(Objects.requireNonNull(config.getString(ConfigData.RANGE_STRING)));

        configData.setAmount(amount);
        configData.setRange(range);
    }

    public void configUpdate() {
        FileConfiguration config = getConfig();
        ConfigData configData = ConfigData.getInstance();

        config.set(ConfigData.AMOUNT_STRING, configData.getAmount());
        config.set(ConfigData.RANGE_STRING, configData.getRange());
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
