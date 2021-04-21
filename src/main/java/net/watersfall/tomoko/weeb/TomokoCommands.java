package net.watersfall.tomoko.weeb;

import net.watersfall.tomoko.util.EmbedUtils;
import net.watersfall.tomoko.util.FileUtils;
import net.watersfall.tomoko.util.MessageUtils;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.HashMap;
import java.util.List;

public class TomokoCommands
{
	private static final HashMap<String, String> images;
	private static final List<String> tomokos;

	static
	{
		images = new HashMap<>();
		images.put("good", "https://cdn.discordapp.com/attachments/271452428845449219/305152968079048714/b3SzPZh.gif");
		images.put("bad", "http://i1.kym-cdn.com/photos/images/original/000/667/429/ffa.png");
		images.put("dammit", "http://i1.kym-cdn.com/photos/images/original/000/667/429/ffa.png");
		images.put("damnit", "http://i1.kym-cdn.com/photos/images/original/000/667/429/ffa.png");
		images.put("derp", "https://cdn.discordapp.com/attachments/271451778770403329/309835387608760330/Tomoko_angry.png");
		images.put("mad", "https://i.imgur.com/sjyIqfk.gifv");
		images.put("cute", "http://68.media.tumblr.com/55776f35dca13d750108123386f7b1b1/tumblr_mr7ur7fGA31srsg4zo1_500.gif");
		images.put("baka", "http://pa1.narvii.com/6284/bff14727c152a9bad3e7fcdf75077ceac93338c4_hq.gif");
		images.put("kek", "https://media.tenor.co/images/7dfc00efaeaddf6f7857ff33dfbd0f4a/tenor.gif");
		images.put("laugh", "https://media.tenor.co/images/7dfc00efaeaddf6f7857ff33dfbd0f4a/tenor.gif");
		images.put("wave", "https://cdn.discordapp.com/attachments/271451778770403329/311887235035168769/1c7a8542ec840ff62963c303394caa3840da92d7_hq.gif");
		images.put("ascii", "https://pbs.twimg.com/media/C_fNjU5WAAAYvga.png");
		images.put("approve", "https://cdn.discordapp.com/attachments/271451778770403329/314025798451462144/thumbs_up.gif");
		images.put("approval", "https://cdn.discordapp.com/attachments/271451778770403329/314025798451462144/thumbs_up.gif");
		images.put("triggered", "https://cdn.discordapp.com/attachments/271452659637157890/315265632226639872/1495227038122.gif");
		images.put("dick", "https://cdn.discordapp.com/attachments/271451778770403329/321507672438341633/aha.jpg");
		images.put("sad", "https://cdn.discordapp.com/attachments/271451778770403329/321508388636983297/1473959259476.jpg");
		images.put("turned-on", "https://i.warosu.org/data/tg/img/0308/47/1394930265626.jpg");
		images.put("clap", "https://cdn.discordapp.com/attachments/271498483683426304/322920683732729858/clap_well_done.gif");
		images.put("drug", "https://cdn.discordapp.com/attachments/271494464034308106/321854133483077666/IMG_20170510_014158.jpg");
		images.put("sex", "https://cdn.discordapp.com/attachments/271451778770403329/336287606210035714/tomomote_c28_p0139-1.png");
		images.put("lewd", "https://cdn.discordapp.com/attachments/271452428845449219/346364919190519809/W_2119.png");
		images.put("charles", "http://i.imgur.com/qx7X9DQ.png");
		images.put("loli", "http://i.imgur.com/qx7X9DQ.png");
		images.put("sleep", "https://cdn.discordapp.com/attachments/271451778770403329/353781479521910785/sleeping.gif");
		tomokos = FileUtils.readFile("tomoko.txt");
	}

	public static void imageCommand(MessageCreateEvent event)
	{
		if(!event.getMessageAuthor().isBotUser())
		{
			String[] args = MessageUtils.getArgs(event.getMessageContent());
			if(args.length == 1 && "bot".equalsIgnoreCase(args[0]))
			{
				String command = MessageUtils.getCommand(event.getMessageContent());
				if(images.containsKey(command))
				{
					event.getChannel().sendMessage(command + " bot\n" + images.get(command));
				}
			}
		}
	}

	public static void tomokoCommand(MessageCreateEvent event)
	{
		if(!event.getMessageAuthor().isBotUser())
		{
			if(event.getMessageContent().equalsIgnoreCase("tomoko"))
			{
				String[] args = MessageUtils.getArgs(event.getMessageContent());
				if(args.length == 0)
				{
					int random = (int)(Math.random() * tomokos.size());
					event.getChannel().sendMessage("Tomoko #" + random + "\n" + tomokos.get(random));
				}
				else if(args.length == 1 && args[0].matches("-?\\d+"))
				{
					int index = Integer.parseInt(args[0]);
					event.getChannel().sendMessage("Tomoko #" + index + "\n" + tomokos.get(index));
				}
			}
		}
	}
}
