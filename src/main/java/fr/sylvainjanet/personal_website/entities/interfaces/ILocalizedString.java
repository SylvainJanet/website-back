package fr.sylvainjanet.personal_website.entities.interfaces;

import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguage;

public interface ILocalizedString {

	String get(SupportedLanguage language);

	void set(String string, SupportedLanguage language);
}
