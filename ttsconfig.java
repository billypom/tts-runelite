package net.runelite.client.plugins.tts;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("tts")
public interface ttsconfig extends Config {
    @ConfigItem(
            position=1,
            keyName="public",
            name="Public Chat",
            description="Enable TTS for public chat"
    )
    default boolean EnablePublic()
    {
        return true;
    }

    @ConfigItem(
            position=2,
            keyName="console",
            name="Console",
            description="Enable TTS for system messages"
    )
    default boolean EnableConsole()
    {
        return false;
    }

    @ConfigItem(
            position=3,
            keyName="friends",
            name="Friends Chat",
            description="Enable TTS for PMs (friends chat)"
    )
    default boolean EnablePrivate()
    {
        return false;
    }

    @ConfigItem(
            position=4,
            keyName="example",
            name="Examine",
            description="Enable TTS for Examine"
    )
    default boolean EnableExamine()
    {
        return true;
    }
}
