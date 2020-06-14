package org.aj3douglas.c3siumbot.config;

import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;

import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class Settings implements SettingsHolder {
    public static final Property<String> BOT_TOKEN = newProperty("bot.token", "BOT_TOKEN");
    public static final Property<String> STATUS = newProperty("bot.status", "BOT_STATUS");
    public static final Property<String> KEWL_KAT = newProperty("roles.kewl_kat", "KEWL KAT");

    private Settings(){ }
}
