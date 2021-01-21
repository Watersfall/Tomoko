package net.watersfall.tomoko.util;

import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;

public class EmbedUtils
{
	public static EmbedBuilder getErrorEmbed(String message)
	{
		EmbedBuilder builder = new EmbedBuilder();
		builder.setTitle("Error!")
				.setColor(Color.RED)
				.setDescription(message);
		return builder;
	}
}
