package perfectcube.tag.game;

import org.bukkit.Location;

import java.util.ArrayList;

public class TNTTeam {

    private ArrayList<TNTPlayer> players;
    private String type;
    private Location spawn;

    public TNTTeam(String type){
        this.players = new ArrayList<TNTPlayer>();
        this.type = type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public boolean containsPlayer(String player){
        for(int i=0; i<players.size(); i++){
            if(players.get(i).getPlayer().getName().equals(player)){
                return true;
            }
        }
        return false;
    }

    public boolean addPlayer(TNTPlayer player){
        if(!containsPlayer(player.getPlayer().getName())){
            this.players.add(player);
            return true;
        } else {
            return false;
        }
    }

    public boolean removePlayer(String player){
        for(int i=0; i<players.size(); i++){
            if(players.get(i).getPlayer().getName().equals(player)){
                this.players.remove(player);
                return true;
            }
        }
        return false;
    }

    public ArrayList<TNTPlayer> getPlayers() {
        return players;
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public int getValuePlayers(){
        return this.players.size();
    }
}