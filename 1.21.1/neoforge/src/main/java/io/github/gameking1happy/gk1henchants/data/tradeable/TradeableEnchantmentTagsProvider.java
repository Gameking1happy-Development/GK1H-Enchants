package io.github.gameking1happy.gk1henchants.data.tradeable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1henchants.Main.MOD_ID;

/**
 * Tradeable enchantment tags datagen.
 */
public class TradeableEnchantmentTagsProvider extends EnchantmentTagsProvider {
    /**
     * @param output Pack output.
     * @param lookupProvider Lookup provider.
     * @param existingFileHelper Existing file helper.
     */
    public TradeableEnchantmentTagsProvider(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider, @NotNull ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }
    @Override
    public @NotNull String getName() {
        return super.getName() + "-Tradeable";
    }
    @Override
    protected void addTags(HolderLookup.@NotNull Provider lookupProvider) {
        tag(EnchantmentTags.TRADEABLE)
                .add(Enchantments.WIND_BURST, Enchantments.SWIFT_SNEAK);
    }
}