import java.util.HashMap;


public class EasyEditListener extends PluginListener{
	HashMap<String,String> hmap1 = new HashMap<String,String>();
	HashMap<String,String> hmap2 = new HashMap<String,String>();
	HashMap<String,String> hmap3 = new HashMap<String,String>();
	HashMap<String,String> hmap4 = new HashMap<String,String>();
	 public boolean onCommand(Player player, String[] split) {
		 if (split[0].equalsIgnoreCase("/easyedit")&&player.canUseCommand("/easyedit")){
		 if (split.length < 3 || split.length >20){
		 player.notify("The correct usage is '/easyedit <sign line> <text>'");
		 return true;
	 }else if(!split[1].equals("4") && !split[1].equals("1") && !split[1].equals("2")&& !split[1].equals("3")){
		 player.notify("Please define an correct line number");
		 return true;
	 }
		 String str = split[2];
		int length = str.length( );
		if (length > 15){
				player.notify("Max 15 letters allowed on a rule");
			}
		else if (split[1].equals("1")){
			if (hmap1.containsKey(player.getName())){
				player.sendMessage("§cYou are already editing line 1 please do /stopedit <1|2|3|4|A>");
				return true;
			}
			String l1 = etc.combineSplit(2, split, " ");
				hmap1.put(player.getName(),l1);
				player.sendMessage("§2You can now rightklick any sign to edit the text.");
				player.sendMessage(hmap1.get(player.getName()));
				return true;
			}
		else if (split[1].equals("2")){
			if (hmap2.containsKey(player.getName())){
				player.sendMessage("§cYou are already editing line 2 please do /stopedit <1|2|3|4|A>");
				return true;
			}
			String l2 = etc.combineSplit(2, split, " ");
			hmap2.put(player.getName(), l2);
			player.sendMessage("§2You can now rightklick any sign to edit the text.");
			return true;
		}
		else if (split[1].equals("3")){
			if (hmap3.containsKey(player.getName())){
				player.sendMessage("§cYou are already editing line 3 please do /stopedit <1|2|3|4|A>");
				return true;
			}
			String l3 = etc.combineSplit(2, split, " ");
			hmap3.put(player.getName(), l3);
			player.sendMessage("§2You can now rightklick any sign to edit the text.");
			return true;
		}
		else if (split[1].equals("4")){
			if (hmap4.containsKey(player.getName())){
				player.sendMessage("§cYou are already editing line 4 please do /stopedit <1|2|3|4|A>");
				return true;
			}
			String l4 = etc.combineSplit(2, split, " ");
			hmap4.put(player.getName(), l4);
			player.sendMessage("§2You can now rightklick any sign to edit the text.");
			return true;
		}
		 }else if (split[0].equalsIgnoreCase("/stopedit")&&player.canUseCommand("/easyedit")){
			 if (split.length <2 || split.length >2){
				 player.notify("The correct usage is /stopedit <1|2|3|4|A>");
				 return true;
			 }
			 else if (split[1].equalsIgnoreCase("A")){
					 hmap1.remove(player.getName());
					 hmap2.remove(player.getName());
					 hmap3.remove(player.getName());
					 hmap4.remove(player.getName());
				 player.sendMessage("§2You stopped with editing signs.");
				 return true;
			 }
			 else if (split[1].equals("1")){
				 if (hmap1.containsKey(player.getName())){
					 hmap1.remove(player.getName());
					 player.sendMessage("§3You stopped editing line 1.");
					 return true;
				 }else{
					 player.sendMessage("§2You are not editing line 1 to stop you editing it.");
					 return true;
				 }
			 }
			 else if (split[1].equals("2")){
				 if (hmap2.containsKey(player.getName())){
					 hmap2.remove(player.getName());
					 player.sendMessage("§3You stopped editing line 2.");
					 return true;
				 }else{
					 player.sendMessage("§2You are not editing line 2 to stop you editing it.");
					 return true;
				 }
			 }
			 else if (split[1].equals("3")){
				 if (hmap3.containsKey(player.getName())){
					 hmap3.remove(player.getName());
					 player.sendMessage("§3You stopped editing line 3.");
					 return true;
				 }else{
					 player.sendMessage("§2You are not editing line 3 to stop you editing it.");
					 return true;
				 }
			 }
			 else if (split[1].equals("4")){
				 if (hmap4.containsKey(player.getName())){
					 hmap4.remove(player.getName());
					 player.sendMessage("§3You stopped editing line 4.");
					 return true;
				 }else{
					 player.sendMessage("§2You are not editing line 4 to stop you editing it.");
					 return true;
				 }
			 }
		 }
		return false;
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean onBlockRightClick(Player player,Block block,Item itemInHand){
		 if (hmap1.containsKey(player.getName())||hmap2.containsKey(player.getName())||hmap3.containsKey(player.getName())||hmap4.containsKey(player.getName())){
		 if (block.getType() == 68 || block.getType() == 63){
			 Sign sign = (Sign)block.getWorld().getComplexBlock(block.getX(), block.getY(), block.getZ());
			 
			 if (hmap1.containsKey(player.getName())){
				 String txt1 = hmap1.get(player.getName());
				 txt1 = txt1.replaceAll("&", "§");
				 sign.setText(0, txt1);
				 sign.update();
			 }
			 if(hmap2.containsKey(player.getName())){
				 String txt2 = hmap2.get(player.getName());
				 txt2 = txt2.replaceAll("&", "§");
				 sign.setText(1, txt2);
				 sign.update();
			 }
			 if(hmap3.containsKey(player.getName())){
				 String txt3 = hmap3.get(player.getName());
				 txt3 = txt3.replaceAll("&", "§");
				 sign.setText(2, txt3);
				 sign.update();
		     }
			 if(hmap4.containsKey(player.getName())){
			     String txt4 = hmap4.get(player.getName());
			     txt4 = txt4.replaceAll("&", "§");
			     sign.setText(3, txt4);
				 sign.update();
		 }
	 }
}
		return false;
	 }
}
