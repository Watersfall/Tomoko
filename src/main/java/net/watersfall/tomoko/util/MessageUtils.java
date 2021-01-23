package net.watersfall.tomoko.util;

public class MessageUtils
{
	public static String[] getArgs(String message)
	{
		String[] all = message.split(" ");
		if(all.length == 1)
		{
			return new String[0];
		}
		else
		{
			String[] args = new String[all.length - 1];
			System.arraycopy(all, 1, args, 0, args.length);
			return args;
		}
	}

	public static String getCommand(String message)
	{
		if(!message.contains(" "))
		{
			return message.trim();
		}
		else
		{
			return message.substring(0, message.indexOf(" ")).trim();
		}
	}
}
