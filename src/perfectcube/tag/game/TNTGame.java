package perfectcube.tag.game;

import org.bukkit.Location;

public class TNTGame {

    private TNTTeam players;
    private TNTTeam it;
    private String name;
    private int maximumPlayers;
    private int minimumPlayers;
    private int currentPlayers;
    private TNTGameState state;
    private Location lobby;
    private int time;
    private int maximumTime;

    public TNTGame(String name){
        this.players = new TNTTeam("players");
        this.it = new TNTTeam("it");
        this.name = name;
        this.currentPlayers = 0;
        this.maximumPlayers = 30;
        this.minimumPlayers = 20;
    }
}