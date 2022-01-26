package fr.sylvainjanet.personal_website.dto.entities;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;
import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguage;

@XmlRootElement(name = Public.LOCALIZED_STRING_NAME)
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalizedStringDto extends EntityDto {

	private static final long serialVersionUID = -7339399426658243855L;

	private Map<SupportedLanguage, String> strings;

	public LocalizedStringDto() {
		super();
		this.strings = new HashMap<SupportedLanguage, String>();
	}

	public LocalizedStringDto(Map<SupportedLanguage, String> strings) {
		super();
		this.strings = strings;
	}

	public LocalizedStringDto(long id, int version) {
		super(id, version);
		this.strings = new HashMap<SupportedLanguage, String>();
	}

	public LocalizedStringDto(long id, int version, Map<SupportedLanguage, String> strings) {
		super(id, version);
		this.strings = strings;
	}

	public Map<SupportedLanguage, String> getStrings() {
		return strings;
	}

	public void setStrings(Map<SupportedLanguage, String> strings) {
		this.strings = strings;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LanguagedStringDto [id=").append(id).append(", version=").append(version).append(", strings=")
				.append(strings).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((strings == null) ? 0 : strings.hashCode());
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
		LocalizedStringDto other = (LocalizedStringDto) obj;
		if (strings == null) {
			if (other.strings != null)
				return false;
		} else if (!strings.equals(other.strings))
			return false;
		return ((EntityDto) this).equals((EntityDto) obj);
	}

}
