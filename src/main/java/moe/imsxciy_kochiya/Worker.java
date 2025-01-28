package moe.imsxciy_kochiya;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import static moe.imsxciy_kochiya.Config.JUMP_STATE;
import static moe.imsxciy_kochiya.StepUpIt.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class Worker {
    public static int jumpState;

    @SubscribeEvent
    public static void StepitUp(PlayerTickEvent.Post event){
        if(Minecraft.getInstance().player == null){return;}
        Boolean autojumpState = Minecraft.getInstance().player.isAutoJumpEnabled();

        Player player = event.getEntity();
        if(player.isCrouching()){
            player.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6);
        }else if(autojumpState){
            player.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6);
        }else if(!autojumpState && jumpState == 2){
            player.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(1.25);
        }else if(!autojumpState && jumpState == 0){
            player.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6);
        }
    }

    public static void SwitchState(){
        switch (jumpState){
            case 0:
                JUMP_STATE.set(1);
                JUMP_STATE.save();
                Minecraft.getInstance().player.sendSystemMessage(Component.translatable("message.stepupit.autojumpenable"));
                Minecraft.getInstance().options.autoJump().set(true);
                break;
            case 1:
                JUMP_STATE.set(2);
                JUMP_STATE.save();
                Minecraft.getInstance().player.sendSystemMessage(Component.translatable("message.stepupit.stepupitenable"));
                Minecraft.getInstance().options.autoJump().set(false);
                break;
            case 2:
                JUMP_STATE.set(0);
                JUMP_STATE.save();
                Minecraft.getInstance().player.sendSystemMessage(Component.translatable("message.stepupit.off"));
                Minecraft.getInstance().options.autoJump().set(false);
                break;
        }
        jumpState = JUMP_STATE.get();
    }

    @SubscribeEvent
    public static void LoginMessage(ClientPlayerNetworkEvent.LoggingIn event){
        Player player = event.getPlayer();
        jumpState = JUMP_STATE.get();
        switch (jumpState){
            case 0:
                player.sendSystemMessage(Component.translatable("message.stepupit.off"));
                Minecraft.getInstance().options.autoJump().set(false);
                break;
            case 1:
                player.sendSystemMessage(Component.translatable("message.stepupit.autojumpenable"));
                Minecraft.getInstance().options.autoJump().set(true);
                break;
            case 2:
                player.sendSystemMessage(Component.translatable("message.stepupit.stepupitenable"));
                Minecraft.getInstance().options.autoJump().set(false);
                break;
        }
    }
}
