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

import java.util.ArrayList;

@ZenClass("mods.tinkersoddities")
@ZenRegister
public class Oddities
{
    @ZenMethod
    public static Builder getMaterial(String material)
    {
        return new Builder(material);
    }
    @ZenClass("mods.tinkersoddities.builder")
    public static class Builder
    {
        private Material material;
        private ArrayList<IAction> actions = new ArrayList<>();

        public Builder(String name)
        {
            this.material= Utils.getMaterial(name);
        }
        @ZenMethod
        public Builder addRepairItem(IItemStack stack, int amount)
        {
            this.actions.add(new IAction()
            {
                @Override
                public void apply()
                {
                    Utils.addRepairMaterial(material, InputHelper.toStack(stack), amount);
                }

                @Override
                public String describe()
                {
                    return "Added "+stack.getDisplayName()+" to "+material.getIdentifier();
                }
            });
            return this;
        }

        @ZenMethod
        public Builder setRepresentativeItem(IOreDictEntry oredict)
        {
            this.actions.add(new IAction()
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
            return this;
        }
        @ZenMethod
        public Builder setRepresentativeItem(IItemStack stack)
        {
            this.actions.add(new IAction()
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
            return this;
        }
        @ZenMethod
        public Builder setCraftable(boolean craftable)
        {
            this.actions.add(new IAction()
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
            return this;
        }
        @ZenMethod
        public Builder setCastable(boolean castable)
        {
            this.actions.add(new IAction()
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
            return this;
        }
        @ZenMethod
        public Builder setFluid(ILiquidStack stack)
        {
            this.actions.add(new IAction()
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
            return this;
        }
        @ZenMethod
        public void build()
        {
            for(IAction action: actions)
            {
                CraftTweakerAPI.apply(action);
            }
        }
    }

}
