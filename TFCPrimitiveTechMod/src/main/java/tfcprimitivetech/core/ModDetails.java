package tfcprimitivetech.core;

public class ModDetails 
{
	public static final String ModID = "tfcprimitivetech";
	public static final String ModName = "TFCPrimitiveTech";

	public static final int VersionMajor = 0;
	public static final int VersionMinor = 1;
	public static final int VersionRevision = 1;

	public static final String ModVersion = VersionMajor + "." + VersionMinor + "." + VersionRevision;
	public static final String ModDependencies = "after:TerraFirmaCraft";
	public static final String ModChannel = "TFCPrimitiveTech";
	public static final String SERVER_PROXY_CLASS = "tfcprimitivetech.core.ModCommonProxy";
	public static final String CLIENT_PROXY_CLASS = "tfcprimitivetech.core.ModClientProxy";
	
	public static final String AssetPath = "/assets/" + ModID + "/";
	public static final String AssetPathGui = "textures/gui/";
	
	public static final String ConfigFilePath = "/config/";
	public static final String ConfigFileName = "TFCPrimitiveTech.cfg";
	
	public static final int GuiOffset = 10000;
	
	public static final String MODID_NEI = "NotEnoughItems";
	public static final String MODID_TFC = "terrafirmacraft";
	public static final String MODID_WAILA = "Waila";

	public static final String MODNAME_NEI = "Not Enough Items";
	public static final String MODNAME_TFC = "TerraFirmaCraft";
	public static final String MODNAME_WAILA = "Waila";
}
