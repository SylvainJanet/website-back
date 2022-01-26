package fr.sylvainjanet.personal_website.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.sylvainjanet.personal_website.constants.db.DbTableName;
import fr.sylvainjanet.personal_website.constants.menu.MenuType;
import fr.sylvainjanet.personal_website.entities.interfaces.IMenu;

@Entity(name = DbTableName.MENU)
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "type", "menuVersion"}) })
public class Menu extends MyEntity implements IMenu {

	private static final long serialVersionUID = -5759801712160775936L;

	@ManyToMany
	private List<MenuItem> items;

	private MenuType type;

	private int menuVersion;

	public Menu() {
		super();
		this.items = new ArrayList<MenuItem>();
	}

	public Menu(List<MenuItem> items, MenuType type, int menuVersion) {
		super();
		this.items = items;
		this.type = type;
		this.menuVersion = menuVersion;
	}

	public Menu(long id, int version) {
		super(id, version);
		this.items = new ArrayList<MenuItem>();
	}

	public Menu(long id, int version, List<MenuItem> items, MenuType type, int menuVersion) {
		super(id, version);
		this.items = items;
		this.type = type;
		this.menuVersion = menuVersion;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}

	public MenuType getType() {
		return type;
	}

	public void setType(MenuType type) {
		this.type = type;
	}

	public int getMenuVersion() {
		return menuVersion;
	}

	public void setMenuVersion(int menuVersion) {
		this.menuVersion = menuVersion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Menu [items=").append(items).append(", type=").append(type).append(", menuVersion=")
				.append(menuVersion).append(", id=").append(id).append(", version=").append(version).append("]");
		return builder.toString();
	}

	@Override
	public int countItems() {
		return this.items.size();
	}

	@Override
	public void addItem(MenuItem item) {
		item.setDepth(0);
		item.setItemRank(this.countItems() + 1);
		item.setMenuId(this.getId());
		this.items.add(item);

	}

	@Override
	public void addItem(MenuItem item, int rank) {
		item.setDepth(0);
		item.setItemRank(rank);
		item.setMenuId(this.getId());
		for (MenuItem i : this.getItems()) {
			i.increaseRankForInsertion(rank);
		}
		this.items.add(rank, item);

	}

	@Override
	public void removeItem(MenuItem item) {
		item.setMenuId(null);
		for (MenuItem i : this.getItems()) {
			i.decreaseRankForDeletion(item.getItemRank());
		}
		this.items.remove(item);

	}

	@Override
	public void removeItem(int rank) {
		for (MenuItem i : this.getItems()) {
			i.decreaseRankForDeletion(rank);
		}
		this.items.remove(rank);

	}

}
