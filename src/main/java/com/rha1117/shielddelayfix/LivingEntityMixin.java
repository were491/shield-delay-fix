package com.rha1117.shielddelayfix;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.entity.LivingEntity;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@ModifyConstant(method = "isBlocking()Z", constant = @Constant(intValue = 5))
	private int injectedShieldDelay(int value) {
		// 0 -> you started blocking on the same tick that it checked.
		// It will still deal damage if you aren't blocking because of an earlier if statement.
		return 0;
	}
}
