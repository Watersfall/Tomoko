package net.watersfall.tomoko.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileUtils
{
	public static final Path DIRECTORY = Paths.get(System.getProperty("user.home"), "tomoko-bot-files");

	static
	{
		DIRECTORY.toFile().mkdir();
	}

	public static List<String> readFile(String name)
	{
		Path path = DIRECTORY.resolve(name);
		if(path.toFile().exists())
		{
			try
			{
				return Files.readAllLines(path);
			}
			catch(IOException ignored) { }
		}
		return List.of();
	}

	public static void writeFile(String name, List<String> list)
	{
		Path path = DIRECTORY.resolve(name);
		File file = path.toFile();
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch(IOException e)
			{
				return;
			}
		}
		try
		{
			Files.write(path, list, StandardOpenOption.WRITE);
		}
		catch(IOException ignored) { }
	}

	public static void appendToFile(String name, String string)
	{
		Path path = DIRECTORY.resolve(name);
		File file = path.toFile();
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch(IOException e)
			{
				return;
			}
		}
		try
		{
			Files.writeString(path, string, StandardOpenOption.APPEND);
		}
		catch(IOException ignored) { }
	}
}
