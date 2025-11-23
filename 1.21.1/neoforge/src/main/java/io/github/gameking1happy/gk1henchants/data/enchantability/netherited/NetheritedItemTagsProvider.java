package io.github.gameking1happy.gk1henchants.data.enchantability.netherited;

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
 * Netherited item tags datagen.
 */
public class NetheritedItemTagsProvider extends ItemTagsProvider {
    /**
     * @param output Pack output.
     * @param lookupProvider Lookup provider.
     * @param blockTagsProvider Block tags provider.
     * @param existingFileHelper Existing file helper.
     */
    public NetheritedItemTagsProvider(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider, @NotNull CompletableFuture<TagLookup<Block>> blockTagsProvider, @NotNull ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTagsProvider, MOD_ID, existingFileHelper);
    }
    @Override
    public @NotNull String getName() {
        return super.getName() + "-Netherited";
    }
    @Override
    protected void addTags(HolderLookup.@NotNull Provider lookupProvider) {
        tag(TagKey.create(Registries.ITEM,fNAP("netherited","enchantable/fireproof")))
                .addTag(Tags.Items.ENCHANTABLES)
                .add(Items.DIAMOND_HORSE_ARMOR, Items.LEATHER_HORSE_ARMOR, Items.IRON_HORSE_ARMOR, Items.GOLDEN_HORSE_ARMOR, Items.WOLF_ARMOR, Items.TOTEM_OF_UNDYING, Items.SPYGLASS, Items.CLOCK, Items.ENDER_CHEST, Items.SOUL_LANTERN, Items.LANTERN, Items.CARVED_PUMPKIN)
                .addTags(ItemTags.ARROWS, ItemTags.COMPASSES, Tags.Items.SHULKER_BOXES, ItemTags.SKULLS)
                .addOptional(fNAP("netheriteextras","totem_of_neverdying"))
                .addOptional(fNAP("netheriteextras","netherite_horse_armor"))
                .addOptional(fNAP("netheriteextras","netherite_wolf_armor"))
                .addOptional(fNAP("linkedchests","linked_pouch"))
                .addOptional(fNAP("horseexpert","monocle"))
                .addOptional(fNAP("spikyspikes","diamond_spike"))
                .addOptional(fNAP("spikyspikes","netherite_spike"))
                .addOptionalTags(TagKey.create(Registries.ITEM, fNAP("bagofholding","bags")));
    }
}