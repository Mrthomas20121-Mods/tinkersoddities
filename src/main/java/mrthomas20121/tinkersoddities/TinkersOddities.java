package mrthomas20121.tinkersoddities;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TinkersOddities.MODID, name = TinkersOddities.NAME, version = TinkersOddities.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);"
                + "required-after:biolib@[1.0.4,);"
                + "required-after:mantle@[1.12-1.3.3.55,);"
                + "required-after:tconstruct@[1.12.2-2.13.0.183,);")
public class TinkersOddities {
    public static final String MODID = "tinkersoddities";
    public static final String NAME = "Tinkers Oddities";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        logger = event.getModLog();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
