package moe.imsxciy_kochiya;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue JUMP_STATE = BUILDER
            .comment("Choose whether to enable the stepup and autojump." +
                    "\nYou can also switch it by KeyBinding in game." +
                    "\n 0:Close autojump and stepup" +
                    "\n 1:Enable autojump" +
                    "\n 2:Enable stepup")
            .defineInRange("autoJumpState", 2, 0, 2);

    static final ModConfigSpec SPEC = BUILDER.build();
}
