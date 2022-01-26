package fr.sylvainjanet.personal_website.dto.entities.partial;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;
import fr.sylvainjanet.personal_website.dto.entities.EntityDto;
import fr.sylvainjanet.personal_website.dto.entities.LocalizedStringDto;
import fr.sylvainjanet.personal_website.dto.entities.PageDto;

@XmlRootElement(name = Public.MENU_ITEM)
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuItemDtoLevel2 extends EntityDto {

	private static final long serialVersionUID = 5646053382165525187L;

	private List<MenuItemDtoLevel1> subItems;

	private int depth;

	private int rank;

	private Long menuId;

	private LocalizedStringDto title;

	private PageDto page;

	public MenuItemDtoLevel2() {
		super();
		this.depth = -1;
		this.rank = -1;
		this.menuId = -1L;
		this.subItems = new ArrayList<MenuItemDtoLevel1>();
		this.title = new LocalizedStringDto();
	}

	public MenuItemDtoLevel2(List<MenuItemDtoLevel1> subItems, int depth, int rank, Long menuId,
			LocalizedStringDto title, PageDto page) {
		super();
		this.depth = -1;
		this.rank = -1;
		this.menuId = -1L;
		this.subItems = subItems;
		this.depth = depth;
		this.rank = rank;
		this.menuId = menuId;
		this.title = title;
		this.page = page;
	}

	public MenuItemDtoLevel2(long id, int version) {
		super(id, version);
		this.depth = -1;
		this.rank = -1;
		this.menuId = -1L;
		this.subItems = new ArrayList<MenuItemDtoLevel1>();
		this.title = new LocalizedStringDto();
	}

	public MenuItemDtoLevel2(long id, int version, List<MenuItemDtoLevel1> subItems, int depth, int rank, Long menuId,
			LocalizedStringDto title, PageDto page) {
		super(id, version);
		this.depth = -1;
		this.rank = -1;
		this.menuId = -1L;
		this.subItems = subItems;
		this.depth = depth;
		this.rank = rank;
		this.menuId = menuId;
		this.title = title;
		this.page = page;
	}

	public List<MenuItemDtoLevel1> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<MenuItemDtoLevel1> subItems) {
		this.subItems = subItems;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public LocalizedStringDto getTitle() {
		return title;
	}

	public void setTitle(LocalizedStringDto title) {
		this.title = title;
	}

	public PageDto getPage() {
		return page;
	}

	public void setPage(PageDto page) {
		this.page = page;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + depth;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + rank;
		result = prime * result + ((subItems == null) ? 0 : subItems.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItemDtoLevel2 other = (MenuItemDtoLevel2) obj;
		if (depth != other.depth)
			return false;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (rank != other.rank)
			return false;
		if (subItems == null) {
			if (other.subItems != null)
				return false;
		} else if (!subItems.equals(other.subItems))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuItemDtoLevel2 [subItems=").append(subItems).append(", depth=").append(depth)
				.append(", rank=").append(rank).append(", menuId=").append(menuId).append(", title=").append(title)
				.append(", page=").append(page).append(", id=").append(id).append(", version=").append(version)
				.append("]");
		return builder.toString();
	}

}
