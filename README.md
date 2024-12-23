# GNUplusAdventure

A GNU gettext wrapper library for [net.kyori.adventure](https://github.com/KyoriPowered/adventure).

## Usage

Add the GettextTranslator as a source to the GlobalTranslator by writing:

```java
GlobalTranslator.translator().addSource(com.minersstudios.gnuplusadventure.GettextTranslator);
```

Then use the appropriate `translate()` method to get translations from the resource
bundle named like `Locale.toString()`'s output. If none is found, key will be
returned unchanged. Thus, keys are the English/ASCII version of the messages
and remove the need for a plugin developer to use the fallback mechanism provided by
the `net.kyori.adventure.text` package.
