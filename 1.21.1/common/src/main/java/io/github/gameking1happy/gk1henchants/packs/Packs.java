package io.github.gameking1happy.gk1henchants.packs;

import io.github.gameking1happy.gk1hcore.packs.AddPacks;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1hcore.packs.AddPackPreset.addCDP;
import static io.github.gameking1happy.gk1hcore.platform.Services.PLATFORM;
import static io.github.gameking1happy.gk1henchants.Main.*;

/**
 * Class to add packs.
 */
@SuppressWarnings("unused")
public class Packs implements AddPacks {
    /**
     * @param modContainerOrEvent ModContainer for Fabric, AddPackFindersEvent for NeoForge.
     */
    public void addPacks(@NotNull Object modContainerOrEvent) {
        if (Tradeable) {
            addCDP(modContainerOrEvent, getModID(), "tradeable");
        }
        if (Enchantability && PLATFORM.isModLoaded("universalenchants")) {
            addCDP(modContainerOrEvent, getModID(), "enchantability");
            if (PLATFORM.isModLoaded("netherited")) {
                addCDP(modContainerOrEvent, getModID(), "netherited");
            }
        }
    }
    /**
     * @return Returns the mod ID.
     */
    @Override
    public @NotNull String getModID() {
        return MOD_ID;
    }
}
