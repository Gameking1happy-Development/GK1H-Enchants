package io.github.gameking1happy.gk1henchants.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/**
 * Give horse armor durability.
 */
@Mixin(Items.class)
abstract class ItemsMixin {
    @Definition(id = "registerItem", method = "Lnet/minecraft/world/item/Items;registerItem(Ljava/lang/String;Lnet/minecraft/world/item/Item;)Lnet/minecraft/world/item/Item;")
    @Definition(id = "AnimalArmorItem", type = AnimalArmorItem.class)
    @Expression("registerItem('leather_horse_armor', @(new AnimalArmorItem(?, ?, ?, ?)))")
    @ModifyArg(method = "<clinit>", at = @At(value = "MIXINEXTRAS:EXPRESSION"), index = 3)
    private static Item.Properties LeatherHorseArmor(Item.Properties properties) {
        return properties.durability(ArmorItem.Type.BODY.getDurability(3));
    }
    @Definition(id = "registerItem", method = "Lnet/minecraft/world/item/Items;registerItem(Ljava/lang/String;Lnet/minecraft/world/item/Item;)Lnet/minecraft/world/item/Item;")
    @Definition(id = "AnimalArmorItem", type = AnimalArmorItem.class)
    @Expression("registerItem('golden_horse_armor', @(new AnimalArmorItem(?, ?, ?, ?)))")
    @ModifyArg(method = "<clinit>", at = @At(value = "MIXINEXTRAS:EXPRESSION"), index = 3)
    private static Item.Properties GoldenHorseArmor(Item.Properties properties) {
        return properties.durability(ArmorItem.Type.BODY.getDurability(5));
    }
    @Definition(id = "registerItem", method = "Lnet/minecraft/world/item/Items;registerItem(Ljava/lang/String;Lnet/minecraft/world/item/Item;)Lnet/minecraft/world/item/Item;")
    @Definition(id = "AnimalArmorItem", type = AnimalArmorItem.class)
    @Expression("registerItem('iron_horse_armor', @(new AnimalArmorItem(?, ?, ?, ?)))")
    @ModifyArg(method = "<clinit>", at = @At(value = "MIXINEXTRAS:EXPRESSION"), index = 3)
    private static Item.Properties IronHorseArmor(Item.Properties properties) {
        return properties.durability(ArmorItem.Type.BODY.getDurability(8));
    }
    @Definition(id = "registerItem", method = "Lnet/minecraft/world/item/Items;registerItem(Ljava/lang/String;Lnet/minecraft/world/item/Item;)Lnet/minecraft/world/item/Item;")
    @Definition(id = "AnimalArmorItem", type = AnimalArmorItem.class)
    @Expression("registerItem('diamond_horse_armor', @(new AnimalArmorItem(?, ?, ?, ?)))")
    @ModifyArg(method = "<clinit>", at = @At(value = "MIXINEXTRAS:EXPRESSION"), index = 3)
    private static Item.Properties DiamondHorseArmor(Item.Properties properties) {
        return properties.durability(ArmorItem.Type.BODY.getDurability(12));
    }
}
