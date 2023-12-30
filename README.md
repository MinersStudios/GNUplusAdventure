# GNUplusAdventure

GNU gettext wrapper library for [net.kyori.adventure](https://github.com/KyoriPowered/adventure).

## Usage

Add GettextWrapper to GlobalTranslator by writing:

```java
GlobalTranslator.get().addSource(ua.com.minersstudios.gnuplusadventure.GettextWrapper);
```

Then use `translate()` (`gettext()`), `ngettext()`, `npgettext()`, `pgettext()` to get
translations from the resource bundle named like `Locale.toString()`'s output.
If none is found, key will be returned unchanged. Thus, keys are the
English/ASCII version of the messages and remove need for a plugin developer
to use fallback mechanism provided by the `net.kyori.adventure.text` package.
