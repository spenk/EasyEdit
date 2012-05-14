import java.util.logging.Logger;


public class EasyEdit extends Plugin{

	static Logger log = Logger.getLogger("Minecraft");
	EasyEditListener listener = new EasyEditListener();
	
	public void disable() {
		log.info("EasyEdit v1.0 by spenk is enabled");
	}

	public void initialize(){
		log.info("EasyEdit v1.0 by spenk is initialized");
		etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);	
		etc.getLoader().addListener(PluginLoader.Hook.DISCONNECT, listener, this, PluginListener.Priority.MEDIUM);	
		etc.getLoader().addListener(PluginLoader.Hook.BLOCK_RIGHTCLICKED, listener, this, PluginListener.Priority.MEDIUM);	
	}
	
	public void enable() {
		log.info("EasyEdit v1.0 by spenk is disabled");
	}
}
