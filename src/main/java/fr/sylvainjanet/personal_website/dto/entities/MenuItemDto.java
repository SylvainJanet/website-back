package fr.sylvainjanet.personal_website.dto.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;

@XmlRootElement(name = Public.MENU_ITEM)
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuItemDto extends EntityDto {

	private static final long serialVersionUID = 5646053382165525187L;

	private List<Long> subItemsIds;

	private int depth;

	private int rank;

	private Long menuId;

	private LocalizedStringDto title;

	private PageDto page;

	public MenuItemDto() {
		super();
		this.depth = -1;
		this.rank = -1;
		this.menuId = -1L;
		this.subItemsIds = new ArrayList<Long>();
		this.title = new LocalizedStringDto();
	}

	public MenuItemDto(List<Long> subItemsIds, int depth, int rank, Long menuId, LocalizedStringDto title,
			PageDto page) {
		super();
		this.subItemsIds = subItemsIds;
		this.depth = depth;
		this.rank = rank;
		this.menuId = menuId;
		this.title = title;
		this.page = page;
	}

	public MenuItemDto(long id, int version) {
		super(id, version);
		this.depth = -1;
		this.rank = -1;
		this.menuId = -1L;
		this.subItemsIds = new ArrayList<Long>();
		this.title = new LocalizedStringDto();
	}

	public MenuItemDto(long id, int version, List<Long> subItemsIds, int depth, int rank, Long menuId,
			LocalizedStringDto title, PageDto page) {
		super(id, version);
		this.subItemsIds = subItemsIds;
		this.depth = depth;
		this.rank = rank;
		this.menuId = menuId;
		this.title = title;
		this.page = page;
	}

	public List<Long> getSubItemsIds() {
		return subItemsIds;
	}

	public void setSubItemsIds(List<Long> subItemsIds) {
		this.subItemsIds = subItemsIds;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuItemDto [subItemsIds=").append(subItemsIds).append(", depth=").append(depth)
				.append(", rank=").append(rank).append(", menuId=").append(menuId).append(", title=").append(title)
				.append(", page=").append(page).append(", id=").append(id).append(", version=").append(version)
				.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + depth;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result + rank;
		result = prime * result + ((subItemsIds == null) ? 0 : subItemsIds.hashCode());
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
		MenuItemDto other = (MenuItemDto) obj;
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
		if (subItemsIds == null) {
			if (other.subItemsIds != null)
				return false;
		} else if (!subItemsIds.equals(other.subItemsIds))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
