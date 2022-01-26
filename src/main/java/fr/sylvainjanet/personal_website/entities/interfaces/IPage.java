package fr.sylvainjanet.personal_website.entities.interfaces;

import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguage;

public interface IPage {

	String getTitle(SupportedLanguage language);

	void setTitle(String title, SupportedLanguage language);

	String getContent(SupportedLanguage language);

	void setContent(String content, SupportedLanguage language);

}
