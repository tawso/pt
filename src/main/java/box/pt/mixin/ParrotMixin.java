package box.pt.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static box.pt.PtSound.SoundRegister.TROLL_SOUNDS;

@Mixin(ParrotEntity.class)
public abstract class ParrotMixin {

    /**
     * @author tawso
     * @reason Заставляет попугаев издавать кастомный звук.
     */
    @Inject(
            method = "imitateNearbyMob(Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void forceCustomTrollSound(World world, Entity entity, CallbackInfoReturnable<Boolean> cir) {


        if (TROLL_SOUNDS.isEmpty()) return;
        Random random = world.random;

        int randomIndex = random.nextInt(TROLL_SOUNDS.size());
        SoundEvent soundToPlay = TROLL_SOUNDS.get(randomIndex);

        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                soundToPlay,
                entity.getSoundCategory(), 1.0F, 1.0F);

        cir.setReturnValue(true);
    }
}
