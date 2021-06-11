package net.kunmc.lab.snowcraft;

public class ConfigData {

    /**
     * 雪が降る量
     */
    public static final String AMOUNT_STRING = "amount";

    public static final int AMOUNT_MIN = 1;
    public static final int AMOUNT_MAX = 10;

    public static final int RANGE_MIN = 1;
    public static final int RANGE_MAX = 50;

    /**
     * 雪が降る範囲
     */
    public static final String RANGE_STRING = "range";

    private int amount;

    private int range;

    private ConfigData() {
        this.amount = 0;
        this.range = 0;
    }

    public static ConfigData getInstance() {
        return ConfigInstanceHolder.INSTANCE;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Configクラスの唯一のインスタンスを保持する内部クラス
     */
    public static class ConfigInstanceHolder {
        private static final ConfigData INSTANCE = new ConfigData();
    }
}
