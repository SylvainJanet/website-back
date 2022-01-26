package fr.sylvainjanet.personal_website.entities.interfaces;

import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguage;
import fr.sylvainjanet.personal_website.entities.MenuItem;

public interface IMenuItem {

	int countItems();

	void addItem(MenuItem item);

	void addItem(MenuItem item, int index);

	void removeItem(MenuItem item);

	void removeItem(int index);

	String getTitle(SupportedLanguage language);

	void setTitle(String title, SupportedLanguage language);

	void increaseRankForInsertion(int insertedRank);

	void decreaseRankForDeletion(int deletedRank);

	void sortByRank();
}
