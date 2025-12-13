package io.github.gameking1happy.gk1henchants.data;

import io.github.gameking1happy.gk1henchants.data.client.MyLanguageProvider;
import io.github.gameking1happy.gk1henchants.data.enchantability.EnchantabilityItemTagsProvider;
import io.github.gameking1happy.gk1henchants.data.enchantability.netherited.NetheritedItemTagsProvider;
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
        PackOutput tradeableOutput = generator.getPackOutput("tradeable");
        PackOutput enchantabilityOutput = generator.getPackOutput("enchantability");
        PackOutput netheritedOutput = generator.getPackOutput("netherited");
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagsProvider blockTagsProvider = new MyBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeClient(), new MyLanguageProvider(output));
        generator.addProvider(event.includeServer(), new TradeableEnchantmentTagsProvider(tradeableOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new EnchantabilityItemTagsProvider(enchantabilityOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new NetheritedItemTagsProvider(netheritedOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
    }
}