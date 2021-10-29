package fr.sylvainjanet.personal_website.constants.api.uri;

import org.springframework.http.HttpMethod;

public class PublicUriInitDb {

	public static final String CONTROLLER = "/api/initDb";
	public static final String RESETDB = "/reset";
	public static final HttpMethod RESETDB_METHOD = HttpMethod.GET;

}
