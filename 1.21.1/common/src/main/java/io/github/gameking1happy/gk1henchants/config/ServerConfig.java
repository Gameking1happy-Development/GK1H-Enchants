package io.github.gameking1happy.gk1henchants.config;

import me.fzzyhmstrs.fzzy_config.annotations.Comment;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedCondition;
import net.minecraft.network.chat.Component;

import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.GK1HTags;
import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.UniEnc;
import static io.github.gameking1happy.gk1henchants.Main.MOD_ID;
import static io.github.gameking1happy.gk1hcore.data.CoreData.fNaP;
import static me.fzzyhmstrs.fzzy_config.annotations.Action.RELOG;

/**
 * The server configuration for the mod.
 */
@SuppressWarnings("CanBeFinal")
@RequiresAction(action = RELOG)
public class ServerConfig extends Config {
    /**
     * Tradeable configuration value.
     */
    @Comment("Enable wind burst and swift sneak being tradeable by villagers.")
    public ValidatedBoolean Tradeable = new ValidatedBoolean(true);
    /**
     * Enchantability configuration value.
     */
    @Comment("Changes enchantability of items. Requires Universal Enchants & GK1H Tags.")
    public ValidatedCondition<Boolean> Enchantability = (new ValidatedBoolean(true)).toCondition(() -> UniEnc, Component.literal("Universal Enchants not loaded."), () -> false).withCondition(() -> GK1HTags, Component.literal("GK1H Tags not loaded."));
    /**
     * The constructor method.
     */
    public ServerConfig() {
        super(fNaP(MOD_ID, "server_config"));
    }
}