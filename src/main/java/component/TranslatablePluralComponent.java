package ua.com.minersstudios.gnuplusadventure.component;
import lombok.NonNull;

public interface TranslatablePluralComponent extends net.kyori.adventure.text.TranslatableComponent {
	public @NonNull String plural_key();
	public void plural_key(final @NonNull String plural_key);
	public long n();
	public void n(final long n);
}
