package net.watersfall.tomoko.weeb;

import net.watersfall.tomoko.util.EmbedUtils;
import net.watersfall.tomoko.util.FileUtils;
import net.watersfall.tomoko.util.MessageUtils;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.List;

public class GenericCommands
{
	private static final List<String> smugs;

	static
	{
		smugs = FileUtils.readFile("smug.txt");
	}

	public static void smugCommand(MessageCreateEvent event)
	{
		if(!event.getMessageAuthor().isBotUser())
		{
			if(event.getMessageContent().equalsIgnoreCase("smug"))
			{
				String[] args = MessageUtils.getArgs(event.getMessageContent());
				if(args.length == 0)
				{
					int random = (int)(Math.random() * smugs.size());
					event.getChannel().sendMessage(EmbedUtils.getImageEmbed("Smug #" + random, smugs.get(random)));
				}
				else if(args.length == 1 && args[0].matches("-?\\d+"))
				{
					int index = Integer.parseInt(args[0]);
					event.getChannel().sendMessage(EmbedUtils.getImageEmbed("Smug #" + index, smugs.get(index)));
				}
			}
		}
	}
}
