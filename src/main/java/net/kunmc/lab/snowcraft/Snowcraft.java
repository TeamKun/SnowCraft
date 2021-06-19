package net.kunmc.lab.snowcraft;

import net.kunmc.lab.snowcraft.message.MessageConst;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static net.kunmc.lab.snowcraft.command.CommandConst.*;

public final class Snowcraft extends JavaPlugin {

    private static GameManager gameManager;

    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();
        ConfigData configData = ConfigData.getInstance();
        int amount = Integer.parseInt(Objects.requireNonNull(config.getString(ConfigData.AMOUNT_STRING)));
        int range = Integer.parseInt(Objects.requireNonNull(config.getString(ConfigData.RANGE_STRING)));

        configData.setAmount(amount);
        configData.setRange(range);

        gameManager = new GameManager();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equals(CMD)) {
            if (args.length < 1) {
                sender.sendMessage(MessageConst.ERROR_LESS_ARGS);
                return false;
            }

            switch (args[0].toLowerCase()) {
                case GAME_START:
                    return startGame(sender);

                case GAME_END:
                    return endGame();

                //現在存在するチームを読み込む
                case SET_LEADER:
                    return setLeader(sender, args);

                case SET_CONFIG:
                    setConfig(sender, args);
                    break;

                default:
                    return false;
            }
        }
    }

    private boolean startGame(CommandSender sender) {
        //リーダーが決まっていなかったら適当に決める
        if (gameManager.getLeaderName().equals("")) {
            //todo ランダムで設定
            String leaderName = "test";
            gameManager.setLeaderName(leaderName);
        }
        gameManager.runTaskTimer(this, 0, 10);
        return true;
    }

    private boolean setLeader(CommandSender sender, String[] args) {
        if (args.length != 2) {
            sender.sendMessage(MessageConst.ERROR_LESS_ARGS);
        }
        String leaderName = args[1];
        //todo リーダー名が現在存在するプレイヤーか確認
        if(){
            //存在するプレイヤー名を設定してください
            return true;
        }
        gameManager.setLeaderName(leaderName);
        return true;
    }

    //todo resetコマンド実装

    private boolean endGame() {
        gameManager.setEndFlag(true);
        return true;
    }

    private void setConfig(CommandSender sender, String[] args) {
        if (args.length != 3) {
            sender.sendMessage(MessageConst.ERROR_LESS_ARGS);
            return;
        }

        if (AMOUNT.equals(args[1])) {
            sender.sendMessage(MessageConst.getConfigSet(AMOUNT, Integer.parseInt(args[2])));
            ConfigData.getInstance().setAmount(Integer.parseInt(args[2]));
        } else if (RANGE.equals(args[1])) {
            sender.sendMessage(MessageConst.getConfigSet(RANGE, Integer.parseInt(args[2])));
            ConfigData.getInstance().setRange(Integer.parseInt(args[2]));
        } else {
            sender.sendMessage(MessageConst.ERROR_CONFIG_ITEM);
            return;
        }
        configUpdate();
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
