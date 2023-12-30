package ua.com.minersstudios.gnuplusadventure.component;

public interface TranslatableContextualComponent extends net.kyori.adventure.text.TranslatableComponent {
	public @lombok.NonNull String context();
	public void context(final @lombok.NonNull String context);
}
