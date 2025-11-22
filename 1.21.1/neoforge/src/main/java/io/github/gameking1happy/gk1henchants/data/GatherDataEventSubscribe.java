package io.github.gameking1happy.gk1henchants.data;

import io.github.gameking1happy.gk1henchants.data.client.MyLanguageProvider;
import io.github.gameking1happy.gk1henchants.data.enchantability.EnchantabilityEnchantmentTagsProvider;
import io.github.gameking1happy.gk1henchants.data.enchantability.EnchantabilityItemTagsProvider;
import io.github.gameking1happy.gk1henchants.data.enchantability.netherited.enderzoology.NetheritedItemTagsProvider;
import io.github.gameking1happy.gk1henchants.data.tradeable.TradeableEnchantmentTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1henchants.Main.MOD_ID;

/**
 * GatherDataEventSubscribe class for datagen.
 */
@EventBusSubscriber(modid = MOD_ID)
public class GatherDataEventSubscribe {
    /**
     * @param event GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        PackOutput TradeableOutput = generator.getPackOutput("tradeable");
        PackOutput EnchantabilityOutput = generator.getPackOutput("enchantability");
        PackOutput NetheritedOutput = generator.getPackOutput("netherited");
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagsProvider blockTagsProvider = new MyBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeClient(), new MyLanguageProvider(output));
        generator.addProvider(event.includeServer(), new TradeableEnchantmentTagsProvider(TradeableOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new EnchantabilityItemTagsProvider(EnchantabilityOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new EnchantabilityEnchantmentTagsProvider(EnchantabilityOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new NetheritedItemTagsProvider(NetheritedOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
    }
}