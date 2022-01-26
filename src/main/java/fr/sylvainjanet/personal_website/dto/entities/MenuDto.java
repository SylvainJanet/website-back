package fr.sylvainjanet.personal_website.dto.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;
import fr.sylvainjanet.personal_website.constants.menu.MenuType;

@XmlRootElement(name = Public.MENU)
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuDto extends EntityDto {

	private static final long serialVersionUID = 2928372956417020467L;

	private List<MenuItemDto> items;

	private MenuType type;

	private int menuVersion;

	public MenuDto() {
		super();
		this.items = new ArrayList<MenuItemDto>();
	}

	public MenuDto(List<MenuItemDto> items, MenuType type, int menuVersion) {
		super();
		this.items = items;
		this.type = type;
		this.menuVersion = menuVersion;
	}

	public MenuDto(long id, int version) {
		super(id, version);
		this.items = new ArrayList<MenuItemDto>();
	}

	public MenuDto(long id, int version, List<MenuItemDto> items, MenuType type, int menuVersion) {
		super(id, version);
		this.items = items;
		this.type = type;
		this.menuVersion = menuVersion;
	}

	public List<MenuItemDto> getItems() {
		return items;
	}

	public void setItems(List<MenuItemDto> items) {
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
		builder.append("WebsiteMainMenuDto [id=").append(id).append(", version=").append(version).append(", items=")
				.append(items).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + menuVersion;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		MenuDto other = (MenuDto) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (menuVersion != other.menuVersion)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
