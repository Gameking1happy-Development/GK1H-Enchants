package io.github.gameking1happy.gk1henchants.data.enchantability;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1henchants.Main.MOD_ID;

/**
 * Enchantability enchantment tags datagen.
 */
public class EnchantabilityEnchantmentTagsProvider extends EnchantmentTagsProvider {
    /**
     * @param output Pack output.
     * @param lookupProvider Lookup provider.
     * @param existingFileHelper Existing file helper.
     */
    public EnchantabilityEnchantmentTagsProvider(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider, @NotNull ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }
    @Override
    public @NotNull String getName() {
        return super.getName() + "-Enchantability";
    }
    @Override
    protected void addTags(HolderLookup.@NotNull Provider lookupProvider) {
    }
}