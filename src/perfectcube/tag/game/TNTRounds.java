package perfectcube.tag.game;

import org.bukkit.scheduler.BukkitRunnable;
import perfectcube.tag.TNTTag;

public class TNTRounds {

    private int r;
    private boolean deathmatch;

    public TNTRounds(int r, boolean deathmatch) {
        this.r = r;
        this.deathmatch = deathmatch;
    }


    public void start(int time) {
        int t = time;
        t = (!deathmatch) ? t-5:30;
        TNTTimer tr = new TNTTimer("seconds", t);
        tr.run();

        new BukkitRunnable() {
            public void run() {
                if (tr.isFinished()) {
                    // explotar a los jugadores porque aqui termino la ronda
                    cancel();
                }
            }
        }.runTaskTimer(TNTTag.getInstance(), 20, 20);
    }

}