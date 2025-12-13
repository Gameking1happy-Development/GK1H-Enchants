package io.github.gameking1happy.gk1henchants.packs;

import io.github.gameking1happy.gk1hcore.packs.AddPacks;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1hcore.packs.AddPackPreset.addCdp;
import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.*;
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
        if (tradeable) {
            addCdp(modContainerOrEvent, getModID(), "tradeable");
        }
        if (enchantability) {
            addCdp(modContainerOrEvent, getModID(), "enchantability");
            if (NETED) {
                addCdp(modContainerOrEvent, getModID(), "netherited");
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
