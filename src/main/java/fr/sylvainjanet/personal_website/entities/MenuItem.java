package fr.sylvainjanet.personal_website.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import fr.sylvainjanet.personal_website.constants.db.DbTableName;
import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguage;
import fr.sylvainjanet.personal_website.entities.interfaces.IMenuItem;

@Entity(name = DbTableName.MENU_ITEM)
public class MenuItem extends MyEntity implements IMenuItem {

	private static final long serialVersionUID = -8751076602858494071L;

	@ManyToAny(metaColumn = @Column(name = "subitems"))
	private List<MenuItem> subItems;

	private int depth;

	private int itemRank;

	private Long menuId;

	@ManyToOne
	private LocalizedString title;

	@ManyToOne
	private Page page;

	public MenuItem() {
		super();
		this.depth = -1;
		this.itemRank = -1;
		this.menuId = -1L;
		this.subItems = new ArrayList<MenuItem>();
		this.title = new LocalizedString();
	}

	public MenuItem(List<MenuItem> subItems, int depth, int itemRank, Long menuId, LocalizedString title, Page page) {
		super();
		this.subItems = subItems;
		sortByRank();
		this.depth = depth;
		this.itemRank = itemRank;
		this.menuId = menuId;
		this.title = title;
		this.page = page;
	}

	public MenuItem(long id, int version) {
		super(id, version);
		this.depth = -1;
		this.itemRank = -1;
		this.menuId = -1L;
		this.subItems = new ArrayList<MenuItem>();
		this.title = new LocalizedString();
	}

	public MenuItem(long id, int version, List<MenuItem> subItems, int depth, int itemRank, Long menuId,
			LocalizedString title, Page page) {
		super(id, version);
		this.subItems = subItems;
		sortByRank();
		this.depth = depth;
		this.itemRank = itemRank;
		this.menuId = menuId;
		this.title = title;
		this.page = page;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuItem [subItems=").append(subItems).append(", depth=").append(depth).append(", itemRank=")
				.append(itemRank).append(", menuId=").append(menuId).append(", title=").append(title).append(", page=")
				.append(page).append(", id=").append(id).append(", version=").append(version).append("]");
		return builder.toString();
	}

	public List<MenuItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<MenuItem> subItems) {
		this.subItems = subItems;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getItemRank() {
		return itemRank;
	}

	public void setItemRank(int itemRank) {
		this.itemRank = itemRank;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
		for (MenuItem i : this.subItems) {
			i.setMenuId(menuId);
		}
	}

	public LocalizedString getTitle() {
		return title;
	}

	public void setTitle(LocalizedString title) {
		this.title = title;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private List<MenuItem> sortByRank(List<MenuItem> subItems) {
		return subItems.stream().sorted((i1, i2) -> Integer.compare(i1.getItemRank(), i2.getItemRank()))
				.collect(Collectors.toList());
	}

	@Override
	public int countItems() {
		return this.subItems.size();
	}

	@Override
	public void addItem(MenuItem item) {
		item.setDepth(this.depth + 1);
		item.setItemRank(this.countItems() + 1);
		item.setMenuId(this.getMenuId());
		this.subItems.add(item);

	}

	@Override
	public void addItem(MenuItem item, int rankk) {
		item.setDepth(this.depth + 1);
		item.setItemRank(rankk);
		item.setMenuId(this.getMenuId());
		for (MenuItem i : this.getSubItems()) {
			i.increaseRankForInsertion(rankk);
		}
		this.subItems.add(rankk, item);
	}

	@Override
	public void removeItem(MenuItem item) {
		item.setMenuId(null);
		for (MenuItem i : this.getSubItems()) {
			i.decreaseRankForDeletion(item.getItemRank());
		}
		this.subItems.remove(item);

	}

	@Override
	public void removeItem(int rankk) {
		for (MenuItem i : this.getSubItems()) {
			i.decreaseRankForDeletion(rankk);
		}
		this.subItems.remove(rankk);

	}

	@Override
	public String getTitle(SupportedLanguage language) {
		return this.title.get(language);
	}

	@Override
	public void setTitle(String title, SupportedLanguage language) {
		this.title.set(title, language);

	}

	@Override
	public void increaseRankForInsertion(int insertedrankk) {
		if (this.itemRank >= insertedrankk) {
			this.itemRank++;
		}
	}

	@Override
	public void decreaseRankForDeletion(int deletedrankk) {
		if (this.itemRank > deletedrankk) {
			this.itemRank--;
		}
		if (this.itemRank == deletedrankk) {
			this.itemRank = -1;
		}
	}

	@Override
	public void sortByRank() {
		this.subItems = sortByRank(this.subItems);
	}

}
