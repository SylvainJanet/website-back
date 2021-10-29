package fr.sylvainjanet.personal_website.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import fr.sylvainjanet.personal_website.constants.db.DbTableName;

@Entity(name = DbTableName.WEBSITE_MAIN_MENU_ITEM)
public class WebsiteMainMenuItem extends MyEntity {

	private static final long serialVersionUID = -8751076602858494071L;

	@ManyToAny(metaColumn = @Column(name = "subitems"))
	private List<WebsiteMainMenuItem> subitems;

	@ManyToOne
	private WebPageCategoryMain webpageCategoryMain;
	
	@ManyToOne
	private LanguagedString languagedTitle;

	public WebsiteMainMenuItem() {
		super();
		this.subitems = new ArrayList<WebsiteMainMenuItem>();
	}

	public WebsiteMainMenuItem(List<WebsiteMainMenuItem> subitems) {
		super();
		this.subitems = subitems;
	}

	public WebsiteMainMenuItem(WebPageCategoryMain webpageCategoryMain) {
		super();
		this.webpageCategoryMain = webpageCategoryMain;
		this.subitems = new ArrayList<WebsiteMainMenuItem>();
	}

	public WebsiteMainMenuItem(List<WebsiteMainMenuItem> subitems, WebPageCategoryMain webpageCategoryMain) {
		super();
		this.subitems = subitems;
		this.webpageCategoryMain = webpageCategoryMain;
	}

	public WebsiteMainMenuItem(int id, int version) {
		super(id, version);
		this.subitems = new ArrayList<WebsiteMainMenuItem>();
	}

	public WebsiteMainMenuItem(int id, int version, List<WebsiteMainMenuItem> subitems) {
		super(id, version);
		this.subitems = subitems;
	}

	public WebsiteMainMenuItem(int id, int version, WebPageCategoryMain webpageCategoryMain) {
		super(id, version);
		this.webpageCategoryMain = webpageCategoryMain;
		this.subitems = new ArrayList<WebsiteMainMenuItem>();
	}

	public WebsiteMainMenuItem(int id, int version, List<WebsiteMainMenuItem> subitems,
			WebPageCategoryMain webpageCategoryMain) {
		super(id, version);
		this.subitems = subitems;
		this.webpageCategoryMain = webpageCategoryMain;
	}
	
	public WebsiteMainMenuItem(LanguagedString languagedTitle) {
		super();
		this.subitems = new ArrayList<WebsiteMainMenuItem>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItem(List<WebsiteMainMenuItem> subitems,LanguagedString languagedTitle) {
		super();
		this.subitems = subitems;
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItem(WebPageCategoryMain webpageCategoryMain,LanguagedString languagedTitle) {
		super();
		this.webpageCategoryMain = webpageCategoryMain;
		this.subitems = new ArrayList<WebsiteMainMenuItem>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItem(List<WebsiteMainMenuItem> subitems, WebPageCategoryMain webpageCategoryMain,LanguagedString languagedTitle) {
		super();
		this.subitems = subitems;
		this.webpageCategoryMain = webpageCategoryMain;
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItem(int id, int version,LanguagedString languagedTitle) {
		super(id, version);
		this.subitems = new ArrayList<WebsiteMainMenuItem>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItem(int id, int version, List<WebsiteMainMenuItem> subitems,LanguagedString languagedTitle) {
		super(id, version);
		this.subitems = subitems;
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItem(int id, int version, WebPageCategoryMain webpageCategoryMain,LanguagedString languagedTitle) {
		super(id, version);
		this.webpageCategoryMain = webpageCategoryMain;
		this.subitems = new ArrayList<WebsiteMainMenuItem>();
		this.languagedTitle = languagedTitle;
	}

	public WebsiteMainMenuItem(int id, int version, List<WebsiteMainMenuItem> subitems,
			WebPageCategoryMain webpageCategoryMain,LanguagedString languagedTitle) {
		super(id, version);
		this.subitems = subitems;
		this.webpageCategoryMain = webpageCategoryMain;
		this.languagedTitle = languagedTitle;
	}

	public List<WebsiteMainMenuItem> getSubitems() {
		return subitems;
	}

	public void setSubitems(List<WebsiteMainMenuItem> subitems) {
		this.subitems = subitems;
	}

	public WebPageCategoryMain getWebpageCategoryMain() {
		return webpageCategoryMain;
	}

	public void setWebpageCategoryMain(WebPageCategoryMain webpageCategoryMain) {
		this.webpageCategoryMain = webpageCategoryMain;
	}
	
	public LanguagedString getLanguagedTitle() {
		return languagedTitle;
	}

	public void setLanguagedTitle(LanguagedString languagedTitle) {
		this.languagedTitle = languagedTitle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebsiteMainMenuItem [id=").append(id).append(", version=").append(version).append(", subitems=")
				.append(subitems).append(", webpageCategoryMain=").append(webpageCategoryMain)
				.append(", languagedTitle=").append(languagedTitle).append("]");
		return builder.toString();
	}

}
