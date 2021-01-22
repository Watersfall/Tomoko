package net.watersfall.tomoko;

import io.graversen.fiber.event.bus.DefaultEventBus;
import io.graversen.rust.rcon.rustclient.RustClient;
import io.graversen.rust.rcon.serialization.DefaultSerializer;
import net.watersfall.tomoko.rust.RustCommands;
import org.java_websocket.client.WebSocketClient;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class TomokoBot
{
	public static final TomokoBot BOT_INSTANCE;
	public static final RustClient RUST_INSTANCE;

	static
	{
		BOT_INSTANCE = new TomokoBot(System.getenv("TOMOKO_TOKEN"));
		RUST_INSTANCE = RustClient.builder()
				.connectTo(
					System.getenv("RUST_ADDRESS"),
					System.getenv("RUST_PASSWORD"),
					Integer.parseInt(System.getenv("RUST_PORT")))
				.withSerializer(new DefaultSerializer())
				.withEventBus(new DefaultEventBus())
				.build();
		((WebSocketClient)(RUST_INSTANCE.getWebSocketClient())).setConnectionLostTimeout(-1);
		RUST_INSTANCE.open();
	}

	private final DiscordApi api;

	private TomokoBot(String token)
	{
		this.api = new DiscordApiBuilder().setToken(token).login().join();
		api.addMessageCreateListener(RustCommands::whitelist);
		api.addMessageCreateListener(RustCommands::removeWhitelist);
		api.addMessageCreateListener(RustCommands::stop);
	}

	public static void main(String... args) { }
}
