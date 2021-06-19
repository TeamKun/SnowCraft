package net.kunmc.lab.snowcraft.message;

public class MessageConst {
    public static final String SNOW_CRAFT = "Snowcraft: ";

    public static final String ERROR_LESS_ARGS = SNOW_CRAFT + "引数の数が異なります";

    public static final String ERROR_CONFIG_ITEM = SNOW_CRAFT + "その値は更新できません";

    public static String getConfigSet(String itemName, int settingNumber) {
        return SNOW_CRAFT + "コンフィグ[" + itemName + "]を[" + settingNumber + "]に更新しました";
    }
}
