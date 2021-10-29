package fr.sylvainjanet.personal_website.dto.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;

@XmlRootElement(name = Public.WEBSITE_MAIN_MENU_NAME)
@XmlAccessorType(XmlAccessType.FIELD)
public class WebsiteMainMenuDto extends EntityDto {

	private static final long serialVersionUID = 2928372956417020467L;

	private List<WebsiteMainMenuItemDto> items;

	public WebsiteMainMenuDto(List<WebsiteMainMenuItemDto> items) {
		super();
		this.items = items;
	}

	public WebsiteMainMenuDto() {
		super();
		this.items = new ArrayList<WebsiteMainMenuItemDto>();
	}

	public WebsiteMainMenuDto(int id, int version) {
		super(id, version);
		this.items = new ArrayList<WebsiteMainMenuItemDto>();
	}

	public WebsiteMainMenuDto(int id, int version, List<WebsiteMainMenuItemDto> items) {
		super(id, version);
		this.items = items;
	}

	public List<WebsiteMainMenuItemDto> getItems() {
		return items;
	}

	public void setItems(List<WebsiteMainMenuItemDto> items) {
		this.items = items;
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
		WebsiteMainMenuDto other = (WebsiteMainMenuDto) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return ((EntityDto) this).equals((EntityDto) obj);
	}

}
