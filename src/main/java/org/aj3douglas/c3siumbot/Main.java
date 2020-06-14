package org.aj3douglas.c3siumbot;

import me.mattstudios.mfjda.base.CommandManager;
import me.mattstudios.mfjda.base.components.RequirementResolver;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.aj3douglas.c3siumbot.commands.Status;
import org.aj3douglas.c3siumbot.config.Config;
import org.aj3douglas.c3siumbot.config.Settings;
import org.aj3douglas.c3siumbot.listeners.MessageListener;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        Config config = new Config();
        JDABuilder jdaBuilder = new JDABuilder();
        jdaBuilder.setToken(config.get(Settings.BOT_TOKEN));
        jdaBuilder.setActivity(Activity.watching(config.get(Settings.STATUS)));
        jdaBuilder.addEventListeners(new MessageListener(config));
        JDA jda = jdaBuilder.build();
        setupCommands(jda, config);
    }
    private static void setupCommands(JDA jda, Config config){
        CommandManager cm = new CommandManager(jda, "!");
        cm.registerRequirement("#kewlKat", member-> {
            if(member.getRoles().contains(jda.getRoleById(config.get(Settings.KEWL_KAT)))) return true;
            else return false;
        });
        cm.register(new Status());
    }
}
