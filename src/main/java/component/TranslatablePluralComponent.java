package com.minersstudios.gnuplusadventure.component;

/**
 * TranslatableComponent with plural form of the message and the quantity of
 * the item described in the message.
 */
public interface TranslatablePluralComponent extends net.kyori.adventure.text.TranslatableComponent {
	/**
	 * Gets the plural form of the message.
	 *
	 * @return the plural form of the message
	 */
	public @lombok.NonNull String plural_key();
	/**
	 * Sets the plural form of the message.
	 *
	 * @param plural_key the plural form of the message to set
	 */
	public void plural_key(final @lombok.NonNull String plural_key);
	/**
	 * Gets the quantity of the item described in the message.
	 *
	 * @return the quantity of the item
	 */
	public long n();
	/**
	 * Sets the quantity of the item described in the message.
	 *
	 * @param n the quantity of the item to set
	 */
	public void n(final long n);
}
