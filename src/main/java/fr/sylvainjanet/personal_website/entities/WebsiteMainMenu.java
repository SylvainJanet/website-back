package fr.sylvainjanet.personal_website.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import fr.sylvainjanet.personal_website.constants.db.DbTableName;

@Entity(name = DbTableName.WEBSITE_MAIN_MENU)
public class WebsiteMainMenu extends MyEntity {

	private static final long serialVersionUID = -5759801712160775936L;

	@ManyToMany
	private List<WebsiteMainMenuItem> items;

	public WebsiteMainMenu(List<WebsiteMainMenuItem> items) {
		super();
		this.items = items;
	}

	public WebsiteMainMenu() {
		super();
		this.items = new ArrayList<WebsiteMainMenuItem>();
	}

	public WebsiteMainMenu(int id, int version) {
		super(id, version);
		this.items = new ArrayList<WebsiteMainMenuItem>();
	}

	public WebsiteMainMenu(int id, int version, List<WebsiteMainMenuItem> items) {
		super(id, version);
		this.items = items;
	}

	public List<WebsiteMainMenuItem> getItems() {
		return items;
	}

	public void setItems(List<WebsiteMainMenuItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebsiteMainMenu [id=").append(id).append(", version=").append(version).append(", items=")
				.append(items).append("]");
		return builder.toString();
	}

}
