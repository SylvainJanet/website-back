package fr.sylvainjanet.personal_website.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import fr.sylvainjanet.personal_website.constants.db.DbTableName;
import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguage;
import fr.sylvainjanet.personal_website.entities.interfaces.IPage;

@Entity(name = DbTableName.PAGE)
public class Page extends MyEntity implements IPage {

	private static final long serialVersionUID = -8885616416910636614L;

	@ManyToOne
	private LocalizedString title;

	@ManyToOne
	private LocalizedString content;

	public Page() {
		super();
		this.title = new LocalizedString();
		this.content = new LocalizedString();
	}

	public Page(LocalizedString title, LocalizedString content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Page(long id, int version) {
		super(id, version);
		this.title = new LocalizedString();
		this.content = new LocalizedString();
	}

	public Page(long id, int version, LocalizedString title, LocalizedString content) {
		super(id, version);
		this.title = title;
		this.content = content;
	}

	public LocalizedString getTitle() {
		return title;
	}

	public void setTitle(LocalizedString title) {
		this.title = title;
	}

	public LocalizedString getContent() {
		return content;
	}

	public void setContent(LocalizedString content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebPageCategoryMain [id=").append(id).append(", version=").append(version).append(", title=")
				.append(title).append(", content=").append(content).append("]");
		return builder.toString();
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
	public String getContent(SupportedLanguage language) {
		return this.content.get(language);
	}

	@Override
	public void setContent(String content, SupportedLanguage language) {
		this.content.set(content, language);
	}

}
