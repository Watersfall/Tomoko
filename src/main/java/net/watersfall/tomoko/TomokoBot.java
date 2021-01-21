package net.watersfall.tomoko;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class TomokoBot
{
	public static final TomokoBot INSTANCE;

	static
	{
		INSTANCE = new TomokoBot(System.getenv("TOMOKO_TOKEN"));
	}

	private final DiscordApi api;

	private TomokoBot(String token)
	{
		this.api = new DiscordApiBuilder().setToken(token).login().join();
	}

	public static void main(String... args) { }
}
