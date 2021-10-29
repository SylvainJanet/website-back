package fr.sylvainjanet.personal_website.dto.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;

@XmlRootElement(name = Public.WEBPAGE_CATEGORY_MAIN_NAME)
@XmlAccessorType(XmlAccessType.FIELD)
public class WebPageCategoryMainDto extends EntityDto {

	private static final long serialVersionUID = 6401759692371459270L;

	private LanguagedStringDto title;

	private LanguagedStringDto content;

	public WebPageCategoryMainDto() {
		super();
	}

	public WebPageCategoryMainDto(LanguagedStringDto title, LanguagedStringDto content) {
		super();
		this.title = title;
		this.content = content;
	}

	public WebPageCategoryMainDto(int id, int version) {
		super(id, version);
	}

	public WebPageCategoryMainDto(int id, int version, LanguagedStringDto title, LanguagedStringDto content) {
		super(id, version);
		this.title = title;
		this.content = content;
	}

	public LanguagedStringDto getTitle() {
		return title;
	}

	public void setTitle(LanguagedStringDto title) {
		this.title = title;
	}

	public LanguagedStringDto getContent() {
		return content;
	}

	public void setContent(LanguagedStringDto content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WebPageCategoryMainDto [id=").append(id).append(", version=").append(version).append(", title=")
				.append(title).append(", content=").append(content).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		WebPageCategoryMainDto other = (WebPageCategoryMainDto) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return ((EntityDto) this).equals((EntityDto) obj);
	}

}