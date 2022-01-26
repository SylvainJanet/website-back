package fr.sylvainjanet.personal_website.services.interfaces;

import java.util.List;

import fr.sylvainjanet.personal_website.dto.entities.MenuItemDto;
import fr.sylvainjanet.personal_website.dto.entities.partial.MenuItemDtoLevel1;
import fr.sylvainjanet.personal_website.dto.entities.partial.MenuItemDtoLevel2;
import fr.sylvainjanet.personal_website.services.IGenericService;

public interface IMenuItemService extends IGenericService<MenuItemDto> {

	List<MenuItemDtoLevel1> getAllLevel1();

	List<MenuItemDtoLevel2> getAllLevel2();
}
