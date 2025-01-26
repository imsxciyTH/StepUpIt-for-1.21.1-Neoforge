package moe.imsxciy_kochiya.Key;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_STEPUP = "key.category.stepupit";
    public static final String KEY_SWITCH_STATE = "key.stepupit.switch_state";

    public static final KeyMapping SWITCH_STATE_KEY = new KeyMapping(
            KEY_CATEGORY_STEPUP, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_SEMICOLON,
            KEY_SWITCH_STATE);
}
