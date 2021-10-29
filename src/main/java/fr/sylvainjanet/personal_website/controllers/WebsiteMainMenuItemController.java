package fr.sylvainjanet.personal_website.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sylvainjanet.personal_website.constants.api.uri.PublicUri;
import fr.sylvainjanet.personal_website.controllers.interfaces.IWebsiteMainMenuItemController;
import fr.sylvainjanet.personal_website.dto.entities.ListEntityDto;
import fr.sylvainjanet.personal_website.dto.entities.WebsiteMainMenuItemDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.WebsiteMainMenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.dto.entities.partial.WebsiteMainMenuItemDtoLevel2;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenuItem;
import fr.sylvainjanet.personal_website.services.interfaces.IWebsiteMainMenuItemService;

@RestController
@RequestMapping(PublicUri.WEBSITE_MAIN_MENU_ITEM_CONTROLLER)
public class WebsiteMainMenuItemController extends GenericCRUDController<WebsiteMainMenuItem, WebsiteMainMenuItemDto>
		implements IWebsiteMainMenuItemController {

	private IWebsiteMainMenuItemService websiteMainMenuItemService;

	public WebsiteMainMenuItemController(@Autowired IWebsiteMainMenuItemService websiteMainMenuItemService) {
		super(websiteMainMenuItemService);
		this.websiteMainMenuItemService = websiteMainMenuItemService;
	}

	@Override
	@GetMapping(value = PublicUri.WEBSITE_MAIN_MENU_ITEM_GETALL_LEVEL1, produces = "application/json")
	public ResponseEntity<?> getAllLevel1() {
		List<WebsiteMainMenuItemDtoLevel1> lst = websiteMainMenuItemService.getAllLevel1();
		ListEntityDto<WebsiteMainMenuItemDtoLevel1> lstDto = new ListEntityDto<WebsiteMainMenuItemDtoLevel1>(lst);
		return ResponseEntity.status(HttpStatus.OK).body(lstDto);
	}

	@Override
	@GetMapping(value = PublicUri.WEBSITE_MAIN_MENU_ITEM_GETALL_LEVEL2, produces = "application/json")
	public ResponseEntity<?> getAllLevel2() {
		List<WebsiteMainMenuItemDtoLevel2> lst = websiteMainMenuItemService.getAllLevel2();
		ListEntityDto<WebsiteMainMenuItemDtoLevel2> lstDto = new ListEntityDto<WebsiteMainMenuItemDtoLevel2>(lst);
		return ResponseEntity.status(HttpStatus.OK).body(lstDto);
	}

}
