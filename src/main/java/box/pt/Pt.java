package box.pt;

import box.pt.PtSound.SoundRegister;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pt implements ModInitializer {

    public static final String MOD_ID = "pt";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        SoundRegister.registerSounds();
    }
}
