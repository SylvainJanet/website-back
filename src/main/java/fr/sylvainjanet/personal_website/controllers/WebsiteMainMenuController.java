package fr.sylvainjanet.personal_website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sylvainjanet.personal_website.constants.api.uri.PublicUri;
import fr.sylvainjanet.personal_website.controllers.interfaces.IWebsiteMainMenuController;
import fr.sylvainjanet.personal_website.dto.entities.WebsiteMainMenuDto;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenu;
import fr.sylvainjanet.personal_website.services.interfaces.IWebsiteMainMenuService;

@RestController
@RequestMapping(PublicUri.WEBSITE_MAIN_MENU_CONTROLLER)
public class WebsiteMainMenuController extends GenericCRUDController<WebsiteMainMenu, WebsiteMainMenuDto>
		implements IWebsiteMainMenuController {

	public WebsiteMainMenuController(@Autowired IWebsiteMainMenuService websiteMainMenuService) {
		super(websiteMainMenuService);
	}

}
