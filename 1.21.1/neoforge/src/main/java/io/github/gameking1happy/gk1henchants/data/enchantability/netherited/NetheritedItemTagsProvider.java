package io.github.gameking1happy.gk1henchants.data.enchantability.netherited;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1henchants.Main.MOD_ID;
import static io.github.gameking1happy.gk1htags.registry.ItemTag.*;

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
        tag(NetFireproof).addTags(ItemTags.EQUIPPABLE_ENCHANTABLE, ItemTags.MINING_ENCHANTABLE, ItemTags.WEAPON_ENCHANTABLE, ItemTags.FISHING_ENCHANTABLE, ItemTags.FIRE_ASPECT_ENCHANTABLE, Tags.Items.RANGED_WEAPON_TOOLS).addOptionalTag(MiscEnchantables);
    }
}