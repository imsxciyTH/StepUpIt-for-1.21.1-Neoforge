package moe.imsxciy_kochiya;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(StepUpIt.MODID)
public class StepUpIt
{
    public static final String MODID = "stepupit";

    public StepUpIt(IEventBus modEventBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
    }
}
