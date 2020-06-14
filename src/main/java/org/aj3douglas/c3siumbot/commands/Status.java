package org.aj3douglas.c3siumbot.commands;

import me.mattstudios.mfjda.annotations.*;
import me.mattstudios.mfjda.base.CommandBase;
import net.dv8tion.jda.api.entities.Activity;

@Prefix("~")
@Command("status")
public class Status extends CommandBase {
    @Delete
    @Default
    @Requirement("#kewlKat")
    public void status(String type, String status){
        switch (type){
            case "watching":
                getMessage().getJDA().getPresence().setActivity(Activity.watching(status));
                break;
            case "playing":
                getMessage().getJDA().getPresence().setActivity(Activity.playing(status));
                break;
        }
    }
}
