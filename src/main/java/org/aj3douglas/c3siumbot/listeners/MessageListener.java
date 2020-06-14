package org.aj3douglas.c3siumbot.listeners;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.aj3douglas.c3siumbot.config.Config;

import javax.annotation.Nonnull;

public class MessageListener extends ListenerAdapter {

    private Config config;

    public MessageListener(Config config) {
        this.config = config;
    }

    private TextChannel channel;
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot()) return;
        channel = event.getChannel();
        String message = event.getMessage().getContentRaw().toLowerCase();
        if(message.contains("c3sium") || message.contains("jamie")){
            reply("Did someone say my name?");
            return;
        }else if(message.contains("real")){
            reply("Im real!");
            return;
        }
        switch (message){
            case "hello":
                reply("Hello gamers");
                break;
            case "whats up":
                reply("I'm playing CSGO");
                break;
            case "what is your favourite youtuber?":
                reply("Linus tech tips ***obviously***");
                break;
            case "jack":
                reply("die");
                break;
        }
    }

    private void reply(String message){
        channel.sendMessage(message).queue();
    }
}
