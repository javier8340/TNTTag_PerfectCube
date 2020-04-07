package perfectcube.tag.utils;

import org.bukkit.configuration.file.FileConfiguration;
import perfectcube.tag.TNTTag;

public class TNTConfig {

    public static String getString(FileConfiguration config, String path){
        String s = config.getString(path);
        return s;
    }

    public static int getInt(FileConfiguration config, String path){
        int i = config.getInt(path);
        return i;
    }

}