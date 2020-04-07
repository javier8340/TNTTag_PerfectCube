package perfectcube.tag.game;

import org.bukkit.entity.Player;

public class TNTPlayer {

    private Player player;
    private TNTSaveInventory inventory;
    private boolean isPlayer;
    private boolean isIT;

    public TNTPlayer(Player player){
        this.player = player;
        this.inventory = new TNTSaveInventory(player.getInventory().getContents(), player.getInventory().getArmorContents(), player.getGameMode(), player.getExp(),
                player.getLevel(), player.getFoodLevel(), player.getHealth(), player.getMaxHealth());
    }

    public TNTSaveInventory getInventory(){
        return this.inventory;
    }

    public Player getPlayer(){
        return this.player;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    public boolean isIT() {
        return isIT;
    }

    public void setIT(boolean IT) {
        isIT = IT;
    }
}