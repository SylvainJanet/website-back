package fr.sylvainjanet.personal_website.dto.entities.partial;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;
import fr.sylvainjanet.personal_website.dto.entities.EntityDto;
import fr.sylvainjanet.personal_website.dto.entities.LanguagedStringDto;
import fr.sylvainjanet.personal_website.dto.entities.WebPageCategoryMainDto;

@XmlRootElement(name = Public.WEBSITE_MAIN_MENU_ITEM_NAME)
@XmlAccessorType(XmlAccessType.FIELD)
public class WebsiteMainMenuItemDtoLevel2 extends EntityDto {

	private static final long serialVersionUID = 5646053382165525187L;

	private List<WebsiteMainMenuItemDtoLevel1> subitems;

	private WebPageCategoryMainDto webPageCategoryMain;

	private LanguagedStringDto languagedTitle;

	public WebsiteMainMenuItemDtoLevel2() {
		super();
		this.subitems = new ArrayList<WebsiteMainMenuItemDtoLevel1>();
	}

	public WebsiteMainMenuItemDtoLevel2(List<WebsiteMainMenuItemDtoLevel1> subitems) {
		super();
		this.subitems = subitems;
	}

	public WebsiteMainMenuItemDtoLevel2(WebPageCategoryMainDto webPageCategoryMain) {
		super();
		this.webPageCategoryMain = webPageCategoryMain;
		this.subitems = new ArrayList<WebsiteMainMenuItemDtoLevel1>();
	}

	public WebsiteMainMenuItemDtoLevel2(List<WebsiteMainMenuItemDtoLevel1> subitems,
			WebPageCategoryMainDto webPageCategoryMain) {
		super();
		this.subitems = subitems;
		this.webPageCategoryMain = webPageCategoryMain;
	}

	public WebsiteMainMenuItemDtoLevel2(int id, int version) {
		super(id, version);
		this.subitems = new ArrayList<WebsiteMainMenuItemDtoLevel1>();
	}

	public WebsiteMainMenuItemDtoLevel2(int id, int version, List<WebsiteMainMenuItemDtoLevel1> subitems) {
		super(id, version);
		this.subitems = subitems;
	}

	public WebsiteMainMenuItemDtoLevel2(int id, int version, WebPageCategoryMainDto webPageCategoryMain) {
		super(id, version);
		this.webPageCategoryMain = webPageCategoryMain;
		this.subitems = new ArrayList<WebsiteMainMenuItemDtoLevel1>();
	}

	public WebsiteMainMenuItemDtoLevel2(int id, int version, List<WebsiteMainMenuItemDtoLevel1> subitems,
			WebPageCategoryMainDto webPageCategoryMain) {
		super(id, version);
		this.subitems = subitems;
		this.webPageCategoryMain = webPageCategoryMain;
	}

	public WebsiteMainMenuItemDtoLevel2(LanguagedStringDto languagedTitle) {
		super();
		this.subitems = new ArrayList<WebsiteMainMenuItemDtoLevel1>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDtoLevel2(List<WebsiteMainMenuItemDtoLevel1> subitems,
			LanguagedStringDto languagedTitle) {
		super();
		this.subitems = subitems;
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDtoLevel2(WebPageCategoryMainDto webPageCategoryMain, LanguagedStringDto languagedTitle) {
		super();
		this.webPageCategoryMain = webPageCategoryMain;
		this.languagedTitle = languagedTitle;
		this.subitems = new ArrayList<WebsiteMainMenuItemDtoLevel1>();
	}

	public WebsiteMainMenuItemDtoLevel2(List<WebsiteMainMenuItemDtoLevel1> subitems,
			WebPageCategoryMainDto webPageCategoryMain, LanguagedStringDto languagedTitle) {
		super();
		this.subitems = subitems;
		this.webPageCategoryMain = webPageCategoryMain;
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDtoLevel2(int id, int version, LanguagedStringDto languagedTitle) {
		super(id, version);
		this.subitems = new ArrayList<WebsiteMainMenuItemDtoLevel1>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDtoLevel2(int id, int version, List<WebsiteMainMenuItemDtoLevel1> subitems,
			LanguagedStringDto languagedTitle) {
		super(id, version);
		this.subitems = subitems;
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDtoLevel2(int id, int version, WebPageCategoryMainDto webPageCategoryMain,
			LanguagedStringDto languagedTitle) {
		super(id, version);
		this.webPageCategoryMain = webPageCategoryMain;
		this.subitems = new ArrayList<WebsiteMainMenuItemDtoLevel1>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItemDtoLevel2(int id, int version, List<WebsiteMainMenuItemDtoLevel1> subitems,
			WebPageCategoryMainDto webPageCategoryMain, LanguagedStringDto languagedTitle) {
		super(id, version);
		this.subitems = subitems;
		this.webPageCategoryMain = webPageCategoryMain;
		this.languagedTitle = languagedTitle;
	}

	public List<WebsiteMainMenuItemDtoLevel1> getSubitems() {
		return subitems;
	}

	public void setSubitems(List<WebsiteMainMenuItemDtoLevel1> subitemsIds) {
		this.subitems = subitemsIds;
	}

	public WebPageCategoryMainDto getWebPageCategoryMain() {
		return webPageCategoryMain;
	}

	public void setWebPageCategoryMain(WebPageCategoryMainDto webPageCategoryMain) {
		this.webPageCategoryMain = webPageCategoryMain;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebsiteMainMenuItemDtoLevel2 [id=").append(id).append(", version=").append(version)
				.append(", subitems=").append(subitems).append(", webPageCategoryMain=").append(webPageCategoryMain)
				.append(", languagedTitle=").append(languagedTitle).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((languagedTitle == null) ? 0 : languagedTitle.hashCode());
		result = prime * result + ((subitems == null) ? 0 : subitems.hashCode());
		result = prime * result + ((webPageCategoryMain == null) ? 0 : webPageCategoryMain.hashCode());
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
		WebsiteMainMenuItemDtoLevel2 other = (WebsiteMainMenuItemDtoLevel2) obj;
		if (languagedTitle == null) {
			if (other.languagedTitle != null)
				return false;
		} else if (!languagedTitle.equals(other.languagedTitle))
			return false;
		if (subitems == null) {
			if (other.subitems != null)
				return false;
		} else if (!subitems.equals(other.subitems))
			return false;
		if (webPageCategoryMain == null) {
			if (other.webPageCategoryMain != null)
				return false;
		} else if (!webPageCategoryMain.equals(other.webPageCategoryMain))
			return false;
		return ((EntityDto) this).equals((EntityDto) obj);
	}

}
