package perfectcube.tag.game;

import org.bukkit.Location;
import perfectcube.tag.TNTTag;
import perfectcube.tag.utils.TNTConfig;

import java.util.ArrayList;

public class TNTGame {

    private TNTTeam playersg;
    private TNTTeam it;
    private String name;
    private int maximumPlayers;
    private int minimumPlayers;
    private int currentPlayers;
    private TNTGameState state;
    private Location lobby;

    public TNTGame(String name){
        this.playersg = new TNTTeam("players");
        this.it = new TNTTeam("it");
        this.name = name;
        this.currentPlayers = 0;
        this.maximumPlayers = TNTConfig.getInt(TNTTag.getInstance().getConfig(), "Game.Maximum_Players");
        this.minimumPlayers = TNTConfig.getInt(TNTTag.getInstance().getConfig(), "Game.Minimum_Players");
        this.state = TNTGameState.DISABLED;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(TNTPlayer player){
        if(playersg.addPlayer(player)){
            this.currentPlayers++;
        }
    }

    public void randomPlayers(TNTPlayer player){
        this.playersg.removePlayer(player.getPlayer().getName());
        this.it.addPlayer(player);
    }

    public void removePlayer(String player){
        if(playersg.removePlayer(player) || it.removePlayer(player)){
            this.currentPlayers--;
        }
    }

    public ArrayList<TNTPlayer> getPlayers(){
        ArrayList<TNTPlayer> players = new ArrayList<TNTPlayer>();
        for(TNTPlayer p : playersg.getPlayers()){
            players.add(p);
        }
        for(TNTPlayer p : it.getPlayers()){
            players.add(p);
        }

        return players;
    }

    public TNTPlayer getPlayer(String player){
        ArrayList<TNTPlayer> players = getPlayers();
        for(int i=0; i<players.size(); i++){
            if(players.get(i).getPlayer().getName().equals(player)){
                return players.get(i);
            }
        }
        return null;
    }

    public TNTTeam getTeamPlayer(String player){
        ArrayList<TNTPlayer> playersg1 = getPlayers();
        for(int i=0; i<playersg1.size(); i++){
            if(playersg1.get(i).getPlayer().getName().equals(player)){
                return this.playersg;
            }
        }

        ArrayList<TNTPlayer> its = getPlayers();
        for(int i=0; i<its.size(); i++){
            if(its.get(i).getPlayer().getName().equals(player)){
                return this.it;
            }
        }

        return null;
    }

    public TNTTeam getPlayersg(){
        return this.playersg;
    }

    public TNTTeam getIt(){
        return this.it;
    }

    public int getMaximumPlayers(){
        return this.maximumPlayers;
    }

    public void setMaximumPlayers(int max){
        this.maximumPlayers = max;
    }

    public int getMinimumPlayers(){
        return this.maximumPlayers;
    }

    public void setMinimumPlayers(int max){
        this.maximumPlayers = max;
    }

    public int getCurrentPlayers(){
        return this.maximumPlayers;
    }

    public void setCurrentPlayers(int max){
        this.maximumPlayers = max;
    }

    public TNTGameState getState(){
        return this.state;
    }

    public void setState(TNTGameState state){
        this.state = state;
    }

    public boolean isRunning(){
        if(state.equals(TNTGameState.WAITING) || state.equals(TNTGameState.DISABLED) || state.equals(TNTGameState.STARTING)){
            return false;
        } else {
            return true;
        }
    }

    public boolean isFull(){
        if(this.currentPlayers == this.maximumPlayers){
            return true;
        } else {
            return false;
        }
    }

    public boolean isEnabled(){
        if(!state.equals(TNTGameState.DISABLED)){
            return true;
        } else {
            return false;
        }
    }

    public Location getLobby() {
        return lobby;
    }

    public void setLobby(Location lobby) {
        this.lobby = lobby;
    }
}