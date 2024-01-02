package ua.com.minersstudios.gnuplusadventure.component;

/**
 * TranslatableComponent with context.
 */
public interface TranslatableContextualComponent extends net.kyori.adventure.text.TranslatableComponent {
	/**
	 * Gets the context of the message.
	 *
	 * @return the context of the message
	 */
	public @lombok.NonNull String context();
	/**
	 * Sets the context of the message.
	 *
	 * @param context the context of the message to set
	 */
	public void context(final @lombok.NonNull String context);
}
