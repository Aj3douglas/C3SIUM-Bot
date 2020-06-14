package org.aj3douglas.c3siumbot.config;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.properties.Property;

import java.io.File;

public class Config {
    private final SettingsManager settingsManager = SettingsManagerBuilder.withYamlFile(new File("config", "config.yml"))
            .configurationData(Settings.class).useDefaultMigrationService().create();

    public <T> T get(Property<T> property){
        return settingsManager.getProperty(property);
    }
}


