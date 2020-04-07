package perfectcube.tag;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public class TNTTag extends JavaPlugin {

    public String rutaConfig;

    private FileConfiguration data = null;
    private File dataFile = null;

    private static TNTTag t;
    public static TNTTag getInstance(){
        return t;
    }

    public void onEnable(){
        t = this;
    }

    public void registerEvents(){
        PluginManager pm = Bukkit.getServer().getPluginManager();
    }

    public void registerCommands(){

    }

    public void registerConfig(){
        File config = new File(this.getDataFolder(), "config.yml");
        rutaConfig = config.getPath();
        if(!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

    public void registerData() {
        dataFile = new File(this.getDataFolder(), "data.yml");
        if(!dataFile.exists()) {
            this.getData().options().copyDefaults(true);
            saveData();
        }
    }

    public void saveData() {
        try {
            data.save(dataFile);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getData() {
        if(data == null) {
            reloadData();
        }
        return data;
    }

    public void reloadData() {
        if(data == null) {
            dataFile = new File(getDataFolder(), "data.yml");
        }
        data = YamlConfiguration.loadConfiguration(dataFile);

        Reader defConfigStream;
        try {
            defConfigStream = new InputStreamReader(this.getResource("data.yml"),"UTF8");
            if(defConfigStream != null) {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                data.setDefaults(defConfig);
            }
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}