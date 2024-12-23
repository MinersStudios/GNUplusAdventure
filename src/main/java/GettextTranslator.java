package com.minersstudios.gnuplusadventure;
import gnu.gettext.GettextResource;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import lombok.NonNull;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslationArgument;
import com.minersstudios.gnuplusadventure.component.*;

/**
 * Gettext wrapped as Translator.
 */
@lombok.ToString @lombok.EqualsAndHashCode
public final class GettextTranslator implements net.kyori.adventure.translation.Translator {
	private ResourceBundle resources;
	private void setResources(final @NonNull Locale locale) {
		resources = java.util.Objects.requireNonNull(ResourceBundle.getBundle(locale.toString()), MessageFormat.format("No resource bundle for locale {0} was found.", locale));
	}
	private @NonNull Object[] getComponentArguments(final @NonNull net.kyori.adventure.text.TranslatableComponent component) {
		return component.arguments().stream().map(TranslationArgument::value).toArray();
	}
	/**
	 * The constructor.
	 */
	public GettextTranslator() {}
	@Override public @NonNull Key name() { return Key.key("gettext", "translations"); }
	/**
	 * gettext wrapper.
	 *
	 * @param msgid the message id, English version of the message
	 * @param locale the locale of translation to be returned
	 * @return the MessageFormat object with pattern set to the translated
	 * string
	 */
	@Override public @NonNull MessageFormat translate(final @NonNull String msgid, final @NonNull Locale locale) {
		setResources(locale);
		return new MessageFormat(GettextResource.gettext(resources, msgid));
	}
	/**
	 * ngettext wrapper.
	 *
	 * @param msgid the message id, English version of the message
	 * @param msgid_plural the plural form of the message
	 * @param n the number of objects
	 * @param locale the locale of translation to be returned
	 * @return the MessageFormat object with pattern set to the translated
	 * string in nonplural form if n is 1, in plural otherwise
	 */
	public @NonNull MessageFormat translate(final @NonNull String msgid, final @NonNull String msgid_plural, final long n, final @NonNull Locale locale) {
		setResources(locale);
		return new MessageFormat(GettextResource.ngettext(resources, msgid, msgid_plural, n));
	}
	/**
	 * pgettext wrapper.
	 *
	 * @param msgctxt the message context
	 * @param msgid the message id, English version of the message
	 * @param locale the locale of translation to be returned
	 * @return the MessageFormat object with pattern set to the translated
	 * string in specific context
	 */
	public @NonNull MessageFormat translate(final @NonNull String msgctxt, final @NonNull String msgid, final @NonNull Locale locale) {
		setResources(locale);
		return new MessageFormat(GettextResource.pgettext(resources, msgctxt, msgid));
	}
	/**
	 * npgettext wrapper.
	 *
	 * @param msgctxt the message context
	 * @param msgid the message id, English version of the message
	 * @param msgid_plural the plural form of the message
	 * @param n the number of objects
	 * @param locale the locale of translation to be returned
	 * @return {@link #translate(java.util.String,java.util.String,long,java.util.Locale)}
	 * and {@link #translate(java.util.String,java.util.String,java.util.Locale)}
	 */
	public @NonNull MessageFormat translate(final @NonNull String msgctxt, final @NonNull String msgid, final @NonNull String msgid_plural, final long n, final @NonNull Locale locale) {
		setResources(locale);
		return new MessageFormat(GettextResource.npgettext(resources, msgctxt, msgid, msgid_plural, n));
	}
	/**
	 * gettext wrapper.
	 *
	 * @param component the component with the message to be translated and
	 * its arguments included
	 * @param locale the locale of translation to be returned
	 * @return same as {@link #translate(java.util.String,java.util.Locale)},
	 * except wrapped as Component
	 */
	@Override public @NonNull Component translate(final @NonNull net.kyori.adventure.text.TranslatableComponent component, final @NonNull Locale locale) {
		setResources(locale);
		return Component.text(MessageFormat.format(GettextResource.gettext(resources, component.key()), getComponentArguments(component)));
	}
	/**
	 * ngettext wrapper.
	 *
	 * @param component the plural component with the message to be translated
	 * and its arguments included
	 * @param locale the locale of translation to be returned
	 * @return same as {@link #translate(java.util.String,java.util.String,long,java.util.Locale)},
	 * except wrapped as Component
	 */
	public @NonNull Component translate(final @NonNull TranslatablePluralComponent component, final @NonNull Locale locale) {
		setResources(locale);
		return Component.text(MessageFormat.format(GettextResource.ngettext(resources, component.key(), component.plural_key(), component.n()), getComponentArguments(component)));
	}
	/**
	 * pgettext wrapper.
	 *
	 * @param component the contextual component with the message to be
	 * translated and its arguments included
	 * @param locale the locale of translation to be returned
	 * @return same as {@link #translate(java.util.String,java.util.String,java.util.Locale)},
	 * except wrapped as Component
	 */
	public @NonNull Component translate(final @NonNull TranslatableContextualComponent component, final @NonNull Locale locale) {
		setResources(locale);
		return Component.text(MessageFormat.format(GettextResource.pgettext(resources, component.context(), component.key()), getComponentArguments(component)));
	}
	/**
	 * npgettext wrapper.
	 *
	 * @param component the contextual plural component with the message to be
	 * translated and its arguments included
	 * @param locale the locale of translation to be returned
	 * @return same as {@link #translate(java.util.String,java.util.String,java.util.String,long,java.util.Locale)},
	 * except wrapped as Component
	 */
	public @NonNull Component translate(final @NonNull TranslatableContextualPluralComponent component, final @NonNull Locale locale) {
		setResources(locale);
		return Component.text(MessageFormat.format(GettextResource.npgettext(resources, component.context(), component.key(), component.plural_key(), component.n()), getComponentArguments(component)));
	}
}
