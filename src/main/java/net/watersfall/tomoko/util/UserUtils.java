package net.watersfall.tomoko.util;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.Event;

public class UserUtils
{
	public static boolean isWaters(MessageAuthor user)
	{
		return user.getId() == 138019890018648064L;
	}
}
