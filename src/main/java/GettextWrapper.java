package ua.com.minersstudios.gnuplusadventure;
import gnu.gettext.GettextResource;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import lombok.NonNull;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslationArgument;
import ua.com.minersstudios.gnuplusadventure.component.*;

@lombok.ToString @lombok.EqualsAndHashCode
public final class GettextWrapper implements net.kyori.adventure.translation.Translator {
	private ResourceBundle resources;
	@Override public @NonNull Key name() { return Key.key("gettext", "translations"); }
	private void setResources(final @NonNull Locale locale) {
		resources = java.util.Objects.requireNonNull(ResourceBundle.getBundle(locale.toString()), MessageFormat.format("No resource bundle for locale {0} was found.", locale));
	}
	private @NonNull Object[] getComponentArguments(final @NonNull net.kyori.adventure.text.TranslatableComponent component) {
		return component.arguments().stream().map(TranslationArgument::value).toArray();
	}
	@Override public @NonNull MessageFormat translate(final @NonNull String msgid, final @NonNull Locale locale) {
		setResources(locale);
		return new MessageFormat(GettextResource.gettext(resources, msgid));
	}
	@Override public @NonNull Component translate(final @NonNull net.kyori.adventure.text.TranslatableComponent component, final @NonNull Locale locale) {
		setResources(locale);
		return Component.text(MessageFormat.format(GettextResource.gettext(resources, component.key()), getComponentArguments(component)));
	}
	public @NonNull MessageFormat ngettext(final @NonNull String msgid, final @NonNull String msgid_plural, final long n, final @NonNull Locale locale) {
		setResources(locale);
		return new MessageFormat(GettextResource.ngettext(resources, msgid, msgid_plural, n));
	}
	public @NonNull Component ngettext(final @NonNull TranslatablePluralComponent component, final @NonNull Locale locale) {
		setResources(locale);
		return Component.text(MessageFormat.format(GettextResource.ngettext(resources, component.key(), component.plural_key(), component.n()), getComponentArguments(component)));
	}
	public @NonNull MessageFormat npgettext(final @NonNull String msgctxt, final @NonNull String msgid, final @NonNull String msgid_plural, final long n, final @NonNull Locale locale) {
		setResources(locale);
		return new MessageFormat(GettextResource.npgettext(resources, msgctxt, msgid, msgid_plural, n));
	}
	public @NonNull Component npgettext(final @NonNull TranslatableContextualPluralComponent component, final @NonNull Locale locale) {
		setResources(locale);
		return Component.text(MessageFormat.format(GettextResource.npgettext(resources, component.context(), component.key(), component.plural_key(), component.n()), getComponentArguments(component)));
	}
	public @NonNull MessageFormat pgettext(final @NonNull String msgctxt, final @NonNull String msgid, final @NonNull Locale locale) {
		setResources(locale);
		return new MessageFormat(GettextResource.pgettext(resources, msgctxt, msgid));
	}
	public @NonNull Component pgettext(final @NonNull TranslatableContextualComponent component, final @NonNull Locale locale) {
		setResources(locale);
		return Component.text(MessageFormat.format(GettextResource.pgettext(resources, component.context(), component.key()), getComponentArguments(component)));
	}
}
