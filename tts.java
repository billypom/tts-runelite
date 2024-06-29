package net.runelite.client.plugins.tts;

import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.api.Client;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.config.ConfigManager;

import javax.inject.Inject;

@PluginDescriptor(
		name="tts",
		description="its talking",
		tags = {"tts", "text", "speech"}
)
public class tts extends Plugin {
	@Inject
	private ttsconfig config;

	@Provides
	ttsconfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ttsconfig.class);
	}

	@Override
	protected void startUp() throws Exception {
		System.out.println("TTS Plugin started");
	}

	@Override
	protected void shutDown() throws Exception {
		System.out.println("TTS Plugin stopped");
	}

	@Subscribe
	public void onChatMessage(ChatMessage event) {
		ChatMessageType type = event.getType();
		if (type == ChatMessageType.PUBLICCHAT && config.EnablePublic()) {
			System.out.println(event.getMessage());
		}
		if (type == ChatMessageType.FRIENDSCHAT && config.EnablePrivate()) {
			System.out.println(event.getMessage());
		}
		if (type == ChatMessageType.CONSOLE && config.EnableConsole()) {
			System.out.println(event.getMessage());
		}
		if (type == ChatMessageType.ITEM_EXAMINE || type == ChatMessageType.NPC_EXAMINE || type == ChatMessageType.OBJECT_EXAMINE && config.EnableExamine()) {
			System.out.println(event.getMessage());
		}


	}

}
