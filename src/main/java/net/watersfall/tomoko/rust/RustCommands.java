package net.watersfall.tomoko.rust;

import net.watersfall.tomoko.TomokoBot;
import net.watersfall.tomoko.util.EmbedUtils;
import net.watersfall.tomoko.util.MessageUtils;
import net.watersfall.tomoko.util.UserUtils;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.event.message.MessageCreateEvent;

public class RustCommands
{
	public static void whitelist(MessageCreateEvent event)
	{
		if(event.getMessage().getContent().startsWith("%whitelist"))
		{
			String[] args = MessageUtils.getArgs(event.getMessageContent());
			TextChannel channel = event.getChannel();
			if(args.length == 0)
			{
				channel.sendMessage(EmbedUtils.getErrorEmbed("Please specify your 64 bit integer Steam ID!"));
			}
			else
			{
				try { Long.parseLong(args[0]); }
				catch(NumberFormatException e) { channel.sendMessage(EmbedUtils.getErrorEmbed("Invalid Steam ID!")); }
				TomokoBot.RUST_INSTANCE.send(String.format("oxide.grant user %s whitelist.allow", args[0]));
			}
		}
	}

	public static void removeWhitelist(MessageCreateEvent event)
	{
		if(event.getMessage().getContent().startsWith("%remove_whitelist"))
		{
			TextChannel channel = event.getChannel();
			if(UserUtils.isWaters(event.getMessageAuthor()))
			{
				String[] args = MessageUtils.getArgs(event.getMessageContent());
				if(args.length == 0)
				{
					channel.sendMessage(EmbedUtils.getErrorEmbed("Please specify a 64 bit integer Steam ID!"));
				}
				else
				{
					try { Long.parseLong(args[0]); }
					catch(NumberFormatException e) { channel.sendMessage(EmbedUtils.getErrorEmbed("Invalid Steam ID!")); }
					TomokoBot.RUST_INSTANCE.send(String.format("oxide.revoke user %s whitelist.allow", args[0]));
				}
			}
			else
			{
				channel.sendMessage(EmbedUtils.getErrorEmbed("You are not allowed to do this!"));
			}
		}
	}

	public static void stop(MessageCreateEvent event)
	{
		if(event.getMessage().getContent().startsWith("%stop"))
		{
			TextChannel channel = event.getChannel();
			if(UserUtils.isWaters(event.getMessageAuthor()))
			{
				TomokoBot.RUST_INSTANCE.send("quit");
			}
			else
			{
				channel.sendMessage(EmbedUtils.getErrorEmbed("You are not allowed to do this!"));
			}
		}
	}
}
