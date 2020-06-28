package mrthomas20121.tinkersoddities.crafttweaker;

import com.blamejared.mtlib.helpers.InputHelper;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.oredict.IOreDictEntry;
import mrthomas20121.biolib.util.Utils;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.materials.Material;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.tinkersoddities.builder")
public class Builder {
    private Material material;
    public Builder(String name)
    {
        this.material= Utils.getMaterial(name);
    }
    @ZenMethod
    public void addRepairItem(IItemStack stack, int amount)
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
    public void setRepresentativeItem(IOreDictEntry oredict)
    {
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                material.setRepresentativeItem(InputHelper.toString(oredict));
            }

            @Override
            public String describe()
            {
                return "Set "+InputHelper.toString(oredict)+" the representative item for "+material.getIdentifier();
            }
        });
    }
    @ZenMethod
    public void setRepresentativeItem(IItemStack stack)
    {
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                material.setRepresentativeItem(InputHelper.toStack(stack));
            }

            @Override
            public String describe()
            {
                return "Set "+stack.getDisplayName()+" the representative item for "+material.getIdentifier();
            }
        });
    }
    @ZenMethod
    public void setCraftable(boolean craftable)
    {
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                material.setCraftable(craftable);
            }

            @Override
            public String describe()
            {
                return craftable ?  material.getIdentifier()+" is now craftable" : material.getIdentifier()+" is no longer craftable";
            }
        });
    }
    @ZenMethod
    public void setCastable(boolean castable)
    {
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                material.setCastable(castable);
            }

            @Override
            public String describe()
            {
                return castable ?  material.getIdentifier()+" is now castable" : material.getIdentifier()+" is no longer castable";
            }
        });
    }
    @ZenMethod
    public ILiquidStack getFluid()
    {
        return InputHelper.toILiquidStack(new FluidStack(material.getFluid(), 1));
    }
    @ZenMethod
    public void setFluid(ILiquidStack stack)
    {
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                material.setFluid(InputHelper.toFluid(stack).getFluid());
            }

            @Override
            public String describe()
            {
                return "Set "+stack.getDisplayName()+" the fluid for "+material.getIdentifier();
            }
        });
    }
}
