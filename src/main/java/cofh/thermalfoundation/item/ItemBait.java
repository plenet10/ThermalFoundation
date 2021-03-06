package cofh.thermalfoundation.item;

import cofh.core.item.ItemMulti;
import cofh.core.util.core.IInitializer;
import cofh.lib.util.helpers.ItemHelper;
import cofh.thermalfoundation.ThermalFoundation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static cofh.lib.util.helpers.ItemHelper.ShapelessRecipe;
import static cofh.lib.util.helpers.ItemHelper.addRecipe;

public class ItemBait extends ItemMulti implements IInitializer {

	public ItemBait() {

		super("thermalfoundation");

		setUnlocalizedName("bait");
		setCreativeTab(ThermalFoundation.tabCommon);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		//		ItemStack stack = player.getHeldItem(hand);
		//		if (!player.canPlayerEdit(pos.offset(facing), facing, stack)) {
		//			return EnumActionResult.PASS;
		//		}
		//		int radius = 1 + ItemHelper.getItemDamage(stack);
		//		int potency = 2 + ItemHelper.getItemDamage(stack);
		//
		//		if (onApplyBonemeal(stack, world, pos, player, radius, potency)) {
		//			return EnumActionResult.SUCCESS;
		//		}
		return EnumActionResult.PASS;
	}

	/* IInitializer */
	@Override
	public boolean preInit() {

		baitBasic = addItem(0, "baitBasic");
		baitRich = addItem(1, "baitRich");
		baitFlux = addItem(2, "baitFlux");

		ThermalFoundation.proxy.addIModelRegister(this);

		return true;
	}

	@Override
	public boolean initialize() {

		addRecipe(ShapelessRecipe(ItemHelper.cloneStack(baitBasic, 2), "dustWood", "dustWood", "dustSaltpeter", "crystalSlag"));

		addRecipe(ShapelessRecipe(baitRich, baitBasic, new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage())));

		return true;
	}

	@Override
	public boolean postInit() {

		return true;
	}

	/* REFERENCES */
	public static ItemStack baitBasic;
	public static ItemStack baitRich;
	public static ItemStack baitFlux;

}
