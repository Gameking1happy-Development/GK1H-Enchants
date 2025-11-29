package io.github.gameking1happy.gk1henchants.data.client;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1henchants.Main.MOD_ID;

/**
 * Language datagen.
 */
public class MyLanguageProvider extends LanguageProvider {
    /**
     * @param output Pack output.
     */
    public MyLanguageProvider(@NotNull PackOutput output) {
        super(output, MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("gk1henchants.server_config", "GK1H Enchants Config");
        add("gk1henchants.server_config.Tradeable", "Tradeable Enchantments");
        add("gk1henchants.server_config.Tradeable.desc", "Enable wind burst and swift sneak being tradeable by villagers.");
        add("gk1henchants.server_config.Enchantability", "Enchantability Changes");
        add("gk1henchants.server_config.Enchantability.desc", "Changes enchantability of items. Requires Universal Enchants & GK1H Tags.");
    }
}