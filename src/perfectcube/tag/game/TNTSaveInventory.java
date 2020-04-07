package perfectcube.tag.game;

import org.bukkit.GameMode;
import org.bukkit.inventory.ItemStack;

public class TNTSaveInventory {

    private ItemStack[] inventory;
    private ItemStack[] equipment;
    private GameMode gamemode;
    private float experience;
    private int level;
    private int food;
    private double health;
    private double maximumHealth;

    public TNTSaveInventory(ItemStack[] inventory, ItemStack[] equipment, GameMode gamemode, float experience, int level, int food, double health, double maximumHealth) {
        this.inventory = inventory;
        this.equipment = equipment;
        this.gamemode = gamemode;
        this.experience = experience;
        this.level = level;
        this.food = food;
        this.health = health;
        this.maximumHealth = maximumHealth;
    }

    public ItemStack[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemStack[] inventory) {
        this.inventory = inventory;
    }

    public ItemStack[] getEquipment() {
        return equipment;
    }

    public void setEquipment(ItemStack[] equipment) {
        this.equipment = equipment;
    }

    public GameMode getGamemode() {
        return gamemode;
    }

    public void setGamemode(GameMode gamemode) {
        this.gamemode = gamemode;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMaximumHealth() {
        return maximumHealth;
    }

    public void setMaximumHealth(double maximumHealth) {
        this.maximumHealth = maximumHealth;
    }
}