package fr.sylvainjanet.personal_website.dto.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;

@XmlRootElement(name = Public.PAGE)
@XmlAccessorType(XmlAccessType.FIELD)
public class PageDto extends EntityDto {

	private static final long serialVersionUID = 6401759692371459270L;

	private LocalizedStringDto title;

	private LocalizedStringDto content;

	public PageDto() {
		super();
	}

	public PageDto(LocalizedStringDto title, LocalizedStringDto content) {
		super();
		this.title = title;
		this.content = content;
	}

	public PageDto(long id, int version) {
		super(id, version);
	}

	public PageDto(long id, int version, LocalizedStringDto title, LocalizedStringDto content) {
		super(id, version);
		this.title = title;
		this.content = content;
	}

	public LocalizedStringDto getTitle() {
		return title;
	}

	public void setTitle(LocalizedStringDto title) {
		this.title = title;
	}

	public LocalizedStringDto getContent() {
		return content;
	}

	public void setContent(LocalizedStringDto content) {
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
		PageDto other = (PageDto) obj;
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