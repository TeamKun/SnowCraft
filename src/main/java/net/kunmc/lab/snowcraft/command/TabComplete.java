package net.kunmc.lab.snowcraft.command;

import net.kunmc.lab.snowcraft.ConfigData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

import static net.kunmc.lab.snowcraft.command.CommandConst.*;

public class TabComplete {
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> completes = new ArrayList<>();
        int subCommandLength = args.length;

        if (subCommandLength == 1) {
            completes.add(GAME_START);
            completes.add(GAME_END);
            completes.add(SET_LEADER);
            completes.add(SET_CONFIG);
        } else if (subCommandLength == 2) {
            if (SET_LEADER.equals(args[0])) {

            } else if (SET_CONFIG.equals(args[0])) {
                completes.add(AMOUNT);
                completes.add(RANGE);
            }
        } else if (subCommandLength == 3) {
            if (SET_CONFIG.equals(args[0])) {
                if (AMOUNT.equals(args[1])) {
                    completes.add(ConfigData.AMOUNT_MIN + "～" + ConfigData.AMOUNT_MAX);
                } else if (RANGE.equals(args[1])) {
                    completes.add(ConfigData.RANGE_MIN + "～" + ConfigData.RANGE_MAX);
                }
            }
        }
        return completes;
    }
}