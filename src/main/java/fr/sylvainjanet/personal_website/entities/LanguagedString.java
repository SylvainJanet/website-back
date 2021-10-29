package fr.sylvainjanet.personal_website.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyEnumerated;

import fr.sylvainjanet.personal_website.constants.db.DbTableName;
import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguages;

@Entity(name = DbTableName.LANGUAGED_STRING)
public class LanguagedString extends MyEntity {

	private static final long serialVersionUID = -6389753944970458422L;

	@ElementCollection(targetClass = String.class)
	@MapKeyClass(SupportedLanguages.class)
	@MapKeyEnumerated(EnumType.STRING)
	private Map<SupportedLanguages, String> strings;

	public LanguagedString() {
		super();
		this.strings = new HashMap<SupportedLanguages, String>();
	}

	public LanguagedString(Map<SupportedLanguages, String> strings) {
		super();
		this.strings = strings;
	}

	public LanguagedString(int id, int version) {
		super(id, version);
		this.strings = new HashMap<SupportedLanguages, String>();
	}

	public LanguagedString(int id, int version, Map<SupportedLanguages, String> strings) {
		super(id, version);
		this.strings = strings;
	}

	public Map<SupportedLanguages, String> getStrings() {
		return strings;
	}

	public void setStrings(Map<SupportedLanguages, String> strings) {
		this.strings = strings;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LanguagedString [id=").append(id).append(", version=").append(version).append(", strings=")
				.append(strings).append("]");
		return builder.toString();
	}

}
