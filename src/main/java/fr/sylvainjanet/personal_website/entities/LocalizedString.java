package fr.sylvainjanet.personal_website.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyEnumerated;

import fr.sylvainjanet.personal_website.constants.db.DbTableName;
import fr.sylvainjanet.personal_website.constants.languages.Languages.SupportedLanguage;
import fr.sylvainjanet.personal_website.entities.interfaces.ILocalizedString;

@Entity(name = DbTableName.LOCALIZED_STRING)
public class LocalizedString extends MyEntity implements ILocalizedString {

	private static final long serialVersionUID = -6389753944970458422L;

	public static final String NO_TRANSLATION = "not translated";

	@ElementCollection(targetClass = String.class)
	@MapKeyClass(SupportedLanguage.class)
	@MapKeyEnumerated(EnumType.STRING)
	private Map<SupportedLanguage, String> strings;

	public LocalizedString() {
		super();
		this.strings = new HashMap<SupportedLanguage, String>();
		for (SupportedLanguage l : SupportedLanguage.values()) {
			this.strings.put(l, NO_TRANSLATION);
		}
	}

	public LocalizedString(Map<SupportedLanguage, String> strings) {
		super();
		this.strings = strings;
		for (SupportedLanguage l : SupportedLanguage.values()) {
			if (!this.strings.containsKey(l)) {
				this.strings.put(l, NO_TRANSLATION);
			}
		}
	}

	public LocalizedString(long id, int version) {
		super(id, version);
		this.strings = new HashMap<SupportedLanguage, String>();
		for (SupportedLanguage l : SupportedLanguage.values()) {
			this.strings.put(l, NO_TRANSLATION);
		}
	}

	public LocalizedString(long id, int version, Map<SupportedLanguage, String> strings) {
		super(id, version);
		this.strings = strings;
		for (SupportedLanguage l : SupportedLanguage.values()) {
			if (!this.strings.containsKey(l)) {
				this.strings.put(l, NO_TRANSLATION);
			}
		}
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
		builder.append("LanguagedString [id=").append(id).append(", version=").append(version).append(", strings=")
				.append(strings).append("]");
		return builder.toString();
	}
	
	@Override
	public String get(SupportedLanguage language) {
		return this.strings.get(language);
	}

	@Override
	public void set(String string, SupportedLanguage language) {
		this.strings.put(language, string);
	}


}
