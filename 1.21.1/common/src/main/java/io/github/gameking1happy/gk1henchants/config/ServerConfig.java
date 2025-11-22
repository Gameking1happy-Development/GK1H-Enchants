package io.github.gameking1happy.gk1henchants.config;

import me.fzzyhmstrs.fzzy_config.annotations.Comment;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;

import static io.github.gameking1happy.gk1henchants.Main.MOD_ID;
import static io.github.gameking1happy.gk1hcore.Main.fNAP;
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
    @Comment("Changes enchantability of items, requires Universal Enchants.")
    public ValidatedBoolean Enchantability = new ValidatedBoolean(true);
    /**
     * The constructor method.
     */
    public ServerConfig() {
        super(fNAP(MOD_ID, "server_config"));
    }
}