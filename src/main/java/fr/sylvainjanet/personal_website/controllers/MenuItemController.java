package fr.sylvainjanet.personal_website.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sylvainjanet.personal_website.constants.api.uri.PublicUri;
import fr.sylvainjanet.personal_website.controllers.interfaces.IMenuItemController;
import fr.sylvainjanet.personal_website.dto.entities.ListEntityDto;
import fr.sylvainjanet.personal_website.dto.entities.MenuItemDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.MenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.dto.entities.partial.MenuItemDtoLevel2;
import fr.sylvainjanet.personal_website.entities.MenuItem;
import fr.sylvainjanet.personal_website.services.interfaces.IMenuItemService;

@RestController
@RequestMapping(PublicUri.MENU_ITEM_CONTROLLER)
public class MenuItemController extends GenericCRUDController<MenuItem, MenuItemDto> implements IMenuItemController {

	private IMenuItemService menuItemService;

	public MenuItemController(@Autowired IMenuItemService menuItemService) {
		super(menuItemService);
		this.menuItemService = menuItemService;
	}

	@Override
	@GetMapping(value = PublicUri.MENU_ITEM_GETALL_LEVEL1, produces = "application/json")
	public ResponseEntity<?> getAllLevel1() {
		List<MenuItemDtoLevel1> lst = menuItemService.getAllLevel1();
		ListEntityDto<MenuItemDtoLevel1> lstDto = new ListEntityDto<MenuItemDtoLevel1>(lst);
		return ResponseEntity.status(HttpStatus.OK).body(lstDto);
	}

	@Override
	@GetMapping(value = PublicUri.MENU_ITEM_GETALL_LEVEL2, produces = "application/json")
	public ResponseEntity<?> getAllLevel2() {
		List<MenuItemDtoLevel2> lst = menuItemService.getAllLevel2();
		ListEntityDto<MenuItemDtoLevel2> lstDto = new ListEntityDto<MenuItemDtoLevel2>(lst);
		return ResponseEntity.status(HttpStatus.OK).body(lstDto);
	}

}
