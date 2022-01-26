package fr.sylvainjanet.personal_website.entities.interfaces;

import fr.sylvainjanet.personal_website.entities.MenuItem;

public interface IMenu {
	int countItems();

	void addItem(MenuItem item);

	void addItem(MenuItem item, int rank);

	void removeItem(MenuItem item);

	void removeItem(int rank);
}
