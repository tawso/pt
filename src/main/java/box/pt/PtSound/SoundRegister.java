package box.pt.PtSound;

import box.pt.Pt;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class SoundRegister {

    public static final List<SoundEvent> TROLL_SOUNDS = new ArrayList<>();
    private static final int size = 3;

    public static void registerSounds() {
        for (int i = 1; i <= size; i++) {
            Identifier id = Identifier.of(Pt.MOD_ID, "troll_" + i);
            SoundEvent event = SoundEvent.of(id);

            Registry.register(Registries.SOUND_EVENT, id, event);

            TROLL_SOUNDS.add(event);
        }
    }

}
