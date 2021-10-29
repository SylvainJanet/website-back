package fr.sylvainjanet.personal_website.dto.entities;

import java.io.Serializable;

public abstract class EntityDto implements Serializable {

	private static final long serialVersionUID = 3113851343215099254L;

	protected long id;

	protected int version;

	public EntityDto() {
		super();
	}

	public EntityDto(long id, int version) {
		super();
		this.id = id;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityDto other = (EntityDto) obj;
		if (id != other.id)
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	
}
