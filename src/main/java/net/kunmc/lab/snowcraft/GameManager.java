package net.kunmc.lab.snowcraft;

import org.bukkit.scheduler.BukkitRunnable;

public class GameManager extends BukkitRunnable {

    private String leaderName;

    private boolean endFlag;

    public void setEndFlag(boolean endFlag){
        this.endFlag = endFlag;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
        //todo xxの周りに雪がふる気配がする…
    }

    public String getLeaderName(){
        return leaderName;
    }

    public void run(){
        if(endFlag){
            //todo 雪がやんだ
            cancel();
        }
        //todo rangeに従い範囲算出
        //todo amountと範囲からどこに振らせるか決める
        //todo どこから振らせるか検討　プレイヤーの上nマス固定か、一番上からか
    }
}
