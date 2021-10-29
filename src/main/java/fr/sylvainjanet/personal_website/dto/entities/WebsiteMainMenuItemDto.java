package fr.sylvainjanet.personal_website.dto.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;

@XmlRootElement(name = Public.WEBSITE_MAIN_MENU_ITEM_NAME)
@XmlAccessorType(XmlAccessType.FIELD)
public class WebsiteMainMenuItemDto extends EntityDto {

	private static final long serialVersionUID = 5646053382165525187L;

	private List<Integer> subitemsIds;

	private WebPageCategoryMainDto webpageCategoryMain;

	private LanguagedStringDto languagedTitle;

	public WebsiteMainMenuItemDto() {
		super();
		this.subitemsIds = new ArrayList<Integer>();
	}

	public WebsiteMainMenuItemDto(List<Integer> subitems) {
		super();
		this.subitemsIds = subitems;
	}

	public WebsiteMainMenuItemDto(WebPageCategoryMainDto webpageCategoryMain) {
		super();
		this.webpageCategoryMain = webpageCategoryMain;
		this.subitemsIds = new ArrayList<Integer>();
	}

	public WebsiteMainMenuItemDto(List<Integer> subitems, WebPageCategoryMainDto webpageCategoryMain) {
		super();
		this.subitemsIds = subitems;
		this.webpageCategoryMain = webpageCategoryMain;
	}

	public WebsiteMainMenuItemDto(int id, int version) {
		super(id, version);
		this.subitemsIds = new ArrayList<Integer>();
	}

	public WebsiteMainMenuItemDto(int id, int version, List<Integer> subitems) {
		super(id, version);
		this.subitemsIds = subitems;
	}

	public WebsiteMainMenuItemDto(int id, int version, WebPageCategoryMainDto webpageCategoryMain) {
		super(id, version);
		this.webpageCategoryMain = webpageCategoryMain;
		this.subitemsIds = new ArrayList<Integer>();
	}

	public WebsiteMainMenuItemDto(int id, int version, List<Integer> subitems,
			WebPageCategoryMainDto webPageCategoryMain) {
		super(id, version);
		this.subitemsIds = subitems;
		this.webpageCategoryMain = webPageCategoryMain;
	}
	
	public WebsiteMainMenuItemDto(LanguagedStringDto languagedTitle) {
		super();
		this.subitemsIds = new ArrayList<Integer>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDto(List<Integer> subitems,LanguagedStringDto languagedTitle) {
		super();
		this.subitemsIds = subitems;
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDto(WebPageCategoryMainDto webpageCategoryMain,LanguagedStringDto languagedTitle) {
		super();
		this.webpageCategoryMain = webpageCategoryMain;
		this.subitemsIds = new ArrayList<Integer>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDto(List<Integer> subitems, WebPageCategoryMainDto webpageCategoryMain,LanguagedStringDto languagedTitle) {
		super();
		this.subitemsIds = subitems;
		this.webpageCategoryMain = webpageCategoryMain;
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDto(int id, int version,LanguagedStringDto languagedTitle) {
		super(id, version);
		this.subitemsIds = new ArrayList<Integer>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDto(int id, int version, List<Integer> subitems,LanguagedStringDto languagedTitle) {
		super(id, version);
		this.subitemsIds = subitems;
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDto(int id, int version, WebPageCategoryMainDto webpageCategoryMain,LanguagedStringDto languagedTitle) {
		super(id, version);
		this.webpageCategoryMain = webpageCategoryMain;
		this.subitemsIds = new ArrayList<Integer>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDto(int id, int version, List<Integer> subitems,
			WebPageCategoryMainDto webPageCategoryMain,LanguagedStringDto languagedTitle) {
		super(id, version);
		this.subitemsIds = subitems;
		this.webpageCategoryMain = webPageCategoryMain;
		this.languagedTitle = languagedTitle;
	}

	public List<Integer> getSubitemsIds() {
		return subitemsIds;
	}

	public void setSubitemsIds(List<Integer> subitemsIds) {
		this.subitemsIds = subitemsIds;
	}

	public WebPageCategoryMainDto getWebpageCategoryMain() {
		return webpageCategoryMain;
	}

	public void setWebpageCategoryMain(WebPageCategoryMainDto webpageCategoryMain) {
		this.webpageCategoryMain = webpageCategoryMain;
	}
	
	public LanguagedStringDto getLanguagedTitle() {
		return languagedTitle;
	}

	public void setLanguagedTitle(LanguagedStringDto languagedTitle) {
		this.languagedTitle = languagedTitle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebsiteMainMenuItemDto [id=").append(id).append(", version=").append(version)
				.append(", subitemsIds=").append(subitemsIds).append(", webpageCategoryMain=")
				.append(webpageCategoryMain).append(", languagedTitle=").append(languagedTitle).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((languagedTitle == null) ? 0 : languagedTitle.hashCode());
		result = prime * result + ((subitemsIds == null) ? 0 : subitemsIds.hashCode());
		result = prime * result + ((webpageCategoryMain == null) ? 0 : webpageCategoryMain.hashCode());
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
		WebsiteMainMenuItemDto other = (WebsiteMainMenuItemDto) obj;
		if (languagedTitle == null) {
			if (other.languagedTitle != null)
				return false;
		} else if (!languagedTitle.equals(other.languagedTitle))
			return false;
		if (subitemsIds == null) {
			if (other.subitemsIds != null)
				return false;
		} else if (!subitemsIds.equals(other.subitemsIds))
			return false;
		if (webpageCategoryMain == null) {
			if (other.webpageCategoryMain != null)
				return false;
		} else if (!webpageCategoryMain.equals(other.webpageCategoryMain))
			return false;
		return ((EntityDto) this).equals((EntityDto) obj);
	}

}
