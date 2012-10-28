package com.empclan.refer;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class refer extends JavaPlugin implements Listener {
	public static refer plugin;
	Logger log;

	SQL myConnection = new SQL();
	private ReferCommandExecutor referExecutor;

	public void onEnable(){
		try {
			Config.loadConfig(this);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("failure to load config just a FYI");
		}
		getServer().getPluginManager().registerEvents(this, this);
		SQL.connect();
		SQL.doesTableExist();
		log = this.getLogger();
		log.info("refer 1.0 has been STARTED");
		referExecutor = new ReferCommandExecutor(this);
		getCommand("refer").setExecutor(referExecutor);
	}

	public void onDisable(){ 
		log = this.getLogger();
		SQL.disconnect();
		log.info("refer has been shut down :(");

	}
}