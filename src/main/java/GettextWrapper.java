package ua.com.minersstudios.gnuplusadventure;
import gnu.gettext.GettextResource;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

@lombok.ToString @lombok.EqualsAndHashCode
public final class GettextWrapper implements net.kyori.adventure.translation.Translator {
	private ResourceBundle resources;
	@Override public @NotNull Key name() { return Key.key("gettext", "translations"); }
	@Override public @NotNull MessageFormat translate(final @NotNull String msgid, final @NotNull Locale locale) {
		resources = ResourceBundle.getBundle(locale.toString());
		return new MessageFormat(GettextResource.gettext(resources, msgid));
	}
	@Override public @NotNull Component translate(final @NotNull net.kyori.adventure.text.TranslatableComponent component, final @NotNull Locale locale) {
		resources = ResourceBundle.getBundle(locale.toString());
		return Component.text(MessageFormat.format(GettextResource.gettext(resources, component.key()), component.arguments()));
	}
	public @NotNull MessageFormat ngettext(final @NotNull String msgid, final @NotNull String msgid_plural, final long n, final @NotNull Locale locale) {
		resources = ResourceBundle.getBundle(locale.toString());
		return new MessageFormat(GettextResource.ngettext(resources, msgid, msgid_plural, n));
	}
	public @NotNull MessageFormat npgettext(final @NotNull String msgctxt, final @NotNull String msgid, final @NotNull String msgid_plural, final long n, final @NotNull Locale locale) {
		resources = ResourceBundle.getBundle(locale.toString());
		return new MessageFormat(GettextResource.npgettext(resources, msgctxt, msgid, msgid_plural, n));
	}
	public @NotNull MessageFormat pgettext(final @NotNull String msgctxt, final @NotNull String msgid, final @NotNull Locale locale) {
		resources = ResourceBundle.getBundle(locale.toString());
		return new MessageFormat(GettextResource.pgettext(resources, msgctxt, msgid));
	}
}
