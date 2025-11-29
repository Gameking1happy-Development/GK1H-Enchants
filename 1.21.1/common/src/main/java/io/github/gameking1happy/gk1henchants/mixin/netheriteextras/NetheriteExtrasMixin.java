package io.github.gameking1happy.gk1henchants.mixin.netheriteextras;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import xyz.hafemann.netheriteextras.item.ModItems;
import xyz.hafemann.netheriteextras.item.NetheriteHorseArmorItem;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;

/**
 * Give horse armor durability. (Netherite Extras compat.)
 */
@IfModLoaded(value = "netheriteextras")
@Mixin(ModItems.class)
public class NetheriteExtrasMixin {
    @Definition(id = "registerItem", method = "Lxyz/hafemann/netheriteextras/item/ModItems;registerItem(Ljava/lang/String;Lnet/minecraft/world/item/Item;)Lnet/minecraft/world/item/Item;")
    @Definition(id = "NetheriteHorseArmorItem", type = NetheriteHorseArmorItem.class)
    @Expression("registerItem('netherite_horse_armor', @(new NetheriteHorseArmorItem(?)))")
    @ModifyArg(method = "<clinit>", at = @At(value = "MIXINEXTRAS:EXPRESSION"), index = 0)
    private static Item.Properties NetheriteHorseArmor(Item.Properties properties) {
        return properties.durability(ArmorItem.Type.BODY.getDurability(18));
    }
}
