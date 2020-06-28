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
    @ZenMethod
    public static void addRepairItem(String material, IItemStack stack, int amount)
    {
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                Utils.addRepairMaterial(material, InputHelper.toStack(stack), amount);
            }

            @Override
            public String describe()
            {
                return "Added "+stack.getDisplayName()+" to "+material;
            }
        });
    }

    @ZenMethod
    public static void setRepresentativeItem(String material, IOreDictEntry oredict)
    {
        Material mat = Utils.getMaterial(material);
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                mat.setRepresentativeItem(InputHelper.toString(oredict));
            }

            @Override
            public String describe()
            {
                return "Set "+InputHelper.toString(oredict)+" the representative item for "+material;
            }
        });
    }
    @ZenMethod
    public static void setRepresentativeItem(String material, IItemStack stack)
    {
        Material mat = Utils.getMaterial(material);
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                mat.setRepresentativeItem(InputHelper.toStack(stack));
            }

            @Override
            public String describe()
            {
                return "Set "+stack.getDisplayName()+" the representative item for "+material;
            }
        });
    }
    @ZenMethod
    public static ILiquidStack getFluid(String material)
    {
        Material mat = Utils.getMaterial(material);
        return InputHelper.toILiquidStack(new FluidStack(mat.getFluid(), 1));
    }
    @ZenMethod
    public static void setFluid(String material, ILiquidStack stack)
    {
        Material mat = Utils.getMaterial(material);
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                mat.setFluid(InputHelper.toFluid(stack).getFluid());
            }

            @Override
            public String describe()
            {
                return "Set "+stack.getDisplayName()+" the fluid for "+material;
            }
        });
    }
}
