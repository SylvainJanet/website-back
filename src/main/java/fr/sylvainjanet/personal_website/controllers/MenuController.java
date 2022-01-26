package fr.sylvainjanet.personal_website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sylvainjanet.personal_website.constants.api.uri.PublicUri;
import fr.sylvainjanet.personal_website.controllers.interfaces.IMenuController;
import fr.sylvainjanet.personal_website.dto.entities.MenuDto;
import fr.sylvainjanet.personal_website.entities.Menu;
import fr.sylvainjanet.personal_website.services.interfaces.IMenuService;

@RestController
@RequestMapping(PublicUri.MENU_CONTROLLER)
public class MenuController extends GenericCRUDController<Menu, MenuDto> implements IMenuController {

	public MenuController(@Autowired IMenuService menuService) {
		super(menuService);
	}

}
