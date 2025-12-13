package io.github.gameking1happy.gk1henchants.data.enchantability;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1hcore.data.CoreData.*;
import static io.github.gameking1happy.gk1henchants.Main.MOD_ID;
import static io.github.gameking1happy.gk1htags.registry.ItemTag.*;
import static fuzs.universalenchants.init.ModRegistry.*;

/**
 * Enchantability item tags datagen.
 */
public class EnchantabilityItemTagsProvider extends ItemTagsProvider {
    /**
     * @param output Pack output.
     * @param lookupProvider Lookup provider.
     * @param blockTagsProvider Block tags provider.
     * @param existingFileHelper Existing file helper.
     */
    public EnchantabilityItemTagsProvider(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider, @NotNull CompletableFuture<TagLookup<Block>> blockTagsProvider, @NotNull ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTagsProvider, MOD_ID, existingFileHelper);
    }
    @Override
    public @NotNull String getName() {
        return super.getName() + "-Enchantability";
    }
    @Override
    protected void addTags(HolderLookup.@NotNull Provider lookupProvider) {
        tag(ItemTags.VANISHING_ENCHANTABLE).addTags(ItemTags.EQUIPPABLE_ENCHANTABLE, ItemTags.MINING_ENCHANTABLE, ItemTags.WEAPON_ENCHANTABLE, ItemTags.FISHING_ENCHANTABLE, ItemTags.FIRE_ASPECT_ENCHANTABLE, Tags.Items.RANGED_WEAPON_TOOLS).addOptionalTags(NET_FIREPROOF, MISC_ENCHANTABLES);
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(Items.SADDLE, Items.CHEST).addTag(ItemTags.ARMOR_ENCHANTABLE).addOptionalTag(ACCESSORIES);
        tag(ItemTags.DURABILITY_ENCHANTABLE).addOptionalTag(ANIMAL_ARMOR);
        tag(ItemTags.ARMOR_ENCHANTABLE).addTag(Tags.Items.ARMORS);
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).addOptionalTag(ANIMAL_ARMOR);
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).addOptional(fnap("mutantmonsters", "endersoul_hand")).addOptional(fnap("mutantmonsters", "creeper_shard"));
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).addOptional(fnap("mutantmonsters", "endersoul_hand")).addOptional(fnap("mutantmonsters", "creeper_shard")).addOptional(fnap("illagerinvasion", "platinum_infused_hatchet"));
        tag(Tags.Items.RANGED_WEAPON_TOOLS).addOptional(fnap("illagerinvasion", "platinum_infused_hatchet")).addOptional(fnap("enderzoology","hunting_bow"));
        tag(itkc("c", "tools/ranged_weapons")).addOptional(fnap("illagerinvasion", "platinum_infused_hatchet")).addOptional(fnap("enderzoology","hunting_bow"));
        tag(ItemTags.BOW_ENCHANTABLE).addTag(ItemTags.CROSSBOW_ENCHANTABLE);
        tag(getSecondaryEnchantableItemTag(ResourceKey.create(Registries.ENCHANTMENT,fnap("minecraft","respiration")))).addOptionalTag(ANIMAL_ARMOR);
        tag(getSecondaryEnchantableItemTag(ResourceKey.create(Registries.ENCHANTMENT,fnap("minecraft","breach")))).addOptional(fnap("mutantmonsters", "endersoul_hand")).addOptional(fnap("mutantmonsters", "creeper_shard")).addOptional(fnap("mutantmonsters", "hulk_hammer")).addOptional(fnap("illagerinvasion", "platinum_infused_hatchet")).addOptionalTag(ENCHANTABLE_SPIKY_SPIKES);
        tag(getSecondaryEnchantableItemTag(ResourceKey.create(Registries.ENCHANTMENT,fnap("minecraft","impaling")))).addOptional(fnap("mutantmonsters", "endersoul_hand")).addOptional(fnap("mutantmonsters", "creeper_shard")).addOptional(fnap("mutantmonsters", "hulk_hammer")).addOptional(fnap("illagerinvasion", "platinum_infused_hatchet")).addOptionalTag(ENCHANTABLE_SPIKY_SPIKES);
        tag(getSecondaryEnchantableItemTag(ResourceKey.create(Registries.ENCHANTMENT,fnap("minecraft","looting")))).addOptional(fnap("mutantmonsters", "endersoul_hand")).addOptional(fnap("mutantmonsters", "creeper_shard")).addOptional(fnap("mutantmonsters", "hulk_hammer")).addOptional(fnap("illagerinvasion", "platinum_infused_hatchet")).addOptional(fnap("enderzoology","hunting_bow"));
        tag(getSecondaryEnchantableItemTag(ResourceKey.create(Registries.ENCHANTMENT,fnap("minecraft","piercing")))).addOptional(fnap("illagerinvasion", "platinum_infused_hatchet"));
        tag(getSecondaryEnchantableItemTag(ResourceKey.create(Registries.ENCHANTMENT,fnap("minecraft","quick_charge")))).addOptional(fnap("illagerinvasion", "platinum_infused_hatchet"));
    }
}