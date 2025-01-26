package moe.imsxciy_kochiya.Key;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import static moe.imsxciy_kochiya.StepUpIt.MODID;
import static moe.imsxciy_kochiya.Worker.SwitchState;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class KeyHandler {
    @SubscribeEvent
    public static void onKeyInput(ClientTickEvent.Post event){
        while (KeyBinding.SWITCH_STATE_KEY.consumeClick()) {
            SwitchState();
        }
    }
}
