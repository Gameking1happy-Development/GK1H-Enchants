package io.github.gameking1happy.gk1henchants.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Makes horse armor actually take damage.
 */
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    /**
     * @param damageSource Damage source.
     * @param damageAmount Damage amount.
     * @param ci Callback info.
     */
    @Inject(
            method = "hurtArmor",
            at = @At("HEAD")
    )
    protected void hurtArmorInject(DamageSource damageSource, float damageAmount, CallbackInfo ci) {
        if ((Object) this instanceof AbstractHorse) {
            doHurtEquipment(damageSource, damageAmount, EquipmentSlot.BODY);
        }
    }
    @Shadow
    protected abstract void doHurtEquipment(DamageSource damageSource, float damageAmount, EquipmentSlot... slots);
}
