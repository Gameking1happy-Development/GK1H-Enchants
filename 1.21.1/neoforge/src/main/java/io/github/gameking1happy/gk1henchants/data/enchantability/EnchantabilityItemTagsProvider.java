package io.github.gameking1happy.gk1henchants.data.enchantability;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1hcore.Main.fNAP;
import static io.github.gameking1happy.gk1henchants.Main.MOD_ID;

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
        tag(Tags.Items.SHULKER_BOXES)
                .addOptionalTags(TagKey.create(Registries.ITEM, fNAP("reinfshulker","copper_shulker_boxes")), TagKey.create(Registries.ITEM, fNAP("reinfshulker","iron_shulker_boxes")), TagKey.create(Registries.ITEM, fNAP("reinfshulker","gold_shulker_boxes")), TagKey.create(Registries.ITEM, fNAP("reinfshulker","diamond_shulker_boxes")), TagKey.create(Registries.ITEM, fNAP("reinfshulker","netherite_shulker_boxes")));
        tag(Tags.Items.ENCHANTABLES)
                .addTags(Tags.Items.SHULKER_BOXES)
                .addOptionalTags(TagKey.create(Registries.ITEM, fNAP("moblassos","lassos")));
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .addOptionalTags(TagKey.create(Registries.ITEM, fNAP("travelersbackpack","custom_travelers_backpack")));
        tag(ItemTags.VANISHING_ENCHANTABLE)
                .add(Items.DIAMOND_HORSE_ARMOR, Items.LEATHER_HORSE_ARMOR, Items.IRON_HORSE_ARMOR, Items.GOLDEN_HORSE_ARMOR, Items.WOLF_ARMOR, Items.TOTEM_OF_UNDYING, Items.SPYGLASS, Items.CLOCK, Items.ENDER_CHEST, Items.SOUL_LANTERN, Items.LANTERN)
                .addTags(ItemTags.ARROWS, ItemTags.COMPASSES, Tags.Items.SHULKER_BOXES)
                .addOptional(fNAP("netheriteextras","totem_of_neverdying"))
                .addOptional(fNAP("netheriteextras","netherite_horse_armor"))
                .addOptional(fNAP("netheriteextras","netherite_wolf_armor"))
                .addOptional(fNAP("horseexpert","monocle"))
                .addOptional(fNAP("spikyspikes","diamond_spike"))
                .addOptional(fNAP("spikyspikes","netherite_spike"))
                .addOptionalTags(TagKey.create(Registries.ITEM, fNAP("moblassos","lassos")), TagKey.create(Registries.ITEM, fNAP("travelersbackpack","custom_travelers_backpack")));
    }
}