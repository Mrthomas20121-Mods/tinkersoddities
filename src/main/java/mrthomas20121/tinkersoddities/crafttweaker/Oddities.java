package mrthomas20121.tinkersoddities.crafttweaker;


import com.blamejared.mtlib.helpers.InputHelper;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.oredict.IOreDictEntry;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.materials.Material;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import mrthomas20121.biolib.util.Utils;

@ZenClass("mods.tinkersoddities")
@ZenRegister
public class Oddities
{
    public Builder getMaterial(String material)
    {
        return new Builder(material);
    }
}
