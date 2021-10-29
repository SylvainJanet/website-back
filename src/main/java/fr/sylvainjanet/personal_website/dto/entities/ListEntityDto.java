package fr.sylvainjanet.personal_website.dto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.sylvainjanet.personal_website.constants.api.Public;

@XmlRootElement(name = Public.LISTENTITYDTO_XMLROOT)
@XmlAccessorType(XmlAccessType.FIELD)
public class ListEntityDto<T extends EntityDto> implements Serializable {

	private static final long serialVersionUID = 6437810714818436L;

	private List<T> entities;

	public ListEntityDto() {
		super();
		this.entities = new ArrayList<T>();
	}

	public ListEntityDto(List<T> entities) {
		super();
		this.entities = entities;
	}

	public List<T> getEntities() {
		return entities;
	}

	public void setEntities(List<T> entities) {
		this.entities = entities;
	}
}
