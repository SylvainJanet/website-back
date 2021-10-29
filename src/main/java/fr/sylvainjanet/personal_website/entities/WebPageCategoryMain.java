package fr.sylvainjanet.personal_website.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import fr.sylvainjanet.personal_website.constants.db.DbTableName;

@Entity(name = DbTableName.WEBPAGE_CATEGORY_MAIN)
public class WebPageCategoryMain extends MyEntity {

	private static final long serialVersionUID = -8885616416910636614L;

	@ManyToOne
	private LanguagedString title;

	@ManyToOne
	private LanguagedString content;

	public WebPageCategoryMain() {
		super();
	}

	public WebPageCategoryMain(LanguagedString title, LanguagedString content) {
		super();
		this.title = title;
		this.content = content;
	}

	public WebPageCategoryMain(int id, int version) {
		super(id, version);
	}

	public WebPageCategoryMain(int id, int version, LanguagedString title, LanguagedString content) {
		super(id, version);
		this.title = title;
		this.content = content;
	}

	public LanguagedString getTitle() {
		return title;
	}

	public void setTitle(LanguagedString title) {
		this.title = title;
	}

	public LanguagedString getContent() {
		return content;
	}

	public void setContent(LanguagedString content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebPageCategoryMain [id=").append(id).append(", version=").append(version).append(", title=")
				.append(title).append(", content=").append(content).append("]");
		return builder.toString();
	}

}
