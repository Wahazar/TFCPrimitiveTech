package tfcprimitivetech.core;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import tfcprimitivetech.TFCPrimitiveTech;

public class ModOptions
{
	// General
    	private static final String CategoryName_Options = "Options";
	
	public static void loadSettings()
	{	
		System.out.println("[" + ModDetails.ModName + "] Loading options.");

		Configuration config;

		try
		{
			config = new Configuration(new File(tfcprimitivetech.TFCPrimitiveTech.instance.getMinecraftDirectory(), ModDetails.ConfigFilePath+ModDetails.ConfigFileName));
			config.load();
		} 
		catch (Exception ex) 
		{
			System.out.println("["+ModDetails.ModName+"] Error while trying to access settings configuration!");
			config = null;
		}
		
		/** Start Here **/

		loadOptions(config);
				
		/** End Here*/
		if (config != null)
			config.save();

		System.out.println("[" + ModDetails.ModName + "] Done loading options.");
	}
	
	public static boolean getBooleanFor(Configuration config,String heading, String item, boolean value)
	{
		if (config == null)
			return value;
		try
		{
			Property prop = config.get(heading, item, value);
			return prop.getBoolean(value);
		}
		catch (Exception e)
		{
			System.out.println("[" + ModDetails.ModName + "] Error while trying to add Boolean, config wasn't loaded properly!");
		}
		return value;
	}

	public static boolean getBooleanFor(Configuration config,String heading, String item, boolean value, String comment)
	{
		if (config == null)
			return value;
		try
		{
			Property prop = config.get(heading, item, value);
			prop.comment = comment;
			return prop.getBoolean(value);
		}
		catch (Exception e)
		{
			System.out.println("[" + ModDetails.ModName + "] Error while trying to add Integer, config wasn't loaded properly!");
		}
		return value;
	}

	public static int getIntFor(Configuration config, String heading, String item, int value)
	{
		if (config == null)
			return value;
		try
		{
			Property prop = config.get(heading, item, value);
			return prop.getInt(value);
		}
		catch (Exception e)
		{
			System.out.println("[" + ModDetails.ModName + "] Error while trying to add Integer, config wasn't loaded properly!");
		}
		return value;
	}

	public static int getIntFor(Configuration config,String heading, String item, int value, String comment)
	{
		if (config == null)
			return value;
		try
		{
			Property prop = config.get(heading, item, value);
			prop.comment = comment;
			return prop.getInt(value);
		}
		catch (Exception e)
		{
			System.out.println("[" + ModDetails.ModName + "] Error while trying to add Integer, config wasn't loaded properly!");
		}
		return value;
	}

	public static double getDoubleFor(Configuration config,String heading, String item, double value)
	{
		if (config == null)
			return value;
		try
		{
			Property prop = config.get(heading, item, value);
			return prop.getDouble(value);
		}
		catch (Exception e)
		{
			System.out.println("[" + ModDetails.ModName + "] Error while trying to add Double, config wasn't loaded properly!");
		}
		return value;
	}

	public static double getDoubleFor(Configuration config,String heading, String item, double value, String comment)
	{
		if (config == null)
			return value;
		try
		{
			Property prop = config.get(heading, item, value);
			prop.comment = comment;
			return prop.getDouble(value);
		}
		catch (Exception e)
		{
			System.out.println("[" + ModDetails.ModName + "] Error while trying to add Double, config wasn't loaded properly!");
		}
		return value;
	}

	public static String getStringFor(Configuration config, String heading, String item, String value)
	{
		if (config == null)
			return value;
		try
		{
			Property prop = config.get(heading, item, value);
			return prop.getString();
		} catch (Exception e)
		{
			System.out.println("[" + ModDetails.ModName + "] Error while trying to add String, config wasn't loaded properly!");
		}
		return value;
	}

	public static String getStringFor(Configuration config, String heading, String item, String value, String comment)
	{
		if (config == null)
			return value;
		try
		{
			Property prop = config.get(heading, item, value);
			prop.comment = comment;
			return prop.getString();
		} catch (Exception e)
		{
			System.out.println("[" + ModDetails.ModName + "] Error while trying to add String, config wasn't loaded properly!");
		}
		return value;
	}
    private static void loadOptions(Configuration config)
    {
        TFCPrimitiveTech.instance.isPaperEnabled = config.get(CategoryName_Options, "PaperEnabled", true).getBoolean();
        TFCPrimitiveTech.instance.isSlingshotEnabled = config.get(CategoryName_Options, "SlingshotEnabled", true).getBoolean();
        TFCPrimitiveTech.instance.isHardArrowRecipe = config.get(CategoryName_Options, "HardArrowRecipe", true).getBoolean();

    }
}
